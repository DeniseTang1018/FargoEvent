package com.example.fargoevent.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fargoevent.R;
import com.example.fargoevent.Retrofit.Models.ListItem;
import com.example.fargoevent.Retrofit.Models.User;
import com.example.fargoevent.Retrofit.RetrofitClient;
import com.example.fargoevent.storage.SharedPrefManager;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This is the second activity for this app
 *
 */
public class ListView extends AppCompatActivity implements EventsAdapter.OnItemClickListener  {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    private String token;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ListView.this.setTitle("Events");
        User user = SharedPrefManager.getInstance(this).getUser();
//        Intent intent = getIntent();
//        token = intent.getStringExtra("token");
        token = user.getToken();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



//        recyclerView.setHasFixedSize(true);

        Call<List<ListItem>> call = RetrofitClient.getInstance().getApi().getEvents(token);
        call.enqueue(new Callback<List<ListItem>>() {
            @Override
            public void onResponse(Call<List<ListItem>> call, Response<List<ListItem>> response) {
                if(response.isSuccessful()){
                    listItems = response.body();
                    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                    initRecyclerView();

                }
            }

            @Override
            public void onFailure(Call<List<ListItem>> call, Throwable t) {
                Toast.makeText(ListView.this,"token failed",Toast.LENGTH_SHORT).show();

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(ListView.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.logout){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        SharedPrefManager.getInstance(this).clear();
        Intent intent = new Intent(ListView.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("id",listItems.get(position).getId());
        intent.putExtra("token",token);
        startActivity(intent);

    }
    private void initRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListView.this);
        adapter = new EventsAdapter(listItems, ListView.this,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}


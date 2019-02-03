package com.example.fargoevent;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.eventsListener{

    private TextView tVDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tVDetail = (TextView)findViewById(R.id.tVDetails);

        //the phone is in portrait mode
        if(findViewById(R.id.layout_default) != null){
            android.support.v4.app.FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction().hide(manager.findFragmentById(R.id.dFagment)).show(manager.findFragmentById(R.id.lFragment)).commit();
        }

        if(findViewById(R.id.layout_land) != null){
            android.support.v4.app.FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().show(manager.findFragmentById(R.id.lFragment)).show(manager.findFragmentById(R.id.dFagment)).commit();
        }

    }

    @Override
    public void onEventsSelected(int index) {

        if(findViewById(R.id.layout_default) !=null){
            android.support.v4.app.FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().hide(manager.findFragmentById(R.id.lFragment)).show(manager.findFragmentById(R.id.dFagment)).addToBackStack(null).commit();
        }
        String [] details = getResources().getStringArray(R.array.details);
        tVDetail.setText(details[index]);

    }
}

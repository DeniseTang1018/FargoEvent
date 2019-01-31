package com.example.fargoevent;

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

    }

    @Override
    public void onEventsSelected(int index) {
        String [] details = getResources().getStringArray(R.array.details);
        tVDetail.setText(details[index]);

    }
}

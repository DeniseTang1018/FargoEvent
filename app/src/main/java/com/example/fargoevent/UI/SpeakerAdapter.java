package com.example.fargoevent.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fargoevent.R;
import com.example.fargoevent.Retrofit.Models.Speaker;


import java.util.List;

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.ViewHolder> {

    private List<Speaker> speakersList;
    private Context context;

    public SpeakerAdapter(List<Speaker> speakersList, Context context) {
        this.speakersList = speakersList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_speakers,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Speaker speaker = speakersList.get(i); //speakerlist should contain speaker objects
        viewHolder.textViewDescrip.setText(speaker.getBio());
        viewHolder.textViewName.setText(speaker.getFirstName() + "  "+ speaker.getLastName());


    }

    @Override
    public int getItemCount() {
        return speakersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public TextView textViewDescrip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.tvSpeakerN);
            textViewDescrip = (TextView) itemView.findViewById(R.id.tvSpeakerD);
        }
    }
}

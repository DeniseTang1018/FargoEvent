package com.example.fargoevent.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fargoevent.R;
import com.example.fargoevent.Retrofit.Models.ListItem;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * This is adapter for events recycle view in the second activity
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;
    private OnItemClickListener mListener;



    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    public EventsAdapter(List<ListItem> listItems, Context context, OnItemClickListener onItemClickListener) {
        this.listItems = listItems;
        this.context = context;
        this.mListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,viewGroup,false);

        return new ViewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ListItem listItem = listItems.get(i);
        viewHolder.textViewTitle.setText(listItem.getTitle());
        Date sDate = null;
        Date eDate = null;
        String eventTime = "";
        try {

            sDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz").parse(listItem.getStartDateTime());

            eDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz").parse(listItem.getEndDateTime());
            eventTime = new SimpleDateFormat("yyyy-MM-dd KK:mm a").format(sDate)+ " - " + new SimpleDateFormat("KK:mm a").format(eDate) ;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        viewHolder.textViewTime.setText(eventTime);
        Picasso.get().load(listItem.getImageUrl()).fit().centerInside().into(viewHolder.imageView);


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewTitle ;
        public TextView textViewTime;
        public ImageView imageView;
        OnItemClickListener onItemClickListener;


        public ViewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener ) {
            super(itemView);
            textViewTime = (TextView) itemView.findViewById(R.id.tvTime);
            textViewTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            imageView= (ImageView)  itemView.findViewById(R.id.imageView);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

}

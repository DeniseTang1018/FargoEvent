package com.example.fargoevent;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends android.support.v4.app.ListFragment {


    private eventsListener eListener;
    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.events)));

        if(this.getActivity().findViewById(R.id.layout_default) == null){
            eListener.onEventsSelected(0);
        }

    }
    public interface eventsListener{
        public void onEventsSelected(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            eListener = (eventsListener)context;

        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ "must implement the interface called eventListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        eListener.onEventsSelected(position);
    }
}

package com.example.utkarshsharma.calc;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    private ActionListener actionlistener;
    public ListFrag() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.action)));
}
    public interface ActionListener
    {
        public void onActionSelected(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try
        {
            actionlistener=(ActionListener) context;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString()+"must implement the interface calleed"+"Actionlistener!");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        actionlistener.onActionSelected(position);
    }
}

package fernandeztilson.com.testdomiciliosandroid.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import fernandeztilson.com.testdomiciliosandroid.R;
import fernandeztilson.com.testdomiciliosandroid.helpers.ItemRecyclerViewAdapter;
import fernandeztilson.com.testdomiciliosandroid.models.Schools;


/**
 * Created by Tilson on 29/01/2018.
 */

public class FragmentSchool extends Fragment{

    private Schools schools;
    private OnListFragmentInteractionListener interactionListener;

    View view;
    private ImageView ic_btn_back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_schools, container, false);

        schools = MainActivity.schools;

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_schools);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        //recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Log.e("movie popular size", schools.toString());
        recyclerView.setAdapter(new ItemRecyclerViewAdapter(schools, interactionListener, context));

        Log.e("popular","yes");

        return view;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * <p/>
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Schools item);
    }
}

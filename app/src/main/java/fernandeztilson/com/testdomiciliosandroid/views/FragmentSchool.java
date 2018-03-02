package fernandeztilson.com.testdomiciliosandroid.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class FragmentSchool extends Fragment {
    /**
     * Definimos un objeto Schools
     */
    private Schools schools;
    /**
     * Definimos un objeto OnListFragmentInteractionListener
     */
    private OnListFragmentInteractionListener interactionListener;
    /**
     * Definimos un objeto View
     */
    private View view;
    /**
     * Definimos un objeto ImageView
     */
    private ImageView ic_btn_back;

    /**
     * Obtenermos el ciclo de vida onCreateView
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_schools, container, false);
        schools = MainActivity.schools;
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_schools);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new ItemRecyclerViewAdapter(schools, interactionListener, context));
        return view;
    }

    /**
     * Interfaz que puede ser implementada por actividades que contengan este fragmento para activar una interacción
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Schools item);
    }
}

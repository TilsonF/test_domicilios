package fernandeztilson.com.testdomiciliosandroid.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fernandeztilson.com.testdomiciliosandroid.R;
import fernandeztilson.com.testdomiciliosandroid.models.Schools;

import fernandeztilson.com.testdomiciliosandroid.views.FragmentSchool;
import fernandeztilson.com.testdomiciliosandroid.views.MapsActivity;


/**
 * Created by Tilson on 29/01/2018.
 */

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {
    /**
     * Definimos un objeto Schools
     */
    private final Schools schools;
    /**
     * Definimos un objeto Context
     */
    private Context context;
    /**
     * Definimos un objeto FragmentSchool.OnListFragmentInteractionListener
     */
    private final FragmentSchool.OnListFragmentInteractionListener interactionListener;

    /**.
     * @param schools
     * @param listener
     * @param context
     */
    public ItemRecyclerViewAdapter(Schools schools, FragmentSchool.OnListFragmentInteractionListener listener, Context context) {
        this.schools = schools;
        interactionListener = listener;
        this.context = context;
    }

    /**
     * Definimos una clase RecyclerView.ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * Definimos un objeto View
         */
        public final View mView;
        /**
         * Definimos un objeto ImageView
         */
        public ImageView poster;
        /**
         * Definimos un objeto TextView
         */
        public final TextView titleView;
        /**
         * Definimos un objeto LinearLayout
         */
        public final LinearLayout linearLayout;
        /**
         * Definimos un objeto Schools
         */
        public Schools schools;

        /**
         * @param view
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            titleView = (TextView) view.findViewById(R.id.description);
            poster = (ImageView) view.findViewById(R.id.img_url);
            linearLayout = (LinearLayout) view.findViewById(R.id.linear);
        }
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.e("position", position + "");
        holder.titleView.setText(schools.getSchoolBuses().get(position).getDescription() + "\n" + schools.getSchoolBuses().get(position).getName());
        String img_url = schools.getSchoolBuses().get(position).getImgUrl();
        Picasso.with(context)
                .load(img_url)
                .into(holder.poster);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("stops_url", schools.getSchoolBuses().get(position).getStopsUrl());
                bundle.putString("name", schools.getSchoolBuses().get(position).getName());
                bundle.putString("description", schools.getSchoolBuses().get(position).getDescription());
                bundle.putString("img_url", schools.getSchoolBuses().get(position).getImgUrl());
                intent.putExtra("school", bundle);
                context.startActivity(intent);
                if (context instanceof Activity) {
                    ((Activity) context).overridePendingTransition(R.anim.activity_open_enter, R.anim.activity_open_exit);
                }


            }
        });
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return schools.getSchoolBuses().size();
    }
}

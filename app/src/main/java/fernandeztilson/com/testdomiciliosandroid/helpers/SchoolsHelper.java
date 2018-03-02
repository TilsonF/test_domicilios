package fernandeztilson.com.testdomiciliosandroid.helpers;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Timer;
import java.util.TimerTask;

import fernandeztilson.com.testdomiciliosandroid.R;
import fernandeztilson.com.testdomiciliosandroid.models.Schools;
import fernandeztilson.com.testdomiciliosandroid.models.Stops;
import fernandeztilson.com.testdomiciliosandroid.services.SchoolService;
import fernandeztilson.com.testdomiciliosandroid.views.MainActivity;
import fernandeztilson.com.testdomiciliosandroid.views.MapsActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tilson on 28/02/2018.
 */

public class SchoolsHelper {
    SchoolService schoolService;
    public static Schools schools;
    public static Stops stops;
    private String urlApi;

    public SchoolsHelper(String urlApi) {
        this.urlApi = urlApi;
        try {


            // Create connection to REST service
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(urlApi)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // Create API connection
            this.schoolService = retrofit.create(SchoolService.class);

        } catch (UnsupportedOperationException e) {
            e.getMessage();
        }
    }

    public void schoolsListCall(final MainActivity mainActivity) {
        try {
            Call<Schools> schoolsCallData = schoolService.getSchoolsList();
            schoolsCallData.enqueue(new Callback<Schools>() {
                @Override
                public void onResponse(Call<Schools> call, Response<Schools> response) {

                    int statusCode = response.code();
                    Log.e("status code", "" + statusCode);
                    if (!response.isSuccessful()) {
                        mainActivity.cargando.setVisibility(View.GONE);
                    } else {
                        Log.e("moviePopular", response.body().toString());
                        schools = response.body();
                        mainActivity.schools = schools;
                        mainActivity.init();
                        mainActivity.cargando.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<Schools> call, Throwable t) {
                    mainActivity.cargando.setVisibility(View.GONE);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            mainActivity.cargando.setVisibility(View.GONE);
        }

    }

    public void stopsListCall(final MapsActivity mapsActivity, final String stop) {
        String newStop = stop.substring(stop.indexOf("bins/") + 5);
        try {
            Call<Stops> schoolsCallData = schoolService.getStopsList(newStop);
            schoolsCallData.enqueue(new Callback<Stops>() {
                @Override
                public void onResponse(Call<Stops> call, Response<Stops> response) {
                    Log.e("url stops", call.request().url().toString());
                    int statusCode = response.code();
                    Log.e("status code", "" + statusCode);
                    if (!response.isSuccessful()) {
                        mapsActivity.cargando.setVisibility(View.GONE);
                    } else {
                        Log.e("stops", response.body().toString());
                        stops = response.body();
                        mapsActivity.stops = stops;
                        LatLng point1 = new LatLng(stops.getStops().get(0).getLat(), stops.getStops().get(0).getLng());
                        for (int i = 0; i < stops.getStops().size(); i++) {
                            LatLng point = new LatLng(stops.getStops().get(i).getLat(), stops.getStops().get(i).getLng());
                            mapsActivity.mMap.addMarker(new MarkerOptions().position(point).icon(BitmapDescriptorFactory
                                    .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                        }
                        mapsActivity.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point1, 16));

                        int hora = stops.getEstimatedTimeMilliseconds() / 3600000;
                        int restohora = stops.getEstimatedTimeMilliseconds() % 3600000;
                        int minuto = restohora / 60000;


                        mapsActivity.estimated_time.setText("Tiempo estimado: " + hora + " h " + minuto + " m");


                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                mapsActivity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        mapsActivity.cargando.setVisibility(View.GONE);

                                    }
                                });

                            }
                        };

                        // Simulate a long loading process on application startup.
                        Timer timer = new Timer();
                        timer.schedule(task, 4000);
                    }
                }

                @Override
                public void onFailure(Call<Stops> call, Throwable t) {
                    Log.e("onfail stop", t.getMessage());
                    mapsActivity.cargando.setVisibility(View.GONE);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("exception stop", e.getMessage());
            mapsActivity.cargando.setVisibility(View.GONE);
        }

    }


}

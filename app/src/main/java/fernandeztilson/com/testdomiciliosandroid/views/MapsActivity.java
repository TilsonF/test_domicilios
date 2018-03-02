package fernandeztilson.com.testdomiciliosandroid.views;


import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.squareup.picasso.Picasso;

import fernandeztilson.com.testdomiciliosandroid.R;
import fernandeztilson.com.testdomiciliosandroid.helpers.SchoolsHelper;
import fernandeztilson.com.testdomiciliosandroid.models.Stops;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    /**
     * Definimos un objeto GoogleMap
     */
    public static GoogleMap mMap;
    /**
     * Definimos un objeto TextView
     */
    private TextView name;
    /**
     * Definimos un objeto TextView
     */
    private TextView description;
    /**
     * Definimos un objeto TextView
     */
    public static TextView estimated_time;
    /**
     * Definimos un objeto ImageView
     */
    private ImageView img, img_back;
    /**
     * Definimos una variable String
     */
    private String stops_url;
    /**
     * Definimos un objeto Stops
     */
    public static Stops stops;
    /**
     * Definimos un objeto LottieAnimationView
     */
    public static LottieAnimationView cargando;
    /**
     * Definimos un objeto CoordinatorLayout
     */
    public static CoordinatorLayout coordinatorLayout;

    /**
     * Obtenemos el ciclo de vida onCreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle bundle = getIntent().getBundleExtra("school");
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        name = (TextView) findViewById(R.id.name);
        description = (TextView) findViewById(R.id.description);
        estimated_time = (TextView) findViewById(R.id.estimated_time);
        img = (ImageView) findViewById(R.id.img);
        img_back = (ImageView) findViewById(R.id.back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.activity_close_enter, R.anim.activity_close_exit);
            }
        });
        String posterUrl = bundle.getString("img_url");
        Picasso.with(MapsActivity.this)
                .load(posterUrl)
                .into(img);

        name.setText(bundle.getString("name"));
        description.setText(bundle.getString("description"));
        stops_url = bundle.getString("stops_url");
        cargando = (LottieAnimationView) findViewById(R.id.animation_progress);
        cargando.setVisibility(View.VISIBLE);
        //Obtenemos la url api y lanzamos el ayudante para el consumo
        String urlApi;
        urlApi = getString(R.string.schools_api);
        SchoolsHelper schoolsHelper = new SchoolsHelper(urlApi);
        try {
            Log.e("schoolsHelper stops", "yes");
            schoolsHelper.stopsListCall(this, stops_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Obtenemos cuando el mapa esta listo
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }
}

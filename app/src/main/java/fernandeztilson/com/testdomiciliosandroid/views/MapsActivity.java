package fernandeztilson.com.testdomiciliosandroid.views;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import fernandeztilson.com.testdomiciliosandroid.R;
import fernandeztilson.com.testdomiciliosandroid.helpers.SchoolsHelper;
import fernandeztilson.com.testdomiciliosandroid.models.Stops;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static GoogleMap mMap;
    TextView name, description;
    public static TextView estimated_time;
    ImageView img, img_back;
    String stops_url;

    public static Stops stops;
    public static LottieAnimationView cargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle bundle = getIntent().getBundleExtra("school");

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
        /** url for API */
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
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }
}

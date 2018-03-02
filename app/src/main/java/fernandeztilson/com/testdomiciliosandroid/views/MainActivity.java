package fernandeztilson.com.testdomiciliosandroid.views;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

import fernandeztilson.com.testdomiciliosandroid.R;
import fernandeztilson.com.testdomiciliosandroid.helpers.PagerAdapter;
import fernandeztilson.com.testdomiciliosandroid.helpers.SchoolsHelper;
import fernandeztilson.com.testdomiciliosandroid.models.Schools;

public class MainActivity extends AppCompatActivity {
    /**
     * Definimos un objeto PagerAdapter
     */
    public static PagerAdapter adapter = null;
    /**
     * Definimos un objeto TabLayout
     */
    public static TabLayout tabLayout = null;
    /**
     * Definimos un objeto ViewPager
     */
    public static ViewPager viewPager = null;
    /**
     * Definimos un objeto Schools
     */
    public static Schools schools = null;
    /**
     * Definimos un objeto LootieAnimationView
     */
    public static LottieAnimationView cargando;
    /**
     * Definimos un objeto CoordinatorLayout
     */
    public static CoordinatorLayout coordinatorLayout;

    /**
     * Obtiene el ciclo de vida onCreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_tab0));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager = (ViewPager) findViewById(R.id.pager);
        cargando = (LottieAnimationView) findViewById(R.id.animation_progress);
        cargando.setVisibility(View.VISIBLE);


        // Obtenemos la url api y lanzamos el ayudando para el consumo
        String urlApi;
        urlApi = getString(R.string.schools_api);
        SchoolsHelper schoolsHelper = new SchoolsHelper(urlApi);
        try {
            Log.e("schoolsHelper ", "yes");
            schoolsHelper.schoolsListCall(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene el listener del TabLayout
     *
     * @param viewPager
     * @return
     */
    @NonNull
    private TabLayout.OnTabSelectedListener getOnTabSelectedListener(final ViewPager viewPager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // nothing now
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // nothing now
            }
        };
    }

    /**
     * Inicializa el adaptador al viewPager y sus listener
     */
    public void init() {
        adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), schools);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(getOnTabSelectedListener(viewPager));
    }


}

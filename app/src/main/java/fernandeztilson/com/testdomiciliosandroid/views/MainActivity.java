package fernandeztilson.com.testdomiciliosandroid.views;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
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
     * PagerAdapter for adapter
     */
    public static PagerAdapter adapter = null;

    /**
     * LinearLayout for bottom_sheet
     */
    public static LinearLayout bottom_sheet;
    /**
     * TabLayout for tabLayout
     */
    public static TabLayout tabLayout = null;
    /**
     * ViewPager for viewPager
     */
    public static ViewPager viewPager = null;
    /**
     * Schools for schools
     */
    public static Schools schools = null;
    public static LottieAnimationView cargando;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        // define TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_tab0));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // define ViewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        cargando = (LottieAnimationView) findViewById(R.id.animation_progress);
        cargando.setVisibility(View.VISIBLE);


        /** url for API */
        String urlApi, api_key;
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
     * Listener for tab selected
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
                //Toast.makeText(MainActivity.this, "Tab selected " +  tab.getPosition(), Toast.LENGTH_SHORT).show();
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


    public void init() {
        //  ViewPager need a PagerAdapter
        adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), schools);

        viewPager.setAdapter(adapter);

        // Listeners
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(getOnTabSelectedListener(viewPager));
    }


}

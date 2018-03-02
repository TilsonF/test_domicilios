package fernandeztilson.com.testdomiciliosandroid.helpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fernandeztilson.com.testdomiciliosandroid.models.Schools;
import fernandeztilson.com.testdomiciliosandroid.views.FragmentSchool;

/**
 * Created by Tilson on 28/02/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int numTabs;
    private Schools schools;



    public PagerAdapter(FragmentManager fm, int numTabs, Schools schools) {
        super(fm);
        this.numTabs = numTabs;
        this.schools = schools;


    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentSchool tab1 = new FragmentSchool();
                return tab1;


            default:
                throw new RuntimeException("Tab position invalid " + position);
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}

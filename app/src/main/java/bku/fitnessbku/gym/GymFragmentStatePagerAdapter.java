package bku.fitnessbku.gym;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 51202 on 9/9/2017.
 */

public class GymFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    public GymFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return TodayScheduleFragment.newInstance(position);
            case 1:
                return WeekScheduleFragment.newInstance(position);
            default:
                return TodayScheduleFragment.newInstance(0);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Today Schedule";
            case 1:
                return "Week Schedule";
            default:
                return "temp";
        }
    }
}

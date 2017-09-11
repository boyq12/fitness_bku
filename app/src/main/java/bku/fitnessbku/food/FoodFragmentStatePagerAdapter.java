package bku.fitnessbku.food;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import bku.fitnessbku.gym.TodayScheduleFragment;
import bku.fitnessbku.gym.WeekScheduleFragment;

/**
 * Created by 51202 on 9/10/2017.
 */

public class FoodFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    public FoodFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TodayMealFragment();
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
                return "Today Meal";
            case 1:
                return "Food Setting";
            default:
                return "temp";
        }
    }
}

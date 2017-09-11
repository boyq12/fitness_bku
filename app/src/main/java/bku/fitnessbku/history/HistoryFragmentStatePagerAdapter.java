package bku.fitnessbku.history;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import bku.fitnessbku.gym.TodayScheduleFragment;
import bku.fitnessbku.gym.WeekScheduleFragment;

/**
 * Created by 51202 on 9/10/2017.
 */

public class HistoryFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    public HistoryFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SummaryFragment();
            case 1:
                return new GymListHistory();
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
                return "Summary";
            case 1:
                return "Gym History";
            default:
                return "temp";
        }
    }
}

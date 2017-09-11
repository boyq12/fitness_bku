package bku.fitnessbku.gym;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bku.fitnessbku.R;

/**
 * Created by 51202 on 9/10/2017.
 */

public class WeekScheduleFragment extends Fragment {

    private static final String ARG_TAB_IDENT = "tab_ident";

    public WeekScheduleFragment(){

    }

    public static WeekScheduleFragment newInstance(int tab){
        WeekScheduleFragment fragment = new WeekScheduleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TAB_IDENT, tab);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_week_schedule, container, false);
        return rootView;
    }
}

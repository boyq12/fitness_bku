package bku.fitnessbku.gym;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bku.fitnessbku.GymActivity;
import bku.fitnessbku.R;

/**
 * Created by 51202 on 9/10/2017.
 */

public class TodayScheduleFragment extends Fragment {

    private static final String ARG_TAB_IDENT = "tab_ident";
    private LinearLayoutManager lLayout;

    public TodayScheduleFragment() {

    }

    public static TodayScheduleFragment newInstance(int tab) {
        TodayScheduleFragment fragment = new TodayScheduleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TAB_IDENT, tab);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_today_schedule, container, false);
        RecyclerView rView = (RecyclerView)rootView.findViewById(R.id.recycler_view_today_gym);
        lLayout = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(lLayout);
        TodayGymRecyclerAdapter rcAdapter = new TodayGymRecyclerAdapter();
        rView.setAdapter(rcAdapter);
        return rootView;
    }


}

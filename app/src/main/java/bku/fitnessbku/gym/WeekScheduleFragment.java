package bku.fitnessbku.gym;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableList;

import java.util.Arrays;
import java.util.List;

import bku.fitnessbku.R;

/**
 * Created by 51202 on 9/10/2017.
 */

public class WeekScheduleFragment extends Fragment {

    private static final String ARG_TAB_IDENT = "tab_ident";
    private RecyclerView rcvWeekSchedule;

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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvWeekSchedule = view.findViewById(R.id.rcvWeekSchedule);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvWeekSchedule.setLayoutManager(layoutManager);

        GymItem item = new GymItem("Dead lift");
        GymItem item2 = new GymItem("Push up");
        WeekSchedule schedule1 = new WeekSchedule("Tuesday", Arrays.asList(item));
        WeekSchedule schedule2 = new WeekSchedule("Wednesday", Arrays.asList(item, item2));

        WeekScheduleExpainableAdapter adapter = new WeekScheduleExpainableAdapter(Arrays.asList(schedule1, schedule2));

        rcvWeekSchedule.setAdapter(adapter);
    }

    public class WeekSchedule extends ExpandableGroup<GymItem>{

        public WeekSchedule(String title, List<GymItem> items) {
            super(title, items);
        }
    }

}

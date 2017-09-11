package bku.fitnessbku.gym;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

import bku.fitnessbku.R;

/**
 * Created by 51202 on 9/11/2017.
 */

public class WeekScheduleExpainableAdapter extends ExpandableRecyclerViewAdapter<WeekScheduleExpainableAdapter.DayViewHolder, WeekScheduleExpainableAdapter.GymItemHolder>{


    public WeekScheduleExpainableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public DayViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day_schedule, null);
        return new DayViewHolder(view);
    }

    @Override
    public GymItemHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_schedule_item, null);
        return new GymItemHolder(view);
    }

    @Override
    public void onBindChildViewHolder(GymItemHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final GymItem gymItem = (GymItem) group.getItems().get(childIndex);
        holder.gymName.setText(gymItem.getGymName());
    }

    @Override
    public void onBindGroupViewHolder(DayViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.dayTitle.setText(group.getTitle());
    }

    public class DayViewHolder extends GroupViewHolder {

        private TextView dayTitle;

        public DayViewHolder(View itemView) {
            super(itemView);
            dayTitle = itemView.findViewById(R.id.txtDay);
        }
    }

    public class GymItemHolder extends ChildViewHolder {

        public TextView gymName;
        public GymItemHolder(View itemView) {
            super(itemView);
            gymName = itemView.findViewById(R.id.gym_name);
        }

    }
}

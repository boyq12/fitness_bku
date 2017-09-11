package bku.fitnessbku.gym;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import bku.fitnessbku.GymDetailActivity;
import bku.fitnessbku.R;

/**
 * Created by 51202 on 9/10/2017.
 */

public class TodayGymRecyclerAdapter extends RecyclerView.Adapter<TodayGymRecyclerAdapter.ViewHolder> {

    public TodayGymRecyclerAdapter(){

    }

    @Override
    public TodayGymRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_schedule_item, null);
        ViewHolder rcv = new ViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(TodayGymRecyclerAdapter.ViewHolder holder, int position) {
        holder.imgGym.setImageResource(R.drawable.deadlif2);
        holder.txtGymName.setText("Dead Lifting");
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView txtGymName;
        public ImageView imgGym;
        private final Context context;
        public ViewHolder(View v) {
            super(v);
            txtGymName = v.findViewById(R.id.gym_name);
            imgGym = v.findViewById(R.id.gymPhoto);
            context = itemView.getContext();
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, GymDetailActivity.class);
            context.startActivity(intent);
        }
    }
}

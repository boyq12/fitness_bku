package bku.fitnessbku.food;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bku.fitnessbku.R;

/**
 * Created by 51202 on 9/11/2017.
 */

public class DateMealAdapter extends RecyclerView.Adapter<DateMealAdapter.DateMealViewHolder>{


    @Override
    public DateMealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_meal_item, null);
        DateMealViewHolder holder = new DateMealViewHolder(layoutView);
        return holder;
    }

    @Override
    public void onBindViewHolder(DateMealViewHolder holder, int position) {
        switch (position){
            case 0:
                holder.txtMealPeriod.setText("Breakfast");
                break;
            case 1:
                holder.txtMealPeriod.setText("Lunch");
                break;
            case 2:
                holder.txtMealPeriod.setText("Dinner");
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class DateMealViewHolder extends RecyclerView.ViewHolder{

        TextView txtMealPeriod;
        RecyclerView rcvMealItems;
        private LinearLayoutManager lLayout;

        public DateMealViewHolder(View itemView) {
            super(itemView);
            txtMealPeriod = itemView.findViewById(R.id.txtMealPeriod);
            rcvMealItems = itemView.findViewById(R.id.rcvMealItems);
            lLayout = new LinearLayoutManager(itemView.getContext());
            rcvMealItems.setLayoutManager(lLayout);
            FoodListItemAdapter itemAdapter = new FoodListItemAdapter();
            rcvMealItems.setAdapter(itemAdapter);
        }
    }
}

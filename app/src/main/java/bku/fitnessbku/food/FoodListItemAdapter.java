package bku.fitnessbku.food;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import bku.fitnessbku.R;

/**
 * Created by 51202 on 9/11/2017.
 */

public class FoodListItemAdapter extends RecyclerView.Adapter<FoodListItemAdapter.FoodItemViewHolder> {


    @Override
    public FoodItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item, null);
        FoodItemViewHolder holder = new FoodItemViewHolder(layoutView);
        return holder;
    }

    @Override
    public void onBindViewHolder(FoodItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class FoodItemViewHolder extends RecyclerView.ViewHolder {
        public TextView txtFoodName, txtCalorie, txtAmount, txtDescription;
        public ImageView imgMeal;
        public FoodItemViewHolder(View itemView) {
            super(itemView);
            txtFoodName = itemView.findViewById(R.id.txtFoodName);
            txtAmount = itemView.findViewById(R.id.txtAmount);
            txtCalorie = itemView.findViewById(R.id.txtCalorie);
            txtDescription = itemView.findViewById(R.id.txtDescription);
        }
    }
}

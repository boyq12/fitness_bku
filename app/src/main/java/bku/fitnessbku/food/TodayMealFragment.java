package bku.fitnessbku.food;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bku.fitnessbku.R;

/**
 * Created by 51202 on 9/10/2017.
 */

public class TodayMealFragment extends Fragment {
    private RecyclerView rcvDateMeal;
    private LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meal_schedule, container, false);
        rcvDateMeal = rootView.findViewById(R.id.rcvDateMeals);
        layoutManager = new LinearLayoutManager(getContext());
        rcvDateMeal.setLayoutManager(layoutManager);
        DateMealAdapter adapter = new DateMealAdapter();
        rcvDateMeal.setAdapter(adapter);
        return rootView;
    }
}

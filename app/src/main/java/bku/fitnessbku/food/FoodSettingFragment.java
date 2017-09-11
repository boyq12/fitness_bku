package bku.fitnessbku.food;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bku.fitnessbku.R;
import bku.fitnessbku.custom_entity.MultiSelectionSpinner;

/**
 * Created by 51202 on 9/10/2017.
 */

public class FoodSettingFragment extends Fragment{
    private MultiSelectionSpinner spFavoriteFood;
    private MultiSelectionSpinner spDisease;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_food_setting, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spFavoriteFood = view.findViewById(R.id.spFavoriteFood);
        spDisease = view.findViewById(R.id.spDisease);
        List<String> food = new ArrayList<>(Arrays.asList("Beef", "Coconut", "Steak", "Milk"));
        List<String> disease = new ArrayList<>(Arrays.asList("Cough", "Sinusitis", "Stomach Ulcers"));
        spFavoriteFood.setItems(food);
        spDisease.setItems(disease);
    }
}

package bku.fitnessbku.history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import bku.fitnessbku.R;

/**
 * Created by 51202 on 9/10/2017.
 */

public class SummaryFragment extends Fragment {

    private PieChart pcGymAmount;
    private BarChart bcCaloriesBurn;
    ArrayList<PieEntry> entries ;
    PieDataSet pieDataSet ;
    PieData pieData ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history_summary, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pcGymAmount = view.findViewById(R.id.pcGymAmount);
        bcCaloriesBurn = view.findViewById(R.id.bcCaloriesBurned);
        entries = new ArrayList<>();


        addValuesToPIEENTRY();

        pieDataSet = new PieDataSet(entries, "");
        pieData = new PieData(pieDataSet);

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pcGymAmount.getDescription().setEnabled(false);
        pcGymAmount.setData(pieData);
        pcGymAmount.getLegend().setEnabled(false);
        pcGymAmount.animateY(2000);

        bcCaloriesBurn.setDrawBarShadow(false);
        bcCaloriesBurn.setDrawValueAboveBar(true);

        bcCaloriesBurn.getDescription().setEnabled(false);

        bcCaloriesBurn.setMaxVisibleValueCount(12);


        XAxis xAxis = bcCaloriesBurn.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);


        YAxis leftAxis = bcCaloriesBurn.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = bcCaloriesBurn.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        Legend l = bcCaloriesBurn.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);

        setData(12, 50);
        bcCaloriesBurn.animateXY(500, 500);
    }

    public void addValuesToPIEENTRY(){
        entries.add(new PieEntry(2f, "Dead lift"));
        entries.add(new PieEntry(4f, "Push up"));
        entries.add(new PieEntry(6f, "Bench Press"));
        entries.add(new PieEntry(8f, "Pull-ups"));
        entries.add(new PieEntry(7f, "Inverted rows"));
        entries.add(new PieEntry(3f, "Face pulls"));

    }

    private void setData(int count, float range) {

        float start = 1f;

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = (int) start; i < start + count + 1; i++) {
            float mult = (range + 1);
            float val = (float) (Math.random() * mult);

            if (Math.random() * 100 < 25) {
                yVals1.add(new BarEntry(i, val));
            } else {
                yVals1.add(new BarEntry(i, val));
            }
        }

        BarDataSet set1;

        if (bcCaloriesBurn.getData() != null &&
                bcCaloriesBurn.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) bcCaloriesBurn.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            bcCaloriesBurn.getData().notifyDataChanged();
            bcCaloriesBurn.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Week");

            set1.setDrawIcons(false);

            set1.setColors(ColorTemplate.MATERIAL_COLORS);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.9f);

            bcCaloriesBurn.setData(data);
        }
    }
}

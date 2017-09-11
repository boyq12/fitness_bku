package bku.fitnessbku.history;

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

public class GymListHistory extends Fragment {
    private RecyclerView rcvHistoryItems;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history_list, container, false);
        rcvHistoryItems = rootView.findViewById(R.id.rcvGymListHistory);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvHistoryItems.setLayoutManager(layoutManager);
        HistoryItemAdapter adapter = new HistoryItemAdapter();
        rcvHistoryItems.setAdapter(adapter);
        return rootView;
    }
}

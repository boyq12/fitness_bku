package bku.fitnessbku.room;

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

public class RoomFragment extends Fragment {
    private RecyclerView rcvRooms;
    private LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gym_room, container, false);
        rcvRooms = rootView.findViewById(R.id.rcvRooms);
        layoutManager = new LinearLayoutManager(getContext());
        rcvRooms.setLayoutManager(layoutManager);
        RoomAdapter adapter = new RoomAdapter();
        rcvRooms.setAdapter(adapter);
        return rootView;
    }
}

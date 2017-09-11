package bku.fitnessbku.history;

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

public class HistoryItemAdapter extends RecyclerView.Adapter<HistoryItemAdapter.HistoryItemViewHolder> {


    @Override
    public HistoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewRoot = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, null);
        HistoryItemViewHolder holder = new HistoryItemViewHolder(viewRoot);
        return holder;
    }

    @Override
    public void onBindViewHolder(HistoryItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class HistoryItemViewHolder extends RecyclerView.ViewHolder {

        public TextView txtGymName;
        public ImageView imgGymIcon;
        public HistoryItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}

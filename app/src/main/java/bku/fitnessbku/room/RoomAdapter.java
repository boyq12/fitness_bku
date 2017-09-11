package bku.fitnessbku.room;

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

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomItemViewHolder>{

    @Override
    public RoomItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_room_item, null);
        RoomItemViewHolder holder = new RoomItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RoomItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class RoomItemViewHolder extends RecyclerView.ViewHolder{

        public TextView txtRoomName, txtRoomPhone, txtRoomAddress, txtRoomPrice;
        public ImageView imgRoomIcon;

        public RoomItemViewHolder(View itemView) {
            super(itemView);
            txtRoomName = itemView.findViewById(R.id.txtGymRoomName);
            txtRoomPhone = itemView.findViewById(R.id.txtPhone);
            txtRoomAddress = itemView.findViewById(R.id.txtAddress);
            txtRoomPrice = itemView.findViewById(R.id.txtPrice);
            imgRoomIcon = itemView.findViewById(R.id.imgRoomIcon);
        }
    }
}

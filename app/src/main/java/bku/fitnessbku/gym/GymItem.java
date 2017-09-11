package bku.fitnessbku.gym;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 51202 on 9/11/2017.
 */


public class GymItem implements Parcelable {

    private String gymName;

    public GymItem (String gymName){
        this.gymName = gymName;
    }


    protected GymItem(Parcel in) {
    }

    public static final Creator<GymItem> CREATOR = new Creator<GymItem>() {
        @Override
        public GymItem createFromParcel(Parcel in) {
            return new GymItem(in);
        }

        @Override
        public GymItem[] newArray(int size) {
            return new GymItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public String getGymName() {
        return gymName;
    }

}
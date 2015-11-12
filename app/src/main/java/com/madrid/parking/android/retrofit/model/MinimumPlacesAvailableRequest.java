package com.madrid.parking.android.retrofit.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MinimumPlacesAvailableRequest
        implements Parcelable {
    public static final Parcelable.Creator<MinimumPlacesAvailableRequest> CREATOR = new Parcelable.Creator() {
        public MinimumPlacesAvailableRequest createFromParcel(Parcel paramAnonymousParcel) {
            return new MinimumPlacesAvailableRequest(paramAnonymousParcel);
        }

        public MinimumPlacesAvailableRequest[] newArray(int paramAnonymousInt) {
            return new MinimumPlacesAvailableRequest[paramAnonymousInt];
        }
    };
    private List<String> lstminimumPlacesAvailable;

    public MinimumPlacesAvailableRequest() {
        this(new ArrayList());
    }

    public MinimumPlacesAvailableRequest(Parcel paramParcel) {
        paramParcel.readList(this.lstminimumPlacesAvailable, String.class.getClassLoader());
    }

    public MinimumPlacesAvailableRequest(MinimumPlacesAvailableRequest paramMinimumPlacesAvailableRequest) {
        this.lstminimumPlacesAvailable = paramMinimumPlacesAvailableRequest.getLstminimumPlacesAvailable();
    }

    public MinimumPlacesAvailableRequest(List<String> paramList) {
        this.lstminimumPlacesAvailable = paramList;
    }

    public int describeContents() {
        return 0;
    }

    public List<String> getLstminimumPlacesAvailable() {
        return this.lstminimumPlacesAvailable;
    }

    public void setLstminimumPlacesAvailable(List<String> paramList) {
        this.lstminimumPlacesAvailable = paramList;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeList(this.lstminimumPlacesAvailable);
    }
}

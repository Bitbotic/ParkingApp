package com.madrid.parking.android.retrofit.model;

/**
 * Created by Marcin on 03/10/2015.
 */

import android.os.Parcel;
import android.os.Parcelable;


public class CoordenateRequest
        implements Parcelable {
    public static final Parcelable.Creator<CoordenateRequest> CREATOR = new Parcelable.Creator() {
        public CoordenateRequest createFromParcel(Parcel paramAnonymousParcel) {
            return new CoordenateRequest(paramAnonymousParcel);
        }

        public CoordenateRequest[] newArray(int paramAnonymousInt) {
            return new CoordenateRequest[paramAnonymousInt];
        }
    };
    private String latitude;
    private String longitude;

    public CoordenateRequest() {
        this("", "");
    }

    public CoordenateRequest(Parcel paramParcel) {
        this.latitude = paramParcel.readString();
        this.longitude = paramParcel.readString();
    }

    public CoordenateRequest(Location paramLocation) {
        this.latitude = String.valueOf(paramLocation.getLatitude());
        this.longitude = String.valueOf(paramLocation.getLongitude());
    }

    public CoordenateRequest(CoordenateRequest paramCoordenateRequest) {
        this.latitude = paramCoordenateRequest.getLatitude();
        this.longitude = paramCoordenateRequest.getLongitude();
    }

    public CoordenateRequest(String paramString1, String paramString2) {
        this.latitude = paramString1;
        this.longitude = paramString2;
    }

    public int describeContents() {
        return 0;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLatitude(String paramString) {
        this.latitude = paramString;
    }

    public void setLongitude(String paramString) {
        this.longitude = paramString;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.latitude);
        paramParcel.writeString(this.longitude);
    }
}

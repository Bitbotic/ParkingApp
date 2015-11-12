package com.madrid.parking.android.retrofit.model;

/**
 * Created by Marcin on 03/10/2015.
 */


import android.os.Parcel;
import android.os.Parcelable;

public class Location
        implements Parcelable {
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator() {
        public Location createFromParcel(Parcel paramAnonymousParcel) {
            return new Location(paramAnonymousParcel);
        }

        public Location[] newArray(int paramAnonymousInt) {
            return new Location[paramAnonymousInt];
        }
    };
    private double latitude;
    private double longitude;
    private float radius;

    public Location() {
    }

    public Location(double paramDouble1, double paramDouble2) {
        this(paramDouble1, paramDouble2, -1.0F);
    }

    public Location(double paramDouble1, double paramDouble2, float paramFloat) {
        this.latitude = paramDouble1;
        this.longitude = paramDouble2;
        this.radius = paramFloat;
    }

    public Location(Parcel paramParcel) {
        this.latitude = paramParcel.readDouble();
        this.longitude = paramParcel.readDouble();
        this.radius = paramParcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setLatitude(double paramDouble) {
        this.latitude = paramDouble;
    }

    public void setLongitude(double paramDouble) {
        this.longitude = paramDouble;
    }

    public void setRadius(float paramFloat) {
        this.radius = paramFloat;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeDouble(this.latitude);
        paramParcel.writeDouble(this.longitude);
        paramParcel.writeFloat(this.radius);
    }
}

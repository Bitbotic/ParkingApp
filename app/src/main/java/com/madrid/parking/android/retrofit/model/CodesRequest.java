package com.madrid.parking.android.retrofit.model;

/**
 * Created by Marcin on 03/10/2015.
 */


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class CodesRequest implements Parcelable {

    public static final Parcelable.Creator<CodesRequest> CREATOR = new Parcelable.Creator() {
        public CodesRequest createFromParcel(Parcel paramAnonymousParcel) {
            return new CodesRequest(paramAnonymousParcel);
        }

        public CodesRequest[] newArray(int paramAnonymousInt) {
            return new CodesRequest[paramAnonymousInt];
        }
    };
    private List<String> lstCodes;

    public CodesRequest() {
        this(new ArrayList());
    }

    public CodesRequest(Parcel paramParcel) {
        paramParcel.readList(this.lstCodes, String.class.getClassLoader());
    }

    public CodesRequest(CodesRequest paramCodesRequest) {
        this.lstCodes = paramCodesRequest.getLstCodes();
    }

    public CodesRequest(List<String> paramList) {
        this.lstCodes = paramList;
    }

    public int describeContents() {
        return 0;
    }

    public List<String> getLstCodes() {
        return this.lstCodes;
    }

    public void setLstCodes(List<String> paramList) {
        this.lstCodes = paramList;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeList(this.lstCodes);
    }
}

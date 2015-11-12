package com.madrid.parking.android.retrofit.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ParentNameFieldCodesRequest implements Parcelable {

    public static final Parcelable.Creator<ParentNameFieldCodesRequest> CREATOR = new Parcelable.Creator() {
        public ParentNameFieldCodesRequest createFromParcel(Parcel paramAnonymousParcel) {
            return new ParentNameFieldCodesRequest(paramAnonymousParcel);
        }

        public ParentNameFieldCodesRequest[] newArray(int paramAnonymousInt) {
            return new ParentNameFieldCodesRequest[paramAnonymousInt];
        }
    };
    private List<NameFieldCodesRequest> lstNameFieldCodes;

    public ParentNameFieldCodesRequest() {
        this(new ArrayList());
    }

    public ParentNameFieldCodesRequest(Parcel paramParcel) {
        paramParcel.readList(this.lstNameFieldCodes, NameFieldCodesRequest.class.getClassLoader());
    }

    public ParentNameFieldCodesRequest(ParentNameFieldCodesRequest paramParentNameFieldCodesRequest) {
        this.lstNameFieldCodes = paramParentNameFieldCodesRequest.getLstNameFieldCodes();
    }

    public ParentNameFieldCodesRequest(List<NameFieldCodesRequest> paramList) {
        this.lstNameFieldCodes = paramList;
    }

    public int describeContents() {
        return 0;
    }

    public List<NameFieldCodesRequest> getLstNameFieldCodes() {
        return this.lstNameFieldCodes;
    }

    public void setLstNameFieldCodes(List<NameFieldCodesRequest> paramList) {
        this.lstNameFieldCodes = paramList;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeList(this.lstNameFieldCodes);
    }
}

package com.madrid.parking.android.retrofit.model;

/**
 * Created by Marcin on 03/10/2015.
 */


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class PoiCategoryRequest
        implements Parcelable {
    public static final Parcelable.Creator<PoiCategoryRequest> CREATOR = new Parcelable.Creator() {
        public PoiCategoryRequest createFromParcel(Parcel paramAnonymousParcel) {
            return new PoiCategoryRequest(paramAnonymousParcel);
        }

        public PoiCategoryRequest[] newArray(int paramAnonymousInt) {
            return new PoiCategoryRequest[paramAnonymousInt];
        }
    };
    private List<String> lstCategoryTypes;

    public PoiCategoryRequest() {
        this(new ArrayList());
    }

    public PoiCategoryRequest(Parcel paramParcel) {
        paramParcel.readList(this.lstCategoryTypes, String.class.getClassLoader());
    }

    public PoiCategoryRequest(PoiCategoryRequest paramPoiCategoryRequest) {
        this.lstCategoryTypes = paramPoiCategoryRequest.getLstCategoryTypes();
    }

    public PoiCategoryRequest(List<String> paramList) {
        this.lstCategoryTypes = paramList;
    }

    public int describeContents() {
        return 0;
    }

    public List<String> getLstCategoryTypes() {
        return this.lstCategoryTypes;
    }

    public void setLstCategoryTypes(List<String> paramList) {
        this.lstCategoryTypes = paramList;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeList(this.lstCategoryTypes);
    }
}

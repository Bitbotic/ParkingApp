package com.madrid.parking.android.retrofit.model;

/**
 * Created by Marcin on 03/10/2015.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class FamilyTypeCategoryRequest
        implements Parcelable {
    public static final Parcelable.Creator<FamilyTypeCategoryRequest> CREATOR = new Parcelable.Creator() {
        public FamilyTypeCategoryRequest createFromParcel(Parcel paramAnonymousParcel) {
            return new FamilyTypeCategoryRequest(paramAnonymousParcel);
        }

        public FamilyTypeCategoryRequest[] newArray(int paramAnonymousInt) {
            return new FamilyTypeCategoryRequest[paramAnonymousInt];
        }
    };
    private PoiCategoryRequest poiCategory;
    private String poiFamily;
    private String poiType;

    public FamilyTypeCategoryRequest() {
        this(null, "", "");
    }

    public FamilyTypeCategoryRequest(Parcel paramParcel) {
        this.poiCategory = ((PoiCategoryRequest) paramParcel.readParcelable(PoiCategoryRequest.class.getClassLoader()));
        this.poiFamily = paramParcel.readString();
        this.poiType = paramParcel.readString();
    }

    public FamilyTypeCategoryRequest(FamilyTypeCategoryRequest paramFamilyTypeCategoryRequest) {
        this.poiCategory = paramFamilyTypeCategoryRequest.getPoiCategory();
        this.poiFamily = paramFamilyTypeCategoryRequest.getPoiFamily();
        this.poiType = paramFamilyTypeCategoryRequest.getPoiType();
    }

    public FamilyTypeCategoryRequest(PoiCategoryRequest paramPoiCategoryRequest, String paramString1, String paramString2) {
        this.poiCategory = paramPoiCategoryRequest;
        this.poiFamily = paramString1;
        this.poiType = paramString2;
    }

    public int describeContents() {
        return 0;
    }

    public PoiCategoryRequest getPoiCategory() {
        return this.poiCategory;
    }

    public String getPoiFamily() {
        return this.poiFamily;
    }

    public String getPoiType() {
        return this.poiType;
    }

    public void setPoiCategory(PoiCategoryRequest paramPoiCategoryRequest) {
        this.poiCategory = paramPoiCategoryRequest;
    }

    public void setPoiFamily(String paramString) {
        this.poiFamily = paramString;
    }

    public void setPoiType(String paramString) {
        this.poiType = paramString;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.poiCategory, paramInt);
        paramParcel.writeString(this.poiFamily);
        paramParcel.writeString(this.poiType);
    }
}

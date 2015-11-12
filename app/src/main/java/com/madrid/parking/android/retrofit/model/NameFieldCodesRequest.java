package com.madrid.parking.android.retrofit.model;

/**
 * Created by Marcin on 03/10/2015.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class NameFieldCodesRequest
        implements Parcelable {
    public static final Parcelable.Creator<NameFieldCodesRequest> CREATOR = new Parcelable.Creator() {
        public NameFieldCodesRequest createFromParcel(Parcel paramAnonymousParcel) {
            return new NameFieldCodesRequest(paramAnonymousParcel);
        }

        public NameFieldCodesRequest[] newArray(int paramAnonymousInt) {
            return new NameFieldCodesRequest[paramAnonymousInt];
        }
    };
    private CodesRequest codes;
    private String nameField;

    public NameFieldCodesRequest() {
        this(null, "");
    }

    public NameFieldCodesRequest(Parcel paramParcel) {
        this.codes = ((CodesRequest) paramParcel.readParcelable(CodesRequest.class.getClassLoader()));
        this.nameField = paramParcel.readString();
    }

    public NameFieldCodesRequest(CodesRequest paramCodesRequest, String paramString) {
        this.codes = paramCodesRequest;
        this.nameField = paramString;
    }

    public NameFieldCodesRequest(NameFieldCodesRequest paramNameFieldCodesRequest) {
        this.codes = paramNameFieldCodesRequest.getCodes();
        this.nameField = paramNameFieldCodesRequest.getNameField();
    }

    public int describeContents() {
        return 0;
    }

    public CodesRequest getCodes() {
        return this.codes;
    }

    public String getNameField() {
        return this.nameField;
    }

    public void setCodes(CodesRequest paramCodesRequest) {
        this.codes = paramCodesRequest;
    }

    public void setNameField(String paramString) {
        this.nameField = paramString;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.codes, paramInt);
        paramParcel.writeString(this.nameField);
    }
}
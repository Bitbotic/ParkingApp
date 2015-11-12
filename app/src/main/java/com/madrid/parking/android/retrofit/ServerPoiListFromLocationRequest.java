package com.madrid.parking.android.retrofit;

import com.madrid.parking.android.retrofit.model.CoordenateRequest;
import com.madrid.parking.android.retrofit.model.MinimumPlacesAvailableRequest;
import com.madrid.parking.android.retrofit.model.ParentNameFieldCodesRequest;
import com.madrid.parking.android.retrofit.model.TFamilyTTypeTCategoryRequest;

/**
 * Created by Marcin on 03/10/2015.
 */

public class ServerPoiListFromLocationRequest {
    private TFamilyTTypeTCategoryRequest TFamilyTTypeTCategory;
    private CoordenateRequest coordinate;
    private String dateTimeUse;
    private String language;
    private MinimumPlacesAvailableRequest minimumPlacesAvailable;
    private ParentNameFieldCodesRequest nameFieldCodes;
    private String radius;

    public ServerPoiListFromLocationRequest() {
        this(null, null, "", null, null, "", "");
    }

    public ServerPoiListFromLocationRequest(ServerPoiListFromLocationRequest paramServerPoiListFromLocationRequest) {
        this.TFamilyTTypeTCategory = paramServerPoiListFromLocationRequest.getTFamilyTTypeTCategory();
        this.coordinate = paramServerPoiListFromLocationRequest.getCoordinate();
        this.dateTimeUse = paramServerPoiListFromLocationRequest.getDateTimeUse();
        this.minimumPlacesAvailable = paramServerPoiListFromLocationRequest.getMinimumPlacesAvailable();
        this.nameFieldCodes = paramServerPoiListFromLocationRequest.getParentNameFieldCodes();
        this.radius = paramServerPoiListFromLocationRequest.getRadius();
        this.language = paramServerPoiListFromLocationRequest.getLanguage();
    }

    public ServerPoiListFromLocationRequest(TFamilyTTypeTCategoryRequest paramTFamilyTTypeTCategoryRequest, CoordenateRequest paramCoordenateRequest, String paramString1, MinimumPlacesAvailableRequest paramMinimumPlacesAvailableRequest, ParentNameFieldCodesRequest paramParentNameFieldCodesRequest, String paramString2, String paramString3) {
        this.TFamilyTTypeTCategory = paramTFamilyTTypeTCategoryRequest;
        this.coordinate = paramCoordenateRequest;
        this.dateTimeUse = paramString1;
        this.minimumPlacesAvailable = paramMinimumPlacesAvailableRequest;
        this.nameFieldCodes = paramParentNameFieldCodesRequest;
        this.radius = paramString2;
        this.language = paramString3;
    }

    public CoordenateRequest getCoordinate() {
        return this.coordinate;
    }

    public String getDateTimeUse() {
        return this.dateTimeUse;
    }

    public String getLanguage() {
        return this.language;
    }

    public MinimumPlacesAvailableRequest getMinimumPlacesAvailable() {
        return this.minimumPlacesAvailable;
    }

    public ParentNameFieldCodesRequest getParentNameFieldCodes() {
        return this.nameFieldCodes;
    }

    public String getRadius() {
        return this.radius;
    }

    public TFamilyTTypeTCategoryRequest getTFamilyTTypeTCategory() {
        return this.TFamilyTTypeTCategory;
    }

    public void setCoordinate(CoordenateRequest paramCoordenateRequest) {
        this.coordinate = paramCoordenateRequest;
    }

    public void setDateTimeUse(String paramString) {
        this.dateTimeUse = paramString;
    }

    public void setLanguage(String paramString) {
        this.language = paramString;
    }

    public void setMinimumPlacesAvailable(MinimumPlacesAvailableRequest paramMinimumPlacesAvailableRequest) {
        this.minimumPlacesAvailable = paramMinimumPlacesAvailableRequest;
    }

    public void setParentNameFieldCodes(ParentNameFieldCodesRequest paramParentNameFieldCodesRequest) {
        this.nameFieldCodes = paramParentNameFieldCodesRequest;
    }

    public void setRadius(String paramString) {
        this.radius = paramString;
    }

    public void setTFamilyTTypeTCategory(TFamilyTTypeTCategoryRequest paramTFamilyTTypeTCategoryRequest) {
        this.TFamilyTTypeTCategory = paramTFamilyTTypeTCategoryRequest;
    }
}

package com.madrid.parking.android.retrofit.model;

/**
 * Created by Marcin on 03/10/2015.
 */

import java.util.ArrayList;
import java.util.List;

public class TFamilyTTypeTCategoryRequest {
    private List<FamilyTypeCategoryRequest> lstFamilyTypeCategory;

    public TFamilyTTypeTCategoryRequest() {
        this(new ArrayList());
    }

    public TFamilyTTypeTCategoryRequest(TFamilyTTypeTCategoryRequest paramTFamilyTTypeTCategoryRequest) {
        this.lstFamilyTypeCategory = paramTFamilyTTypeTCategoryRequest.getLstFamilyTypeCategory();
    }

    public TFamilyTTypeTCategoryRequest(List<FamilyTypeCategoryRequest> paramList) {
        this.lstFamilyTypeCategory = paramList;
    }

    public List<FamilyTypeCategoryRequest> getLstFamilyTypeCategory() {
        return this.lstFamilyTypeCategory;
    }

    public void setLstFamilyTypeCategory(List<FamilyTypeCategoryRequest> paramList) {
        this.lstFamilyTypeCategory = paramList;
    }
}

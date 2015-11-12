package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;

public class TFamilyTTypeTCategory implements KvmSerializable {

    public Vectorpois lstFamilyTypeCategory;

    public TFamilyTTypeTCategory() {
    }

    public TFamilyTTypeTCategory(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("lstFamilyTypeCategory")) {
            SoapObject j = (SoapObject) soapObject.getProperty("lstFamilyTypeCategory");
            lstFamilyTypeCategory = new Vectorpois(j);
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return lstFamilyTypeCategory;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 1;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:

                info.type = new Vectorpois().getClass();
                //info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "lstFamilyTypeCategory";
                //info.setNamespace("http://tempuri.org/");
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");

                info.elementType = new PropertyInfo();
                //info.elementType.type = Vectorpois.class;
                info.elementType.type = lstFamilyTypeCategory.getClass();
                info.elementType.name = "pois";
                info.elementType.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                //info.elementType = elementInfo;

                //info.setNamespace("http://schemas.microsoft.com/2003/10/Serialization/Arrays");
                //info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
        }
    }


    public String getInnerText() {
        return null;
    }


    public void setInnerText(String s) {
    }


    @Override
    public void setProperty(int arg0, Object arg1) {
    }

}

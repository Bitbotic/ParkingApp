package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class pois implements KvmSerializable {

    public categoryTypes poiCategory;
    public String poiFamily;
    public String poiType;

    public pois() {
    }

    public pois(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("poiCategory")) {
            SoapObject j = (SoapObject) soapObject.getProperty("poiCategory");
            poiCategory = new categoryTypes(j);

        }
        if (soapObject.hasProperty("poiFamily")) {
            Object obj = soapObject.getProperty("poiFamily");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                poiFamily = j.toString();
            } else if (obj != null && obj instanceof String) {
                poiFamily = (String) obj;
            }
        }
        if (soapObject.hasProperty("poiType")) {
            Object obj = soapObject.getProperty("poiType");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                poiType = j.toString();
            } else if (obj != null && obj instanceof String) {
                poiType = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return poiCategory;
            case 1:
                return poiFamily;
            case 2:
                return poiType;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = categoryTypes.class;
                info.name = "poiCategory";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "poiFamily";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "poiType";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
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

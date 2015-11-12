package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class coordinate implements KvmSerializable {

    public String latitude;
    public String longitude;

    public coordinate() {
    }

    public coordinate(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("latitude")) {
            Object obj = soapObject.getProperty("latitude");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                latitude = j.toString();
            } else if (obj != null && obj instanceof String) {
                latitude = (String) obj;
            }
        }
        if (soapObject.hasProperty("longitude")) {
            Object obj = soapObject.getProperty("longitude");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                longitude = j.toString();
            } else if (obj != null && obj instanceof String) {
                longitude = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return latitude;
            case 1:
                return longitude;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "latitude";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "longitude";
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

package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class poiDetailImage implements KvmSerializable {

    public String description;
    public String urlImage;

    public poiDetailImage() {
    }

    public poiDetailImage(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("description")) {
            Object obj = soapObject.getProperty("description");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                description = j.toString();
            } else if (obj != null && obj instanceof String) {
                description = (String) obj;
            }
        }
        if (soapObject.hasProperty("urlImage")) {
            Object obj = soapObject.getProperty("urlImage");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                urlImage = j.toString();
            } else if (obj != null && obj instanceof String) {
                urlImage = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return description;
            case 1:
                return urlImage;
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
                info.name = "description";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "urlImage";
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

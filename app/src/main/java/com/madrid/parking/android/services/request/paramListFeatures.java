package com.madrid.parking.android.services.request;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class paramListFeatures implements KvmSerializable {

    public String language;
    public boolean publicData;
    public boolean publicDataSpecified;

    public paramListFeatures() {
    }

    public paramListFeatures(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("language")) {
            Object obj = soapObject.getProperty("language");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                language = j.toString();
            } else if (obj != null && obj instanceof String) {
                language = (String) obj;
            }
        }
        if (soapObject.hasProperty("publicData")) {
            Object obj = soapObject.getProperty("publicData");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                publicData = Boolean.parseBoolean(j.toString());
            } else if (obj != null && obj instanceof Boolean) {
                publicData = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("publicDataSpecified")) {
            Object obj = soapObject.getProperty("publicDataSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                publicDataSpecified = Boolean.parseBoolean(j.toString());
            } else if (obj != null && obj instanceof Boolean) {
                publicDataSpecified = (Boolean) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return language;
            case 1:
                return publicData;
            case 2:
                return publicDataSpecified;
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
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "language";
                break;
            case 1:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "publicData";
                break;
            case 2:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "publicDataSpecified";
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

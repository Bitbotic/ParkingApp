package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class access implements KvmSerializable {

    public String address;
    public String code;
    public String latitude;
    public String longitude;
    public String name;
    public String urlIcon;

    public access() {
    }

    public access(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("address")) {
            Object obj = soapObject.getProperty("address");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                address = j.toString();
            } else if (obj != null && obj instanceof String) {
                address = (String) obj;
            }
        }
        if (soapObject.hasProperty("code")) {
            Object obj = soapObject.getProperty("code");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                code = j.toString();
            } else if (obj != null && obj instanceof String) {
                code = (String) obj;
            }
        }
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
        if (soapObject.hasProperty("name")) {
            Object obj = soapObject.getProperty("name");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                name = j.toString();
            } else if (obj != null && obj instanceof String) {
                name = (String) obj;
            }
        }
        if (soapObject.hasProperty("urlIcon")) {
            Object obj = soapObject.getProperty("urlIcon");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                urlIcon = j.toString();
            } else if (obj != null && obj instanceof String) {
                urlIcon = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return address;
            case 1:
                return code;
            case 2:
                return latitude;
            case 3:
                return longitude;
            case 4:
                return name;
            case 5:
                return urlIcon;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 6;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "address";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "code";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "latitude";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "longitude";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "name";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "urlIcon";
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

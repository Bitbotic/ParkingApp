package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class feature implements KvmSerializable {

    public String code;
    public String content;
    public String name;
    public String nameField;
    public String nameFieldTranslated;
    public String urlIcon;

    public feature() {
    }

    public feature(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("code")) {
            Object obj = soapObject.getProperty("code");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                code = j.toString();
            } else if (obj != null && obj instanceof String) {
                code = (String) obj;
            }
        }
        if (soapObject.hasProperty("content")) {
            Object obj = soapObject.getProperty("content");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                content = j.toString();
            } else if (obj != null && obj instanceof String) {
                content = (String) obj;
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
        if (soapObject.hasProperty("nameField")) {
            Object obj = soapObject.getProperty("nameField");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                nameField = j.toString();
            } else if (obj != null && obj instanceof String) {
                nameField = (String) obj;
            }
        }
        if (soapObject.hasProperty("nameFieldTranslated")) {
            Object obj = soapObject.getProperty("nameFieldTranslated");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                nameFieldTranslated = j.toString();
            } else if (obj != null && obj instanceof String) {
                nameFieldTranslated = (String) obj;
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
                return code;
            case 1:
                return content;
            case 2:
                return name;
            case 3:
                return nameField;
            case 4:
                return nameFieldTranslated;
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
                info.name = "code";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "content";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "name";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nameField";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nameFieldTranslated";
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

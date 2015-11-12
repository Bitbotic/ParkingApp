package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class poisType implements KvmSerializable {

    public String category;
    public String categoryCode;
    public String family;
    public String familyCode;
    public String type;
    public String typeCode;
    public String urlIcon;

    public poisType() {
    }

    public poisType(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("category")) {
            Object obj = soapObject.getProperty("category");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                category = j.toString();
            } else if (obj != null && obj instanceof String) {
                category = (String) obj;
            }
        }
        if (soapObject.hasProperty("categoryCode")) {
            Object obj = soapObject.getProperty("categoryCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                categoryCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                categoryCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("family")) {
            Object obj = soapObject.getProperty("family");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                family = j.toString();
            } else if (obj != null && obj instanceof String) {
                family = (String) obj;
            }
        }
        if (soapObject.hasProperty("familyCode")) {
            Object obj = soapObject.getProperty("familyCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                familyCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                familyCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("type")) {
            Object obj = soapObject.getProperty("type");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                type = j.toString();
            } else if (obj != null && obj instanceof String) {
                type = (String) obj;
            }
        }
        if (soapObject.hasProperty("typeCode")) {
            Object obj = soapObject.getProperty("typeCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                typeCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                typeCode = (String) obj;
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
                return category;
            case 1:
                return categoryCode;
            case 2:
                return family;
            case 3:
                return familyCode;
            case 4:
                return type;
            case 5:
                return typeCode;
            case 6:
                return urlIcon;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 7;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "category";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "categoryCode";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "family";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "familyCode";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "type";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "typeCode";
                break;
            case 6:
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

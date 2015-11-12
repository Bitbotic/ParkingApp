package com.madrid.parking.android.services.response;

/**
 * Created by Marcin on 23/10/2015.
 */

import com.madrid.parking.android.model.VectorParking;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class responsePoiInfoParking implements KvmSerializable {

    public VectorParking data;
    public int code;
    public boolean codeSpecified;
    public String message;

    public responsePoiInfoParking() {
    }

    public responsePoiInfoParking(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("Data")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Data");
            data = new VectorParking(j);
        }
        if (soapObject.hasProperty("code")) {
            Object obj = soapObject.getProperty("code");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                code = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                code = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("codeSpecified")) {
            Object obj = soapObject.getProperty("codeSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                codeSpecified = Boolean.parseBoolean(j.toString());
            } else if (obj != null && obj instanceof Boolean) {
                codeSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("message")) {
            Object obj = soapObject.getProperty("message");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                message = j.toString();
            } else if (obj != null && obj instanceof String) {
                message = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return data;
            case 1:
                return code;
            case 2:
                return codeSpecified;
            case 3:
                return message;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "Data";
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "code";
                break;
            case 2:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "codeSpecified";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "message";
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

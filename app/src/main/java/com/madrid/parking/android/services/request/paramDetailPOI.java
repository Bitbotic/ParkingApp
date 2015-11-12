package com.madrid.parking.android.services.request;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class paramDetailPOI implements KvmSerializable {

    public String family;
    public int id;
    //public boolean idSpecified;
    public String language;

    public paramDetailPOI() {
    }

    public paramDetailPOI(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("family")) {
            Object obj = soapObject.getProperty("family");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                family = j.toString();
            } else if (obj != null && obj instanceof String) {
                family = (String) obj;
            }
        }
        if (soapObject.hasProperty("id")) {
            Object obj = soapObject.getProperty("id");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                id = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                id = (Integer) obj;
            }
        }
        /*
        if (soapObject.hasProperty("idSpecified"))
        {
            Object obj = soapObject.getProperty("idSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                idSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                idSpecified = (Boolean) obj;
            }
        }*/
        if (soapObject.hasProperty("language")) {
            Object obj = soapObject.getProperty("language");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                language = j.toString();
            } else if (obj != null && obj instanceof String) {
                language = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return family;
            case 1:
                return id;
            /*
            case 2:
                return idSpecified;*/
            case 2:
                return language;
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
                info.name = "family";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "id";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
           /*
            case 2:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "idSpecified";
                break;*/
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "language";
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

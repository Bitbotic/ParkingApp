package com.madrid.parking.android.services.request;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class paramDetailParking implements KvmSerializable {

    //public Date date;
    public String date;
    public String family;
    public int id;
    public boolean idSpecified;
    public String language;
    public boolean publicData;
    public boolean publicDataSpecified;

    public paramDetailParking() {
    }

    public paramDetailParking(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("date")) {
            Object obj = soapObject.getProperty("date");

            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                date = j.toString();

                //String a = j.toString();
                /*
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss", Locale.getDefault());
                try {
                    date = sdf.parse(a);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
               */
            } else if (obj != null && obj instanceof String) {
                date = (String) obj;
                //String a = (String) obj;
                /*
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss", Locale.getDefault());
                try {
                    date = sdf.parse(a);
                } catch (ParseException e) {
                    e.printStackTrace();
                }*/

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
        if (soapObject.hasProperty("id")) {
            Object obj = soapObject.getProperty("id");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                id = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                id = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("idSpecified")) {
            Object obj = soapObject.getProperty("idSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idSpecified = Boolean.parseBoolean(j.toString());
            } else if (obj != null && obj instanceof Boolean) {
                idSpecified = (Boolean) obj;
            }
        }
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
                return date;
            case 1:
                return family;
            case 2:
                return id;
            case 3:
                return idSpecified;
            case 4:
                return language;
            case 5:
                return publicData;
            case 6:
                return publicDataSpecified;
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
                //info.type = Date.class;
                info.name = "date";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "family";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
            case 2:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "id";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
            case 3:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "idSpecified";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "language";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
            case 5:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "publicData";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                break;
            case 6:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "publicDataSpecified";
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

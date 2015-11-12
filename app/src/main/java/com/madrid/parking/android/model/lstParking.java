package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class lstParking implements KvmSerializable {

    public String address;
    public String administrativeArea;
    public String areaCode;
    public String category;
    public String country;
    public String family;
    public String familyCode;
    public int id;
    public boolean idSpecified;
    public String latitude;
    public String longitude;
    public String name;
    public String nickName;
    public String state;
    public String town;
    public String type;

    public lstParking() {
    }

    public lstParking(SoapObject soapObject) {
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
        if (soapObject.hasProperty("administrativeArea")) {
            Object obj = soapObject.getProperty("administrativeArea");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                administrativeArea = j.toString();
            } else if (obj != null && obj instanceof String) {
                administrativeArea = (String) obj;
            }
        }
        if (soapObject.hasProperty("areaCode")) {
            Object obj = soapObject.getProperty("areaCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                areaCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                areaCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("category")) {
            Object obj = soapObject.getProperty("category");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                category = j.toString();
            } else if (obj != null && obj instanceof String) {
                category = (String) obj;
            }
        }
        if (soapObject.hasProperty("country")) {
            Object obj = soapObject.getProperty("country");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                country = j.toString();
            } else if (obj != null && obj instanceof String) {
                country = (String) obj;
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
        if (soapObject.hasProperty("nickName")) {
            Object obj = soapObject.getProperty("nickName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                nickName = j.toString();
            } else if (obj != null && obj instanceof String) {
                nickName = (String) obj;
            }
        }
        if (soapObject.hasProperty("state")) {
            Object obj = soapObject.getProperty("state");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                state = j.toString();
            } else if (obj != null && obj instanceof String) {
                state = (String) obj;
            }
        }
        if (soapObject.hasProperty("town")) {
            Object obj = soapObject.getProperty("town");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                town = j.toString();
            } else if (obj != null && obj instanceof String) {
                town = (String) obj;
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
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return address;
            case 1:
                return administrativeArea;
            case 2:
                return areaCode;
            case 3:
                return category;
            case 4:
                return country;
            case 5:
                return family;
            case 6:
                return familyCode;
            case 7:
                return id;
            case 8:
                return idSpecified;
            case 9:
                return latitude;
            case 10:
                return longitude;
            case 11:
                return name;
            case 12:
                return nickName;
            case 13:
                return state;
            case 14:
                return town;
            case 15:
                return type;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 16;
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
                info.name = "administrativeArea";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "areaCode";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "category";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "country";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "family";
                break;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "familyCode";
                break;
            case 7:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "id";
                break;
            case 8:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "idSpecified";
                break;
            case 9:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "latitude";
                break;
            case 10:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "longitude";
                break;
            case 11:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "name";
                break;
            case 12:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nickName";
                break;
            case 13:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "state";
                break;
            case 14:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "town";
                break;
            case 15:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "type";
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

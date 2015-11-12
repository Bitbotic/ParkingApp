package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class poiDetail implements KvmSerializable {

    public String family;
    public String familyCode;
    public int id;
    public boolean idSpecified;
    public String name;
    public poiDetailGeneral poiDetailGeneral;
    public VectorpoiDetailImage poiDetailImages;
    public poiDetailInfo poiDetailInfo;

    public poiDetail() {
    }

    public poiDetail(SoapObject soapObject) {
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
        if (soapObject.hasProperty("name")) {
            Object obj = soapObject.getProperty("name");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                name = j.toString();
            } else if (obj != null && obj instanceof String) {
                name = (String) obj;
            }
        }
        if (soapObject.hasProperty("poiDetailGeneral")) {
            SoapObject j = (SoapObject) soapObject.getProperty("poiDetailGeneral");
            poiDetailGeneral = new poiDetailGeneral(j);

        }
        if (soapObject.hasProperty("poiDetailImages")) {
            SoapObject j = (SoapObject) soapObject.getProperty("poiDetailImages");
            poiDetailImages = new VectorpoiDetailImage(j);
        }
        if (soapObject.hasProperty("poiDetailInfo")) {
            SoapObject j = (SoapObject) soapObject.getProperty("poiDetailInfo");
            poiDetailInfo = new poiDetailInfo(j);

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return family;
            case 1:
                return familyCode;
            case 2:
                return id;
            case 3:
                return idSpecified;
            case 4:
                return name;
            case 5:
                return poiDetailGeneral;
            case 6:
                return poiDetailImages;
            case 7:
                return poiDetailInfo;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 8;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "family";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "familyCode";
                break;
            case 2:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "id";
                break;
            case 3:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "idSpecified";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "name";
                break;
            case 5:
                info.type = poiDetailGeneral.class;
                info.name = "poiDetailGeneral";
                break;
            case 6:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "poiDetailImages";
                break;
            case 7:
                info.type = poiDetailInfo.class;
                info.name = "poiDetailInfo";
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

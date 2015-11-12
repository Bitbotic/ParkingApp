package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Vector;

public class VectorString extends Vector<String> implements KvmSerializable {

    final public static String MAPPING_NAME = "ArrayOfString";

    public VectorString() {
    }

    public VectorString(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject != null) {
            int size = soapObject.getPropertyCount();
            for (int i0 = 0; i0 < size; i0++) {
                Object obj = soapObject.getProperty(i0);
                if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j0 = (SoapPrimitive) soapObject.getProperty(i0);
                    String j1 = j0.toString();
                    add(j1);
                }
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        return this.get(arg0);
    }

    @Override
    public int getPropertyCount() {
        return this.size();
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        info.name = "string";
        info.type = String.class;
        //info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
        info.setNamespace("http://schemas.microsoft.com/2003/10/Serialization/Arrays");
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

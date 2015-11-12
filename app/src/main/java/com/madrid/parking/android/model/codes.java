package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import com.madrid.parking.android.model.VectorString;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;

public class codes implements KvmSerializable {

    public VectorString lstCodes;

    public codes() {
    }

    public codes(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("lstCodes")) {
            SoapObject j = (SoapObject) soapObject.getProperty("lstCodes");
            lstCodes = new VectorString(j);
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return lstCodes;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 1;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = new VectorString().getClass();
                //info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "lstCodes";
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

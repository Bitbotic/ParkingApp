package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import com.madrid.parking.android.model.VectorString;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;

public class minimumPlacesAvailable implements KvmSerializable {

    public VectorString lstminimumPlacesAvailable;

    public minimumPlacesAvailable() {
    }

    public minimumPlacesAvailable(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("lstminimumPlacesAvailable")) {
            SoapObject j = (SoapObject) soapObject.getProperty("lstminimumPlacesAvailable");
            lstminimumPlacesAvailable = new VectorString(j);
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return lstminimumPlacesAvailable;
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
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "lstminimumPlacesAvailable";
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

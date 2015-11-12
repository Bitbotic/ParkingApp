package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import com.madrid.parking.android.model.VectornameFieldParking;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;

public class nameFieldParkingCodes implements KvmSerializable {

    public VectornameFieldParking lstNameFieldCodes;

    public nameFieldParkingCodes() {
    }

    public nameFieldParkingCodes(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("lstNameFieldCodes")) {
            SoapObject j = (SoapObject) soapObject.getProperty("lstNameFieldCodes");
            lstNameFieldCodes = new VectornameFieldParking(j);
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return lstNameFieldCodes;
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
                info.type = new VectornameFieldParking().getClass();
                //info.type = PropertyInfo.VECTOR_CLASS;
                //info.type ="ArrayOfnameFieldParking";
                info.name = "lstNameFieldCodes";
                info.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");

                /*
                PropertyInfo elementInfo = new PropertyInfo();
                elementInfo.name = "nameFieldParking";
                elementInfo.type = new nameFieldParking().getClass();
                elementInfo.setNamespace("http://schemas.datacontract.org/2004/07/InfoParking");
                info.elementType = elementInfo;
                */

                //info.setNamespace("http://schemas.microsoft.com/2003/10/Serialization/Arrays");
                //info.setNamespace("http://schemas.microsoft.com/2003/10/Serialization/");

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

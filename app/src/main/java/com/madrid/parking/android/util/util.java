package com.madrid.parking.android.util;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by Marcin on 23/09/2015.
 */
public class util {

    public static String url = "https://servicios.emtmadrid.es:8443/InfoParking/InfoParking.svc";

    private static Object getSOAPDateString(java.util.Date itemValue) {
        String lFormatTemplate = "yyyy-MM-dd'T'hh:mm:ss";
        DateFormat lDateFormat = new SimpleDateFormat(lFormatTemplate);
        String lDate = lDateFormat.format(itemValue);

        return lDate;
    }

}

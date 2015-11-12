package com.madrid.parking.android.services;

/**
 * Created by Marcin on 03/10/2015.
 */

import android.os.AsyncTask;
import android.util.Log;

import com.madrid.parking.android.model.MarshalDate;
import com.madrid.parking.android.model.WS_Enums;
import com.madrid.parking.android.services.request.paramDetailPOI;
import com.madrid.parking.android.services.request.paramDetailParking;
import com.madrid.parking.android.services.request.paramInfoParking;
import com.madrid.parking.android.services.request.paramListFeatures;
import com.madrid.parking.android.services.response.responseIconsDescription;
import com.madrid.parking.android.services.response.responseListFeatures;
import com.madrid.parking.android.services.response.responseListParking;
import com.madrid.parking.android.services.response.responseListPoiType;
import com.madrid.parking.android.services.response.responseParkingDetail;
import com.madrid.parking.android.services.response.responsePoiDetail;
import com.madrid.parking.android.services.response.responsePoiInfoParking;
import com.madrid.parking.android.services.response.responseStreetPoisParking;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

public class infoParking {

    public String NAMESPACE = "http://tempuri.org/";
    public String url = "https://servicios.emtmadrid.es:8443/InfoParking/InfoParking.svc";
    public static String idClient = "WEB.SERV.marcin-pogorzelski3@wp.pl";
    public static String passKey = "8963151D-BB49-43C4-9878-27D1D30F9E1F";
    public int timeOut = 60000;
    public DataManagerEvents eventHandler;
    public WS_Enums.SoapProtocolVersion soapVersion;

    public infoParking() {
    }

    public infoParking(DataManagerEvents eventHandler) {
        this.eventHandler = eventHandler;
    }

    public infoParking(DataManagerEvents eventHandler, String url) {
        this.eventHandler = eventHandler;
        this.url = url;
    }

    public infoParking(DataManagerEvents eventHandler, String url, int timeOutInSeconds) {
        this.eventHandler = eventHandler;
        this.url = url;
        this.setTimeOut(timeOutInSeconds);
    }

    public void setTimeOut(int seconds) {
        this.timeOut = seconds * 1000;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void GetListStreetPoisParkingAsync(String idClient, String passkey, String address, String language) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires DataManagerEvents");
        GetListStreetPoisParkingAsync(idClient, passkey, address, language, null);
    }

    public void GetListStreetPoisParkingAsync(final String idClient, final String passkey, final String address, final String language, final List<HeaderProperty> headers) throws Exception {

        new AsyncTask<Void, Void, responseStreetPoisParking>() {
            @Override
            protected void onPreExecute() {
                eventHandler.DataManagerStartedRequest();
            }

            ;

            @Override
            protected responseStreetPoisParking doInBackground(Void... params) {
                return GetListStreetPoisParking(idClient, passkey, address, language, headers);
            }

            @Override
            protected void onPostExecute(responseStreetPoisParking result) {
                eventHandler.DataManagerEndedRequest();
                if (result != null) {
                    eventHandler.DataManagerFinished("GetListStreetPoisParking", result);
                }
            }
        }.execute();
    }

    public responseStreetPoisParking GetListStreetPoisParking(String idClient, String passkey, String address, String language) {
        return GetListStreetPoisParking(idClient, passkey, address, language, null);
    }

    public responseStreetPoisParking GetListStreetPoisParking(String idClient, String passkey, String address, String language, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://tempuri.org/", "GetListStreetPoisParking");
        soapReq.addProperty("idClient", idClient);
        soapReq.addProperty("passkey", passkey);
        soapReq.addProperty("address", address);
        soapReq.addProperty("language", language);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
        try {
            if (headers != null) {
                httpTransport.call("http://tempuri.org/iInfoParking/GetListStreetPoisParking", soapEnvelope, headers);
            } else {
                httpTransport.call("http://tempuri.org/iInfoParking/GetListStreetPoisParking", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault) {
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.DataManagerFinishedWithException(ex);
            } else {
                SoapObject result = (SoapObject) retObj;
                if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject) obj;
                    responseStreetPoisParking resultVariable = new responseStreetPoisParking(j);
                    return resultVariable;

                }
            }
        } catch (Exception e) {
            if (eventHandler != null)
                eventHandler.DataManagerFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }

    public void GetInfoParkingPoisForCoordinateAsync(String idClient, String passkey, paramInfoParking parameters) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires DataManagerEvents");
        GetInfoParkingPoisForCoordinateAsync(idClient, passkey, parameters, null);
    }

    public void GetInfoParkingPoisForCoordinateAsync(final String idClient, final String passkey, final paramInfoParking parameters, final List<HeaderProperty> headers) throws Exception {

        new AsyncTask<Void, Void, responsePoiInfoParking>() {
            @Override
            protected void onPreExecute() {
                eventHandler.DataManagerStartedRequest();
            }

            ;

            @Override
            protected responsePoiInfoParking doInBackground(Void... params) {
                return GetInfoParkingPoisForCoordinate(idClient, passkey, parameters, headers);
            }

            @Override
            protected void onPostExecute(responsePoiInfoParking result) {
                eventHandler.DataManagerEndedRequest();
                if (result != null) {
                    eventHandler.DataManagerFinished("GetInfoParkingPoisForCoordinate", result);
                }
            }
        }.execute();
    }

    public responsePoiInfoParking GetInfoParkingPoisForCoordinate(String idClient, String passkey, paramInfoParking parameters) {
        return GetInfoParkingPoisForCoordinate(idClient, passkey, parameters, null);
    }

    public responsePoiInfoParking GetInfoParkingPoisForCoordinate(String idClient, String passkey, paramInfoParking parameters, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        soapEnvelope.skipNullProperties = true;
        //soapEnvelope.setAddAdornments(false);

        //This will enable you to pass a Date object as a parameter to your web service
        //MarshalDate md = new MarshalDate();
        //md.register(soapEnvelope);


        SoapObject soapReq = new SoapObject("http://tempuri.org/", "GetInfoParkingPoisForCoordinate");
        soapEnvelope.addMapping("http://tempuri.org/", "parameters", new paramInfoParking().getClass());
        soapReq.addProperty("idClient", idClient);
        soapReq.addProperty("passkey", passkey);

        /*
        SoapObject param = new SoapObject();

        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        String lFormatTemplate = "yyyy-MM-dd'T'hh:mm:ss";
        DateFormat lDateFormat = new SimpleDateFormat(lFormatTemplate);

        PropertyInfo _PropertyInfo = new PropertyInfo();
        _PropertyInfo.setName("dateTimeUse");
        _PropertyInfo.setType(Date.class);
        _PropertyInfo.setValue(lDateFormat.format(currentLocalTime));
        param.addProperty(_PropertyInfo);

        PropertyInfo _Property2 = new PropertyInfo();
        _Property2.setName("dateTimeUseSpecified");
        _Property2.setType(Boolean.class);
        _Property2.setValue(true);
        param.addProperty(_Property2);

        soapReq.addProperty("parameters",param);
        */
        soapReq.addProperty("parameters", parameters);

        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
        httpTransport.debug = true;

        try {
            if (headers != null) {
                httpTransport.call("http://tempuri.org/iInfoParking/GetInfoParkingPoisForCoordinate", soapEnvelope, headers);
            } else {
                httpTransport.call("http://tempuri.org/iInfoParking/GetInfoParkingPoisForCoordinate", soapEnvelope);
            }

            Log.d("dump Request: ", httpTransport.requestDump);

            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault) {
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.DataManagerFinishedWithException(ex);
            } else {
                SoapObject result = (SoapObject) retObj;
                if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject) obj;
                    responsePoiInfoParking resultVariable = new responsePoiInfoParking(j);
                    return resultVariable;

                }
            }
        } catch (Exception e) {
            if (eventHandler != null)
                eventHandler.DataManagerFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }

    public void GetDetailPOIAsync(String idClient, String passkey, paramDetailPOI parametersDetailPOI) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires DataManagerEvents");
        GetDetailPOIAsync(idClient, passkey, parametersDetailPOI, null);
    }

    public void GetDetailPOIAsync(final String idClient, final String passkey, final paramDetailPOI parametersDetailPOI, final List<HeaderProperty> headers) throws Exception {

        new AsyncTask<Void, Void, responsePoiDetail>() {
            @Override
            protected void onPreExecute() {
                eventHandler.DataManagerStartedRequest();
            };

            @Override
            protected responsePoiDetail doInBackground(Void... params) {
                return GetDetailPOI(idClient, passkey, parametersDetailPOI, headers);
            }

            @Override
            protected void onPostExecute(responsePoiDetail result) {
                eventHandler.DataManagerEndedRequest();
                if (result != null) {
                    eventHandler.DataManagerFinished("GetDetailPOI", result);
                }
            }
        }.execute();
    }

    public responsePoiDetail GetDetailPOI(String idClient, String passkey, paramDetailPOI parametersDetailPOI) {
        return GetDetailPOI(idClient, passkey, parametersDetailPOI, null);
    }

    public responsePoiDetail GetDetailPOI(String idClient, String passkey, paramDetailPOI parametersDetailPOI, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://tempuri.org/", "GetDetailPOI");
        soapEnvelope.addMapping("http://tempuri.org/", "parametersDetailPOI", new paramDetailPOI().getClass());
        soapReq.addProperty("idClient", idClient);
        soapReq.addProperty("passkey", passkey);
        soapReq.addProperty("parametersDetailPOI", parametersDetailPOI);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
        httpTransport.debug = true;
        try {
            if (headers != null) {
                httpTransport.call("http://tempuri.org/iInfoParking/GetDetailPOI", soapEnvelope, headers);
            } else {
                httpTransport.call("http://tempuri.org/iInfoParking/GetDetailPOI", soapEnvelope);
            }

            Log.d("dump Request: ", httpTransport.requestDump);

            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault) {
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.DataManagerFinishedWithException(ex);
            } else {
                SoapObject result = (SoapObject) retObj;
                if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject) obj;
                    responsePoiDetail resultVariable = new responsePoiDetail(j);
                    return resultVariable;

                }
            }
        } catch (Exception e) {
            if (eventHandler != null)
                eventHandler.DataManagerFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }

    public void GetDetailParkingAsync(String idClient, String passkey, paramDetailParking parametersDetailParking) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires DataManagerEvents");
        GetDetailParkingAsync(idClient, passkey, parametersDetailParking, null);
    }

    public void GetDetailParkingAsync(final String idClient, final String passkey, final paramDetailParking parametersDetailParking, final List<HeaderProperty> headers) throws Exception {

        new AsyncTask<Void, Void, responseParkingDetail>() {
            @Override
            protected void onPreExecute() {
                eventHandler.DataManagerStartedRequest();
            };

            @Override
            protected responseParkingDetail doInBackground(Void... params) {
                return GetDetailParking(idClient, passkey, parametersDetailParking, headers);
            }

            @Override
            protected void onPostExecute(responseParkingDetail result) {
                eventHandler.DataManagerEndedRequest();
                if (result != null) {
                    eventHandler.DataManagerFinished("GetDetailParking", result);
                }
            }
        }.execute();
    }

    public responseParkingDetail GetDetailParking(String idClient, String passkey, paramDetailParking parametersDetailParking) {
        return GetDetailParking(idClient, passkey, parametersDetailParking, null);
    }

    public responseParkingDetail GetDetailParking(String idClient, String passkey, paramDetailParking parametersDetailParking, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        //soapEnvelope.setAddAdornments(false);

        MarshalDate md = new MarshalDate();
        md.register(soapEnvelope);

        SoapObject soapReq = new SoapObject("http://tempuri.org/", "GetDetailParking");
        soapEnvelope.addMapping("http://tempuri.org/", "parametersDetailParking", new paramDetailParking().getClass());
        soapReq.addProperty("idClient", idClient);
        soapReq.addProperty("passkey", passkey);
        soapReq.addProperty("parametersDetailParking", parametersDetailParking);

        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
        httpTransport.debug = true;
        try {
            if (headers != null) {
                httpTransport.call("http://tempuri.org/iInfoParking/GetDetailParking", soapEnvelope, headers);
            } else {
                httpTransport.call("http://tempuri.org/iInfoParking/GetDetailParking", soapEnvelope);
            }

            Log.d("dump Request: ", httpTransport.requestDump);

            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault) {
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.DataManagerFinishedWithException(ex);
            } else {
                SoapObject result = (SoapObject) retObj;
                if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject) obj;
                    responseParkingDetail resultVariable = new responseParkingDetail(j);
                    return resultVariable;

                }
            }
        } catch (Exception e) {
            if (eventHandler != null)
                eventHandler.DataManagerFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }

    public void GetListTypesPOIsAsync(String idClient, String passkey, String language) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires DataManagerEvents");
        GetListTypesPOIsAsync(idClient, passkey, language, null);
    }

    public void GetListTypesPOIsAsync(final String idClient, final String passkey, final String language, final List<HeaderProperty> headers) throws Exception {

        new AsyncTask<Void, Void, responseListPoiType>() {
            @Override
            protected void onPreExecute() {
                eventHandler.DataManagerStartedRequest();
            }

            ;

            @Override
            protected responseListPoiType doInBackground(Void... params) {
                return GetListTypesPOIs(idClient, passkey, language, headers);
            }

            @Override
            protected void onPostExecute(responseListPoiType result) {
                eventHandler.DataManagerEndedRequest();
                if (result != null) {
                    eventHandler.DataManagerFinished("GetListTypesPOIs", result);
                }
            }
        }.execute();
    }

    public responseListPoiType GetListTypesPOIs(String idClient, String passkey, String language) {
        return GetListTypesPOIs(idClient, passkey, language, null);
    }

    public responseListPoiType GetListTypesPOIs(String idClient, String passkey, String language, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://tempuri.org/", "GetListTypesPOIs");
        soapReq.addProperty("idClient", idClient);
        soapReq.addProperty("passkey", passkey);
        soapReq.addProperty("language", language);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
        try {
            if (headers != null) {
                httpTransport.call("http://tempuri.org/iInfoParking/GetListTypesPOIs", soapEnvelope, headers);
            } else {
                httpTransport.call("http://tempuri.org/iInfoParking/GetListTypesPOIs", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault) {
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.DataManagerFinishedWithException(ex);
            } else {
                SoapObject result = (SoapObject) retObj;
                if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject) obj;
                    responseListPoiType resultVariable = new responseListPoiType(j);
                    return resultVariable;

                }
            }
        } catch (Exception e) {
            if (eventHandler != null)
                eventHandler.DataManagerFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }

    public void GetListFeaturesAsync(String idClient, String passkey, paramListFeatures parametersListFeatures) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires DataManagerEvents");
        GetListFeaturesAsync(idClient, passkey, parametersListFeatures, null);
    }

    public void GetListFeaturesAsync(final String idClient, final String passkey, final paramListFeatures parametersListFeatures, final List<HeaderProperty> headers) throws Exception {

        new AsyncTask<Void, Void, responseListFeatures>() {
            @Override
            protected void onPreExecute() {
                eventHandler.DataManagerStartedRequest();
            }

            ;

            @Override
            protected responseListFeatures doInBackground(Void... params) {
                return GetListFeatures(idClient, passkey, parametersListFeatures, headers);
            }

            @Override
            protected void onPostExecute(responseListFeatures result) {
                eventHandler.DataManagerEndedRequest();
                if (result != null) {
                    eventHandler.DataManagerFinished("GetListFeatures", result);
                }
            }
        }.execute();
    }

    public responseListFeatures GetListFeatures(String idClient, String passkey, paramListFeatures parametersListFeatures) {
        return GetListFeatures(idClient, passkey, parametersListFeatures, null);
    }

    public responseListFeatures GetListFeatures(String idClient, String passkey, paramListFeatures parametersListFeatures, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://tempuri.org/", "GetListFeatures");
        soapEnvelope.addMapping("http://tempuri.org/", "parametersListFeatures", new paramListFeatures().getClass());
        soapReq.addProperty("idClient", idClient);
        soapReq.addProperty("passkey", passkey);
        soapReq.addProperty("parametersListFeatures", parametersListFeatures);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
        try {
            if (headers != null) {
                httpTransport.call("http://tempuri.org/iInfoParking/GetListFeatures", soapEnvelope, headers);
            } else {
                httpTransport.call("http://tempuri.org/iInfoParking/GetListFeatures", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault) {
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.DataManagerFinishedWithException(ex);
            } else {
                SoapObject result = (SoapObject) retObj;
                if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject) obj;
                    responseListFeatures resultVariable = new responseListFeatures(j);
                    return resultVariable;

                }
            }
        } catch (Exception e) {
            if (eventHandler != null)
                eventHandler.DataManagerFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }

    public void GetDescriptionIconAsync(String idClient, String passkey, String language) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires DataManagerEvents");
        GetDescriptionIconAsync(idClient, passkey, language, null);
    }

    public void GetDescriptionIconAsync(final String idClient, final String passkey, final String language, final List<HeaderProperty> headers) throws Exception {

        new AsyncTask<Void, Void, responseIconsDescription>() {
            @Override
            protected void onPreExecute() {
                eventHandler.DataManagerStartedRequest();
            }

            ;

            @Override
            protected responseIconsDescription doInBackground(Void... params) {
                return GetDescriptionIcon(idClient, passkey, language, headers);
            }

            @Override
            protected void onPostExecute(responseIconsDescription result) {
                eventHandler.DataManagerEndedRequest();
                if (result != null) {
                    eventHandler.DataManagerFinished("GetDescriptionIcon", result);
                }
            }
        }.execute();
    }

    public responseIconsDescription GetDescriptionIcon(String idClient, String passkey, String language) {
        return GetDescriptionIcon(idClient, passkey, language, null);
    }

    public responseIconsDescription GetDescriptionIcon(String idClient, String passkey, String language, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://tempuri.org/", "GetDescriptionIcon");
        soapReq.addProperty("idClient", idClient);
        soapReq.addProperty("passkey", passkey);
        soapReq.addProperty("language", language);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
        try {
            if (headers != null) {
                httpTransport.call("http://tempuri.org/iInfoParking/GetDescriptionIcon", soapEnvelope, headers);
            } else {
                httpTransport.call("http://tempuri.org/iInfoParking/GetDescriptionIcon", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault) {
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.DataManagerFinishedWithException(ex);
            } else {
                SoapObject result = (SoapObject) retObj;
                if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject) obj;
                    responseIconsDescription resultVariable = new responseIconsDescription(j);
                    return resultVariable;

                }
            }
        } catch (Exception e) {
            if (eventHandler != null)
                eventHandler.DataManagerFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }

    public void GetListParkingAsync(String idClient, String passkey, String language) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires DataManagerEvents");
        GetListParkingAsync(idClient, passkey, language, null);
    }

    public void GetListParkingAsync(final String idClient, final String passkey, final String language, final List<HeaderProperty> headers) throws Exception {

        new AsyncTask<Void, Void, responseListParking>() {
            @Override
            protected void onPreExecute() {
                eventHandler.DataManagerStartedRequest();
            }

            ;

            @Override
            protected responseListParking doInBackground(Void... params) {
                return GetListParking(idClient, passkey, language, headers);
            }

            @Override
            protected void onPostExecute(responseListParking result) {
                eventHandler.DataManagerEndedRequest();
                if (result != null) {
                    eventHandler.DataManagerFinished("GetListParking", result);
                }
            }
        }.execute();
    }

    public responseListParking GetListParking(String idClient, String passkey, String language) {
        return GetListParking(idClient, passkey, language, null);
    }

    public responseListParking GetListParking(String idClient, String passkey, String language, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://tempuri.org/", "GetListParking");
        soapReq.addProperty("idClient", idClient);
        soapReq.addProperty("passkey", passkey);
        soapReq.addProperty("language", language);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
        httpTransport.debug = true;
        try {
            if (headers != null) {
                httpTransport.call("http://tempuri.org/iInfoParking/GetListParking", soapEnvelope, headers);
            } else {
                httpTransport.call("http://tempuri.org/iInfoParking/GetListParking", soapEnvelope);
            }

            Log.d("dump Request: ", httpTransport.requestDump);

            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault) {
                SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.DataManagerFinishedWithException(ex);
            } else {
                SoapObject result = (SoapObject) retObj;
                if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject) obj;
                    responseListParking resultVariable = new responseListParking(j);
                    return resultVariable;

                }
            }
        } catch (Exception e) {
            if (eventHandler != null)
                eventHandler.DataManagerFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }

}

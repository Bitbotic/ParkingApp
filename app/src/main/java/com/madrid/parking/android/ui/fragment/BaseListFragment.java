package com.madrid.parking.android.ui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.madrid.parking.android.services.DataManagerEvents;
import com.madrid.parking.android.services.infoParking;
import com.madrid.parking.android.services.request.paramInfoParking;
import com.madrid.parking.android.util.GPSTracker;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Marcin on 21/10/2015.
 */
public abstract class BaseListFragment extends BaseFragment implements DataManagerEvents {

    //TODO abstract here more code from childs
    protected static Double latitude, longitude;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initCommonData();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        startRetriveData();
    }

    private void initCommonData() {

        GPSTracker tracker = new GPSTracker(getActivity());
        if (!tracker.canGetLocation()) {
            tracker.showSettingsAlert();
        } else {
            latitude = tracker.getLatitude();
            longitude = tracker.getLongitude();
        }

    }

    private void startRetriveData() {


        //TODO Move to STATIC CONSTANTS
        String idClient = "WEB.SERV.marcin-pogorzelski3@wp.pl";
        String passKey = "8963151D-BB49-43C4-9878-27D1D30F9E1F";

        infoParking ip = new infoParking(this);
        SoapObject request = new SoapObject();


        SoapObject cords = new SoapObject();
        cords.addProperty("latitude", latitude);
        cords.addProperty("longitude", longitude);
        //Remove hardcode when Testing
        //cords.addProperty("latitude", "40.409438");
        //cords.addProperty("longitude", "-3.760356");
        request.addProperty("coordinate", cords);

        SoapObject TFamilyTTypeTCategory = new SoapObject();

        //Parques y centros de ocio
        SoapPrimitive parquesCentrosOcios = new SoapPrimitive("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "String", "031");
        //Instalaciones Culturales
        SoapPrimitive instalacionesCulturales = new SoapPrimitive("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "String", "032");
        //Edificios y moumentos
        SoapPrimitive edificiosMoumentos = new SoapPrimitive("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "String", "033");
        //Parques y Jardines
        SoapPrimitive parquesJardines = new SoapPrimitive("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "String", "034");
        //Servicios
        SoapPrimitive servicios = new SoapPrimitive("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "String", "035");
        SoapObject lstCategoryTypes = new SoapObject();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (preferences.getBoolean("turist_op_1", false))
            lstCategoryTypes.addProperty("String", parquesCentrosOcios);
        if (preferences.getBoolean("turist_op_2", false))
            lstCategoryTypes.addProperty("String", instalacionesCulturales);
        if (preferences.getBoolean("turist_op_3", false))
            lstCategoryTypes.addProperty("String", edificiosMoumentos);
        if (preferences.getBoolean("turist_op_4", false))
            lstCategoryTypes.addProperty("String", parquesJardines);
        if (preferences.getBoolean("turist_op_5", false))
            lstCategoryTypes.addProperty("String", servicios);


        SoapObject poiCategory = new SoapObject();
        poiCategory.addProperty("lstCategoryTypes", lstCategoryTypes);

        SoapObject pois = new SoapObject();
        pois.addProperty("poiCategory", poiCategory);
        pois.addProperty("poiType", "001");
        pois.addProperty("poiFamily", "002");


        SoapObject lstFamilyTypeCategory = new SoapObject();
        lstFamilyTypeCategory.addProperty("pois", pois);


        TFamilyTTypeTCategory.addProperty("lstFamilyTypeCategory", lstFamilyTypeCategory);


        request.addProperty("TFamilyTTypeTCategory", TFamilyTTypeTCategory);

        SoapObject codes = new SoapObject();
        SoapObject lstCodes = new SoapObject();
        SoapPrimitive bb = new SoapPrimitive("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "String", "031");
        lstCodes.addProperty("String", bb);

        codes.addProperty("lstCodes", lstCodes);

        SoapObject nameFieldParking = new SoapObject();
        nameFieldParking.addProperty("nameField", "Tipo Plaza");
        nameFieldParking.addProperty("codes", codes);

        SoapObject lstNameFieldCodes = new SoapObject();
        lstNameFieldCodes.addProperty("nameFieldParking", nameFieldParking);


        SoapObject nameFieldCodes = new SoapObject();
        nameFieldCodes.addProperty("lstNameFieldCodes", lstNameFieldCodes);

        if (!preferences.getBoolean("parking_op", true))
            request.addProperty("nameFieldCodes",nameFieldCodes);

        //request.addProperty("nameFieldCodes",new SoapObject());

        //request.addProperty("TFamilyTTypeTCategory",null);


        request.addProperty("dateTimeUseSpecified", true);

        //Set current Date
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        String lFormatTemplate = "yyyy-MM-dd'T'hh:mm:ss";
        DateFormat lDateFormat = new SimpleDateFormat(lFormatTemplate);
        String lDate = lDateFormat.format(currentLocalTime);

        request.addProperty("dateTimeUse", lDate);

        //SoapObject minimum = new SoapObject();
        //minimum.addProperty("lstminimumPlacesAvailable",new SoapObject());
        //request.addProperty("minimumPlacesAvailable", minimum);
        //request.addProperty("nameFieldCodes", null);

        request.addProperty("radius", "10");
        request.addProperty("language", "es");
        //request.addProperty("publicData",true);
        paramInfoParking parametersInfoParking = new paramInfoParking(request);

        try {
            //ip.GetListFeaturesAsync(idClient, passKey,parametersListFeatures, null);

            ip.GetInfoParkingPoisForCoordinateAsync(idClient, passKey, parametersInfoParking, null);

/*
            SoapObject req = new SoapObject();

            Calendar cal2 = Calendar.getInstance();
            Date current2LocalTime = cal2.getTime();
            DateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
            date.setTimeZone(TimeZone.getTimeZone("UTC-06"));
            String localTime = date.format(current2LocalTime);


            req.addProperty("date",localTime);
            req.addProperty("family","001");
            req.addProperty("id",7);
            req.addProperty("idSpecified",true);
            req.addProperty("language","es");
            req.addProperty("publicData",true);
            paramDetailParking parametersDetailParking  = new paramDetailParking(req);
*/

            /*

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("family","001");
            parameters.put("family","001");
            parameters.put("id",7);
            parameters.put("idSpecified",true);
            parameters.put("language","es");
            parameters.put("publicData",true);
            parameters.put("date",new Date("2015-09-23T00:00:00"));
            */
            //Object res = util.callMethod(parameters);

            //ip.GetDetailParkingAsync(idClient, passKey, parametersDetailParking, null);


            /*
            SoapObject reqq = new SoapObject();
            reqq.addProperty("family","002");
            reqq.addProperty("id",-1);
            //reqq.addProperty("idSpecified",true);
            reqq.addProperty("language","es");
            //reqq.addProperty("publicData", true);

            paramDetailPOI parametersDetailPOI = new paramDetailPOI(reqq);

            ip.GetDetailPOIAsync(idClient, passKey, parametersDetailPOI, null);
            */

            /*
            SoapObject requestt = new SoapObject();
            requestt.addProperty("language", "es");
            requestt.addProperty("publicData", true);
            paramListFeatures parametersListFeatures = new paramListFeatures(requestt);

            ip.GetListFeaturesAsync(idClient, passKey,parametersListFeatures, null);
            */
            //ip.GetListParkingAsync(idClient, passKey, "es", null);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



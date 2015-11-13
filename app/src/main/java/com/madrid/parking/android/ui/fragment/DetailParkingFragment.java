package com.madrid.parking.android.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.parking.myparking.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.madrid.parking.android.model.Parking;
import com.madrid.parking.android.model.feature;
import com.madrid.parking.android.model.parkingDetails;
import com.madrid.parking.android.model.poiDetail;
import com.madrid.parking.android.services.infoParking;
import com.madrid.parking.android.services.request.paramDetailPOI;
import com.madrid.parking.android.services.request.paramDetailParking;
import com.madrid.parking.android.services.response.responseParkingDetail;

import org.ksoap2.serialization.SoapObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Vector;

/**
 * Created by Marcin on 12/11/2015.
 */
public class DetailParkingFragment extends DetailBaseFragment {

    protected View mRootView;
    private TextView mInfo;
    private LinearLayout mContainer;

    private static GoogleMap googleMap;
    private MapView mMapView;

    public static DetailParkingFragment newInstance(Parking parkingModel) {
        DetailParkingFragment fragment = new DetailParkingFragment();

        Bundle arguments = new Bundle(1);
        arguments.putParcelable(ARG_PARKING, parkingModel);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        mRootView = inflater.inflate(R.layout.frag_detail_parking, container, false);
        //mInfo = (TextView) mRootView.findViewById(R.id.textview_info);
        mContainer = (LinearLayout) mRootView.findViewById(R.id.container);

        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMapView = (MapView) getActivity().findViewById(R.id.main_mapview);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(Double.parseDouble(mParkingModel.latitude), Double.parseDouble(mParkingModel.longitude))).zoom(12).build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        googleMap.getUiSettings().setScrollGesturesEnabled(false);
        googleMap.getUiSettings().setZoomGesturesEnabled(false);

        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mAppBarLayout.expandToolbar(true);
            }
        });

        final LatLng point = new LatLng(Double.parseDouble(mParkingModel.latitude), Double.parseDouble(mParkingModel.longitude));

        Marker marker = googleMap.addMarker(new MarkerOptions().position(point)
                        .title(mParkingModel.address).snippet(mParkingModel.familyName)
        );


        mMapView.setVisibility(View.VISIBLE);
        mThumbnail.setVisibility(View.GONE);

        infoParking ip = new infoParking(this);

        //TODO Move to STATIC CONSTANTS
        String idClient = "WEB.SERV.marcin-pogorzelski3@wp.pl";
        String passKey = "8963151D-BB49-43C4-9878-27D1D30F9E1F";

        Calendar cal2 = Calendar.getInstance();
        Date current2LocalTime = cal2.getTime();
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        date.setTimeZone(TimeZone.getTimeZone("UTC-06"));
        String localTime = date.format(current2LocalTime);

        SoapObject request = new SoapObject();
        request.addProperty("date", localTime);
        request.addProperty("family", mParkingModel.family);
        request.addProperty("id", mParkingModel.id);
        request.addProperty("idSpecified", true);
        request.addProperty("language", "es");
        request.addProperty("publicData", true);
        paramDetailParking parametersDetail = new paramDetailParking(request);

        try {
            ip.GetDetailParkingAsync(idClient, passKey, parametersDetail, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void DataManagerStartedRequest() {

    }

    private void loadUI(parkingDetails data) {

        if (mCollapsingToolbarLayout != null) {
            mCollapsingToolbarLayout.setTitle(data.name);
            mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));
            mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        }

        //mInfo.setText(data.schedule);
        create_CardView(data.lstFeatures);
    }


    private void create_CardView(Vector<feature> features) {

        for (int i = 0; i < features.size(); i++) {
            //TODO Move to RecyclerView
            CardView card = new CardView(new ContextThemeWrapper(getActivity(), R.style.CardViewStyle), null, 0);
            LinearLayout cardInner = new LinearLayout(new ContextThemeWrapper(getActivity(), R.style.Widget_CardContent));
            cardInner.setOrientation(LinearLayout.VERTICAL);

            TextView tv_title = new TextView(getActivity());
            tv_title.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            tv_title.setTextAppearance(getActivity(), R.style.TextAppearance_AppCompat_Title);
            tv_title.setText(features.get(i).name);

            TextView tv_caption = new TextView(getActivity());
            tv_caption.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            tv_caption.setTextAppearance(getActivity(), R.style.TextAppearance_AppCompat_Title);
            tv_caption.setText(features.get(i).content);

            cardInner.addView(tv_title);
            cardInner.addView(tv_caption);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            int margin = 8;
            params.setMargins(margin, margin, margin, margin);
            card.setLayoutParams(params);

            card.addView(cardInner);

            if (features.get(i).content != null)
                mContainer.addView(card);
        }
    }

    @Override
    public void DataManagerFinished(String methodName, Object Data) {

        responseParkingDetail response = (responseParkingDetail) Data;

        if (response != null) {
            loadUI(response.data.get(0));
        }

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void DataManagerFinishedWithException(Exception ex) {

    }

    @Override
    public void DataManagerEndedRequest() {

    }
}

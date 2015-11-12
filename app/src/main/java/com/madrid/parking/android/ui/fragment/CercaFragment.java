package com.madrid.parking.android.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.parking.myparking.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.madrid.parking.android.controllers.ViewControllers;
import com.madrid.parking.android.model.Parking;
import com.madrid.parking.android.services.response.responsePoiInfoParking;
import com.madrid.parking.android.ui.dialog.DescriptionIconsFragment;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.NonViewAware;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.HashMap;

/**
 * Created by Marcin on 22/09/2015.
 */
public class CercaFragment extends BaseListFragment implements GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {

    static final String TAG = HomeFragment.class.getSimpleName();
    protected View mRootView;
    private static GoogleMap googleMap;
    private MapView mMapView;

    private ImageLoader imageLoader;
    private FloatingActionButton moreInfo;
    private View mDetailPanel;
    private HashMap<String, Parking> myMarkers;

    private final static int REQUEST_CODE = 0;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //If i run a device with API lower than 23, the new onAttach() is not even being called
        if(((AppCompatActivity) getActivity()).getSupportActionBar()!=null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //tested on my API 22 device and onAttach(Context) is being called.
        if(((AppCompatActivity) getActivity()).getSupportActionBar()!=null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(((AppCompatActivity) getActivity()).getSupportActionBar()!=null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(R.layout.frag_cerca, container, false);
        mMapView = (MapView) mRootView.findViewById(R.id.mapView);

        moreInfo = (FloatingActionButton) mRootView.findViewById(R.id.btn_more_info);
        mDetailPanel = mRootView.findViewById(R.id.layout_bottom);

        //Hide by Default
        mDetailPanel.animate()
                .translationYBy(0)
                .translationY(mDetailPanel.getHeight())
                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));

        //setUpMapIfNeeded();
        imageLoader = ImageLoader.getInstance();
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMapClickListener(this);

        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        //googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        // create marker
       /*
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(latitude, longitude)).title("Hello Maps");


        // Changing marker icon
        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        // adding marker
        googleMap.addMarker(marker);
        */

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DescriptionIconsFragment sdf = new DescriptionIconsFragment();
                sdf.setTargetFragment(CercaFragment.this, REQUEST_CODE);
                sdf.show(getActivity().getSupportFragmentManager(), "fsdfd");
            }
        });

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mMapView != null)
            mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void DataManagerStartedRequest() {

    }

    @Override
    public void DataManagerFinished(String methodName, Object Data) {
        //responseListFeatures response = (responseListFeatures)Data;
        //responseListParking response = (responseListParking)Data;
        //responsePoiDetail response = (responsePoiDetail)Data;
        //responseParkingDetail response = (responseParkingDetail)Data;

        responsePoiInfoParking response = (responsePoiInfoParking) Data;

        myMarkers = new HashMap<String, Parking>();

        for (int i = 0; i < response.data.size(); i++) {
            final LatLng point = new LatLng(Double.parseDouble(response.data.get(i).latitude), Double.parseDouble(response.data.get(i).longitude));
            final Parking p = response.data.get(i);

            ImageSize a = new ImageSize(20, 20);
            NonViewAware aa = new NonViewAware(a, ViewScaleType.CROP);
            if(p.icon!=null) {

                imageLoader.displayImage(p.icon, aa, new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        // Do whatever you want with Bitmap
                        super.onLoadingComplete(imageUri, view, loadedImage);

                        Marker marker = googleMap.addMarker(new MarkerOptions().position(point)
                                .title(p.address).snippet(p.familyName)
                                .icon(BitmapDescriptorFactory.fromBitmap(loadedImage)));

                        myMarkers.put(marker.getTitle(),p);
                    }
                });
            }
        }
    }

    @Override
    public void DataManagerFinishedWithException(Exception ex) {

    }

    @Override
    public void DataManagerEndedRequest() {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        mDetailPanel.setVisibility(View.VISIBLE);
        moreInfo.setVisibility(View.GONE);
        //mDetailPanel.setVisibility(View.VISIBLE);

        TextView name = (TextView) mDetailPanel.findViewById(R.id.label_name);
        TextView type = (TextView) mDetailPanel.findViewById(R.id.label_type);
        TextView address = (TextView) mDetailPanel.findViewById(R.id.label_address);
        ImageView icon = (ImageView) mDetailPanel.findViewById(R.id.item_icon);
        Button btnMoreInfo = (Button) mDetailPanel.findViewById(R.id.btn_accept);

        mDetailPanel.animate()
                .translationYBy(mDetailPanel.getHeight())
                .translationY(0)
                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));


        final Parking p = myMarkers.get(marker.getTitle());

        if(p!=null) {

            name.setText(p.name);
            address.setText(p.address);
            type.setText(p.familyName);

            imageLoader.displayImage(p.icon, icon);


            btnMoreInfo.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ViewControllers.goToDetailActivity(getActivity(), p);
                }

            });
        }

        return false;
    }

    @Override
    public void onMapClick(LatLng latLng) {

        mDetailPanel.animate()
                .translationYBy(0)
                .translationY(mDetailPanel.getHeight())
                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));

        moreInfo.setVisibility(View.VISIBLE);
    }
}

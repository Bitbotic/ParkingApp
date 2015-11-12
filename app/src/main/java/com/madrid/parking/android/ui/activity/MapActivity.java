package com.madrid.parking.android.ui.activity;

import com.madrid.parking.android.adapter.MyRecyclerAdapter;
import com.madrid.parking.android.services.DataManagerEvents;
import com.madrid.parking.android.services.infoParking;
import com.madrid.parking.android.services.request.paramListFeatures;
import com.madrid.parking.android.util.SimpleItemTouchHelperCallback;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.os.Bundle;

import com.madrid.parking.android.services.response.responseListParking;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.android.parking.myparking.R;

import org.ksoap2.serialization.SoapObject;

/**
 * Created by Marcin on 21/09/2015.
 */
public class MapActivity extends ActionBarActivity implements DataManagerEvents {

    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    static final LatLng MADRID = new LatLng(40.4167047, -3.7035825);
    private GoogleMap map;
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter adapter;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setHasFixedSize(true);

        // Move the camera instantly to hamburg with a zoom of 15.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(MADRID, 15));

        // Zoom in, animating the camera.
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);


        String idClient = "WEB.SERV.marcin-pogorzelski3@wp.pl";
        String passKey = "8963151D-BB49-43C4-9878-27D1D30F9E1F";

        infoParking ip = new infoParking(this);

        SoapObject request = new SoapObject();
        request.addProperty("language", "es");
        request.addProperty("publicData", true);
        paramListFeatures parametersListFeatures = new paramListFeatures(request);

        try {
            //ip.GetListFeaturesAsync(idClient, passKey,parametersListFeatures, null);

            ip.GetListParkingAsync(idClient, passKey, "es", null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (map != null) {
            map.setMyLocationEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void DataManagerStartedRequest() {

    }

    @Override
    public void DataManagerFinished(String methodName, Object Data) {
        responseListParking response = (responseListParking) Data;

        for (int i = 0; i < response.data.size(); i++) {
            LatLng point = new LatLng(Double.parseDouble(response.data.get(i).latitude), Double.parseDouble(response.data.get(i).longitude));
            Marker hamburg = map.addMarker(new MarkerOptions().position(point)
                    .title(response.data.get(i).address).snippet("Parking Gratis")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.parking)));
        }

        adapter = new MyRecyclerAdapter(MapActivity.this, response.data);
        mRecyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback =
                new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper mIth = new ItemTouchHelper(callback);
        mIth.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void DataManagerFinishedWithException(Exception ex) {

    }

    @Override
    public void DataManagerEndedRequest() {

    }
}

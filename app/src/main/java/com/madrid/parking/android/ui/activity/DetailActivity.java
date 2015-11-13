package com.madrid.parking.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.parking.myparking.R;
import com.madrid.parking.android.model.Parking;
import com.madrid.parking.android.ui.fragment.DetailParkingFragment;
import com.madrid.parking.android.ui.fragment.DetailPoiFragment;

/**
 * Created by Marcin on 22/10/2015.
 */
public class DetailActivity extends BaseActivity {

    private static final String TYPE_FAMILY_TURIST = "002";

    private CoordinatorLayout mCoordinatorLayout;
    private Parking MParkingModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        switchContent = R.id.content_frame;

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);

        configureActionBar();

        Intent intent = getIntent();
        // parking model
        MParkingModel = intent.getParcelableExtra("modelParking");

        if (savedInstanceState == null) {

            if(MParkingModel.family.equalsIgnoreCase(TYPE_FAMILY_TURIST)) {
                final DetailPoiFragment detailPoiFragment = DetailPoiFragment.newInstance(MParkingModel);
                switchContent(detailPoiFragment, detailPoiFragment.getClass().getCanonicalName());
            }else{
                DetailParkingFragment detailParkingFragment = DetailParkingFragment.newInstance(MParkingModel);
                switchContent(detailParkingFragment, detailParkingFragment.getClass().getCanonicalName());
                //Toast.makeText(this, "Not Implemented", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void configureActionBar() {

        final Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_36dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

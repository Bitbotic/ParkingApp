package com.madrid.parking.android.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.parking.myparking.R;
import com.madrid.parking.android.controllers.ViewControllers;
import com.madrid.parking.android.ui.activity.DetailActivity;
import com.madrid.parking.android.ui.activity.MapActivity;
import com.madrid.parking.android.ui.activity.SplashActivity;
import com.madrid.parking.android.util.FontHolder;


/**
 * Created by Marcin on 21/09/2015.
 */
public class HomeFragment extends BaseFragment {

    static final String TAG = HomeFragment.class.getSimpleName();
    protected View mRootView;

    private Button btnMap, btnList, btnPoi, BtnCerca, BtnSettings;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(R.layout.frag_home, container, false);

        btnMap = (Button) mRootView.findViewById(R.id.btn_mapa);

        //btnMap.getBackground().setColorFilter(Color.parseColor("#49495b"), PorterDuff.Mode.MULTIPLY);

        btnList = (Button) mRootView.findViewById(R.id.btn_list);
        btnPoi = (Button) mRootView.findViewById(R.id.btn_poi);
        BtnCerca = (Button) mRootView.findViewById(R.id.btn_close);
        BtnSettings = (Button) mRootView.findViewById(R.id.btn_settings);

        //FontHolder.setTypeface(mRootView,R.id.btn_settings, FontHolder.ADELPHI_PLAIN);
        FontHolder.setTypeface(mRootView, R.id.textview_bitbotic, FontHolder.ADELPHI_PLAIN);

        btnList.setOnClickListener(ListClick);
        btnMap.setOnClickListener(mapClick);


        btnPoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PoiFragment list = new PoiFragment();
                //switchContent(list, "Lisdt");

                Intent intent = new Intent(getActivity(), SplashActivity.class);
                startActivity(intent);
            }
        });

        BtnCerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CercaFragment list = new CercaFragment();
                switchContent(list, "Lisdt");
            }
        });

        BtnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefsFragment settings = new PrefsFragment();
                switchContent(settings, "Lisdt");
            }
        });

        return mRootView;
    }

    private View.OnClickListener ListClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ParkingListFragment list = new ParkingListFragment();
            switchContent(list, "List");
        }

    };

    private View.OnClickListener mapClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
           // ViewControllers.goToMapActivity(getActivity());
            CercaFragment list = new CercaFragment();
            switchContent(list, "Lisdt");
        }

    };
}
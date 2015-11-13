package com.madrid.parking.android.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.parking.myparking.R;
import com.madrid.parking.android.model.Parking;
import com.madrid.parking.android.services.DataManagerEvents;
import com.madrid.parking.android.util.ControllableAppBarLayout;

/**
 * Created by Marcin on 12/11/2015.
 */
public abstract class DetailBaseFragment extends BaseFragment implements DataManagerEvents {

    protected static final String ARG_PARKING = "parking_model";

    //Common UI references
    protected ProgressBar progressBar;
    protected FloatingActionButton mFab;
    protected CollapsingToolbarLayout mCollapsingToolbarLayout;
    protected ControllableAppBarLayout mAppBarLayout;
    protected ImageView mThumbnail;

    //Global Model
    protected Parking mParkingModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRetainInstance(true);
        mParkingModel = getArguments().getParcelable(ARG_PARKING);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        progressBar = (ProgressBar) getActivity().findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        mThumbnail = (ImageView) getActivity().findViewById(R.id.thumbnail);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapse_toolbar);

        mAppBarLayout = (ControllableAppBarLayout) getActivity().findViewById(R.id.MyAppbar);
        mAppBarLayout.collapseToolbar();

        mFab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        /*
        CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) mFab.getLayoutParams();
        p.setAnchorId(View.NO_ID);
        mFab.setLayoutParams(p);
        mFab.setVisibility(View.GONE);
        */

        //mFab.setVisibility(View.GONE);
    }

}

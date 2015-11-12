package com.madrid.parking.android.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.parking.myparking.R;
import com.madrid.parking.android.model.Parking;
import com.madrid.parking.android.model.poiDetail;
import com.madrid.parking.android.services.DataManagerEvents;
import com.madrid.parking.android.services.infoParking;
import com.madrid.parking.android.services.request.paramDetailPOI;
import com.madrid.parking.android.services.response.responsePoiDetail;
import com.madrid.parking.android.util.ControllableAppBarLayout;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.ksoap2.serialization.SoapObject;

/**
 * Created by Marcin on 20/10/2015.
 */
public class DetailPoiFragment extends BaseFragment implements DataManagerEvents {


    private static final String ARG_PARKING = "parking_model";

    protected View mRootView;
    private TextView mDescription, mWebAddress, mPrices, mSchedule, mContact, mEmail;
    private ProgressBar progressBar;
    private ControllableAppBarLayout mAppBarLayout;
    private CoordinatorLayout mCoordinatorLayout;
    private FloatingActionButton mFab;
    private View mContentView;
    private ImageView mThumbnail;
    private ImageLoader imageLoader;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private CardView mCVdescription, mCVweb, mCVprices, mCVschedule, mCVcontact;
    protected Parking mParkingModel;

    public static DetailPoiFragment newInstance(Parking parkingModel) {
        DetailPoiFragment fragment = new DetailPoiFragment();

        Bundle arguments = new Bundle(1);
        arguments.putParcelable(ARG_PARKING, parkingModel);
        fragment.setArguments(arguments);

        return fragment;
    }

    public DetailPoiFragment() {
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRetainInstance(true);
        mParkingModel = getArguments().getParcelable(ARG_PARKING);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //if(mThumbnail==null)
            mThumbnail = (ImageView) getActivity().findViewById(R.id.thumbnail);

        //if(getActivity().findViewById(R.id.MyAppbar)!=null) {
            mAppBarLayout = (ControllableAppBarLayout) getActivity().findViewById(R.id.MyAppbar);

            mAppBarLayout.collapseToolbar();
        //}

        //if(getActivity().findViewById(R.id.collapse_toolbar)!=null)
            mCollapsingToolbarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapse_toolbar);

        //if(getActivity().findViewById(R.id.fab) != null) {
            mFab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
            mFab.setVisibility(View.GONE);
       // }


        //if(getActivity().findViewById(R.id.progress_bar)!=null) {
            progressBar = (ProgressBar) getActivity().findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.VISIBLE);
        //}


        infoParking ip = new infoParking(this);

        //TODO Move to STATIC CONSTANTS
        String idClient = "WEB.SERV.marcin-pogorzelski3@wp.pl";
        String passKey = "8963151D-BB49-43C4-9878-27D1D30F9E1F";

        SoapObject request = new SoapObject();
        request.addProperty("family", mParkingModel.family);
        request.addProperty("id", mParkingModel.id);
        request.addProperty("idSpecified", true);
        request.addProperty("language", "es");
        request.addProperty("publicData", true);
        paramDetailPOI parametersDetailPOI = new paramDetailPOI(request);

        try {
            ip.GetDetailPOIAsync(idClient, passKey, parametersDetailPOI, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        mRootView = inflater.inflate(R.layout.frag_detail, container, false);

        mDescription = (TextView) mRootView.findViewById(R.id.textview_description);
        mContentView = mRootView.findViewById(R.id.fragment_content);
        mWebAddress = (TextView) mRootView.findViewById(R.id.textview_web);
        mPrices = (TextView) mRootView.findViewById(R.id.textview_prices);
        mSchedule = (TextView) mRootView.findViewById(R.id.textview_schedule);
        mContact = (TextView) mRootView.findViewById(R.id.textview_contact);
        mEmail = (TextView) mRootView.findViewById(R.id.textview_email);
        mContentView.setVisibility(View.INVISIBLE);

        mCVdescription = (CardView) mRootView.findViewById(R.id.cardview_description);
        mCVweb = (CardView) mRootView.findViewById(R.id.cardview_web);
        mCVprices = (CardView) mRootView.findViewById(R.id.cardview_prices);
        mCVschedule = (CardView) mRootView.findViewById(R.id.cardview_schedule);
        mCVcontact = (CardView) mRootView.findViewById(R.id.cardview_contact);

        return mRootView;
    }

    @Override
    public void DataManagerStartedRequest() {

    }

    private void loadUI(poiDetail data) {
        //Load data UI
        mDescription.setText(data.poiDetailInfo.description);

        if(mCollapsingToolbarLayout!=null) {
            mCollapsingToolbarLayout.setTitle(data.name);
            mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));
            mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        }

        if (data.poiDetailImages.size() > 2)
            imageLoader.displayImage(data.poiDetailImages.get(1).urlImage, mThumbnail);
        else
            imageLoader.displayImage(data.poiDetailImages.get(0).urlImage, mThumbnail);

        mWebAddress.setText(data.poiDetailInfo.web);


        if (data.poiDetailInfo.servicesPayment != null)
            mPrices.setText(data.poiDetailInfo.servicesPayment);
        else
            mCVprices.setVisibility(View.GONE);



        if (data.poiDetailInfo.schedule != null)
            mSchedule.setText(data.poiDetailInfo.schedule);
        else
            mCVschedule.setVisibility(View.GONE);

        mContact.setText(data.poiDetailGeneral.fax);
        mEmail.setText(data.poiDetailGeneral.email);
    }

    @Override
    public void DataManagerFinished(String methodName, Object Data) {
        responsePoiDetail response = (responsePoiDetail) Data;

        if (response != null) {
            loadUI(response.data.get(0));
        }

        progressBar.setVisibility(View.GONE);
        mContentView.setVisibility(View.VISIBLE);
        mFab.setVisibility(View.VISIBLE);
        mAppBarLayout.expandToolbar(true);

    }

    @Override
    public void DataManagerFinishedWithException(Exception ex) {

    }

    @Override
    public void DataManagerEndedRequest() {

    }
}

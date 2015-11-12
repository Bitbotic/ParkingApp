package com.madrid.parking.android.ui.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.parking.myparking.R;
import com.madrid.parking.android.adapter.DescriptionRecyclerAdapter;
import com.madrid.parking.android.services.DataManagerEvents;
import com.madrid.parking.android.services.infoParking;
import com.madrid.parking.android.services.response.responseIconsDescription;

/**
 * Created by Marcin on 30/09/2015.
 */
public class DescriptionIconsFragment extends DialogFragment implements DataManagerEvents {

    // Main content view
    private View mainView;
    private RecyclerView mRecyclerView;
    private ProgressBar progressBar;
    private Button btnAceptar;
    private DescriptionRecyclerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        mainView = inflater.inflate(R.layout.dialog_description, container, false);

        mRecyclerView = (RecyclerView) mainView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar = (ProgressBar) mainView.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        btnAceptar = (Button) mainView.findViewById(R.id.btn_accept);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        infoParking ip = new infoParking(this);

        try {
            ip.GetDescriptionIconAsync(infoParking.idClient, infoParking.passKey, "es");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mainView;
    }

    @Override
    public void DataManagerStartedRequest() {

    }

    @Override
    public void DataManagerFinished(String methodName, Object Data) {

        responseIconsDescription response = (responseIconsDescription) Data;
        mAdapter = new DescriptionRecyclerAdapter(getActivity(), response.data);
        mRecyclerView.setAdapter(mAdapter);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void DataManagerFinishedWithException(Exception ex) {

    }

    @Override
    public void DataManagerEndedRequest() {

    }
}

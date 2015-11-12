package com.madrid.parking.android.ui.fragment;

import com.madrid.parking.android.adapter.PoiTypeRecyclerAdapter;
import com.madrid.parking.android.services.DataManagerEvents;
import com.madrid.parking.android.model.featureType;
import com.madrid.parking.android.services.infoParking;
import com.madrid.parking.android.services.request.paramListFeatures;
import com.madrid.parking.android.services.response.responseListPoiType;
import com.madrid.parking.android.util.SimpleItemTouchHelperCallback;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import org.ksoap2.serialization.SoapObject;

import com.android.parking.myparking.R;

import java.util.List;

/**
 * Created by Marcin on 22/09/2015.
 */
public class PoiFragment extends BaseFragment implements DataManagerEvents {

    static final String TAG = HomeFragment.class.getSimpleName();
    protected View mRootView;
    private List<featureType> feedsList;
    private RecyclerView mRecyclerView;
    private PoiTypeRecyclerAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(R.layout.parking_list_frag, container, false);

        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressBar = (ProgressBar) mRootView.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        String idClient = "WEB.SERV.marcin-pogorzelski3@wp.pl";
        String passKey = "8963151D-BB49-43C4-9878-27D1D30F9E1F";

        infoParking ip = new infoParking(this);

        SoapObject request = new SoapObject();
        request.addProperty("language", "es");
        request.addProperty("publicData", true);
        paramListFeatures parametersListFeatures = new paramListFeatures(request);

        try {
            //ip.GetListFeaturesAsync(idClient, passKey,parametersListFeatures, null);

            ip.GetListTypesPOIsAsync(idClient, passKey, "es", null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mRootView;
    }

    @Override
    public void DataManagerStartedRequest() {

    }

    @Override
    public void DataManagerFinished(String methodName, Object Data) {

        //responseListFeatures response = (responseListFeatures)Data;
        responseListPoiType response = (responseListPoiType) Data;

        adapter = new PoiTypeRecyclerAdapter(getActivity(), response.data);
        mRecyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback =
                new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper mIth = new ItemTouchHelper(callback);
        mIth.attachToRecyclerView(mRecyclerView);

        /*
        ItemTouchHelper mIth = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        //remove(viewHolder.getAdapterPosition());
                    }

                    public boolean onMove(RecyclerView recyclerview, RecyclerView.ViewHolder v, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                        View itemView = viewHolder.itemView;

                        Drawable d = ContextCompat.getDrawable(MainActivity.this, R.drawable.descarga);
                        d.setBounds(itemView.getLeft(), itemView.getTop(), (int) dX, itemView.getBottom());
                        d.draw(c);

                        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                    }
                });*/


        progressBar.setVisibility(View.GONE);

        Log.i("sdfsd", methodName);
        Log.i("sdfsd", "" + Data);
    }

    @Override
    public void DataManagerFinishedWithException(Exception ex) {

    }

    @Override
    public void DataManagerEndedRequest() {

    }

}

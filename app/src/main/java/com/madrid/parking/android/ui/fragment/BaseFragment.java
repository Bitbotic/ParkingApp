package com.madrid.parking.android.ui.fragment;

import com.madrid.parking.android.ui.activity.BaseActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Marcin on 21/09/2015.
 */
public class BaseFragment extends Fragment {

    private BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // retain this fragment
        //setRetainInstance(true);
    }

    protected void switchContent(Fragment fragment, String addBackStack) {
        getBaseActivity().switchContent(fragment, addBackStack);
    }

    protected void switchContent(Fragment fragment, String addBackStack, int animationOut) {
        getBaseActivity().switchContent(fragment, addBackStack, android.R.anim.fade_in, android.R.anim.fade_out);
    }

}

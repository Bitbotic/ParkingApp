package com.madrid.parking.android.ui.fragment;

import android.os.Bundle;
import com.android.parking.myparking.R;
import com.github.machinarius.preferencefragment.PreferenceFragment;

/**
 * Created by Marcin on 19/10/2015.
 */
public class PrefsFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

}

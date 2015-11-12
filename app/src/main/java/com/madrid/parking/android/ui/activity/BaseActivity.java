package com.madrid.parking.android.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.parking.myparking.R;

/**
 * Created by Marcin on 22/09/2015.
 */
public class BaseActivity extends AppCompatActivity {

    int switchContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Switch given fragment on default content holder and add to back stack.
     *
     * @param fragment     Fragment to be switched up
     * @param addBackStack Back stack tag
     */
    public void switchContent(Fragment fragment, String addBackStack) {
        switchContent(fragment, addBackStack, -1, -1);
    }

    /**
     * Switch given fragment on default content holder and add to back stack.
     * Use given an animationIn and animationOut for fragment transaction
     *
     * @param fragment     Fragment to be switched up
     * @param addBackStack Back stack tag
     * @param animationIn  In animation for transaction
     * @param animationOut Out animation for transaction
     */
    public void switchContent(Fragment fragment, String addBackStack, int animationIn, int animationOut) {
        try {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            if (animationIn > 0 && animationOut > 0)
                fragmentTransaction.setCustomAnimations(animationIn, animationOut);

            if (addBackStack != null)
                fragmentTransaction.addToBackStack(addBackStack);
            fragmentTransaction.replace(this.switchContent, fragment);
            fragmentTransaction.commit();
        } catch (Exception e) {
            //ExceptionLogger.logException(e);
        }
    }

    /**
     * Check network connectivity avabible.
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        }else {
            super.onBackPressed();
        }
    }

}

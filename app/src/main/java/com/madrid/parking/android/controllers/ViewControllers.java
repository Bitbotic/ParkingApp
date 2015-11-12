package com.madrid.parking.android.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.madrid.parking.android.model.Parking;
import com.madrid.parking.android.ui.activity.DetailActivity;
import com.madrid.parking.android.ui.activity.MapActivity;

/**
 * Created by Marcin on 23/10/2015.
 */
public class ViewControllers {

    public static void goToMapActivity(Context context) {
        Intent intent = new Intent(context, MapActivity.class);
        context.startActivity(intent);
    }

    public static void goToDetailActivity(Context context,Parking parking) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("modelParking", parking);
        context.startActivity(intent);
    }

}

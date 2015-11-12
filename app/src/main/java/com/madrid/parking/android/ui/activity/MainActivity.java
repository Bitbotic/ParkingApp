package com.madrid.parking.android.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.parking.myparking.R;
import com.madrid.parking.android.ui.fragment.HomeFragment;


public class MainActivity extends BaseActivity {

    private View mRootView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchContent = R.id.content_frame;
        mRootView = findViewById(switchContent);
        configureActionBar();


        Fragment fragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (savedInstanceState == null) {
            final HomeFragment homeFragment = new HomeFragment();
            switchContent(homeFragment, "Home");
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Toast.makeText(this,"Not Implemented", Toast.LENGTH_SHORT).show();
            return true;
        }

        /*
        if (id == R.id.action_map) {
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        }*/

        return super.onOptionsItemSelected(item);
    }

    private void configureActionBar() {

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT);

        //View actionBarView = getLayoutInflater().inflate(R.layout.action_bar, null);
        //actionBar.setCustomView(actionBarView, params); //View actionBarView = getLayoutInflater().inflate(R.layout.action_bar, null);
        //actionBar.setCustomView(actionBarView, params);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.title_actionbar);

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setHomeButtonEnabled(false);
    }

    public void hideActionBar() {
        actionBar.hide();
    }

}

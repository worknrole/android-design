package com.worknrole.design.ui.qplanningapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.worknrole.design.R;
import com.worknrole.design.ui.qplanningapp.view.QplanningappLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QPlanningAppActivity extends AppCompatActivity {

    //region Properties
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.edition)
    FloatingActionButton mActionButton;

    @BindView(R.id.view_pager)
    QplanningappLayout mLayout;

    private ActionBarDrawerToggle mDrawerToggle;
    //endregion


    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qplanningapp_layout);
        ButterKnife.bind(this);
        initialize();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return mDrawerToggle.onOptionsItemSelected(menuItem) || super.onOptionsItemSelected(menuItem);
    }
    //endregion


    //region Initializer
    private void initialize() {
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawerOpen, R.string.drawerClose);
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mLayout.setEditionBtn(mActionButton);
    }
    //endregion
}

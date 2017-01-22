package com.worknrole.design.ui.userprofileconcept;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.worknrole.design.R;
import com.worknrole.design.ui.userprofileconcept.item.MovieItem;
import com.worknrole.design.ui.userprofileconcept.view.UPCContentView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by worknrole on 21/01/17.
 *
 * The User Profile Concept Activity
 */
public class UPCActivity extends AppCompatActivity {

    //region Properties
    private FloatingActionButton    mFloatingActionBtn;
    private UPCContentView          mContentView;
    private DrawerLayout            mDrawerLayout;
    private ActionBarDrawerToggle   mDrawerToggle;
    //endregion


    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upc_activity);
        initializeView();
        displayMovies();
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
        if (mDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
    //endregion


    //region Custom methods
    /**
     * Initialize all needed views
     */
    private void initializeView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mFloatingActionBtn = (FloatingActionButton) findViewById(R.id.fab);
        mContentView = (UPCContentView) findViewById(R.id.upc_contentView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mFloatingActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Just a FloatingButton test", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Add some movies to the RecyclerView
     */
    private void displayMovies() {
        List<MovieItem> items = new ArrayList<MovieItem>();
        items.add(new MovieItem(R.drawable.upc_lesmiserables));
        items.add(new MovieItem(R.drawable.upc_logan));
        items.add(new MovieItem(R.drawable.upc_prisoners));
        items.add(new MovieItem(R.drawable.upc_realsteel));
        items.add(new MovieItem(R.drawable.upc_vanhelsing));
        items.add(new MovieItem(R.drawable.upc_xmen));
        mContentView.addMovies(items);
    }
    //endregion
}

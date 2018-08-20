package com.twospeak.twospeak;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class NavDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        MainActivity2 addNewShop = new MainActivity2();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_nav_drawer, addNewShop);
        fragmentTransaction.commit();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        findViewById(R.id.drawer_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open right drawer

                if (drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.closeDrawer(GravityCompat.END);
                }
                else
                    drawer.openDrawer(GravityCompat.END);
            }
        });



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
        drawer.addDrawerListener(toggle);

        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        TextView profile = (TextView) header.findViewById(R.id.profile);
        TextView findateacher = (TextView) header.findViewById(R.id.findateacher);



        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Profile is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        findateacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Find A Teacher is clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
            Toast.makeText(getApplicationContext(), "Camera is clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_gallery) {
            Toast.makeText(getApplicationContext(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(getApplicationContext(), "Slideshow is clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_manage) {
            Toast.makeText(getApplicationContext(), "Tools is clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {
            Toast.makeText(getApplicationContext(), "Share is clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(getApplicationContext(), "Send is clicked", Toast.LENGTH_SHORT).show();

        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
}
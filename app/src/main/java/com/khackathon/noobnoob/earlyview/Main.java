package com.khackathon.noobnoob.earlyview;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import layout.test2Fragment;
import layout.testFragment;


/*
생성자:길경완
생성일자:2017_07_24
수정자:x
수정일자:x
메인이ㅏㄷ.ㅁㄴㅇ

ㅁㄴㅇ

 */
public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {





    private void onstartFragementSet()
    {
        String title="EarlyView_test1";
        Fragment fragment = null;
        fragment = new testFragment();
        if(fragment!=null){
            FragmentTransaction ft  = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.content_fragement_layout,  fragment);

            ft.commit();
        }

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(title);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        onstartFragementSet();
        Button button = (Button)findViewById(R.id.changeButton);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Fragment fragment = null;
                String title;


                if(getSupportActionBar().getTitle().equals("EarlyView_test1"))
                {
                    //현재는 예시로 두개만이니 이런식이지만 실제로는 이것과 다르게 버튼을 증가할것임.
                    fragment = new test2Fragment();
                    title="EarlyView_test2";
                }else
                {
                    fragment = new testFragment();
                    title="EarlyView_test1";
                }

                //프래그먼트 바꾸기.
                FragmentTransaction ft  = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_fragement_layout,  fragment);
                ft.commit();
                //title 바꾸기.
                if(getSupportActionBar()!=null){
                    getSupportActionBar().setTitle(title);
                }


            }

        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

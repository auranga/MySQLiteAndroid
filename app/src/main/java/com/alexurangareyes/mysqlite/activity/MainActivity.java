package com.alexurangareyes.mysqlite.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.alexurangareyes.mysqlite.R;
import com.alexurangareyes.mysqlite.fragment.FavoritesFragment;
import com.alexurangareyes.mysqlite.fragment.HomeFragment;
import com.alexurangareyes.mysqlite.fragment.PlacesFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity {

    private Fragment selectedFragment;
    private  BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("My Favourite places");*/



        /*manager.addPlace("El nombre 1","El estado","El Mun",0,"121212.1212","12212");*/

        //manager.deletePlace("El nombre 2");
        //manager.modifyPlaceFav("El nombre 3","Nuevo estado","El Mun",1,"121212.1212","12212");

        //Log.i("myTag", "manager.getProfilesCount() = " + String.valueOf(manager.getProfilesCount()));


        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                selectedFragment = null;

                switch (tabId) {
                    case R.id.navigation_home:
                        selectedFragment = HomeFragment.newInstance();
                        break;
                    case R.id.navigation_places:
                        selectedFragment = PlacesFragment.newInstance();
                        break;
                    case R.id.navigation_favorite:
                        selectedFragment = FavoritesFragment.newInstance();
                        break;
                    /*case R.id.navigation_map:
                        selectedFragment = MapFragment.newInstance();
                        break;*/
                    default:
                        selectedFragment = HomeFragment.newInstance();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contentContainer, selectedFragment);
                transaction.commit();

            }
        });




        /*final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setScaleX(0);
        fab.setScaleY(0);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final Interpolator interpolador = AnimationUtils.loadInterpolator(getBaseContext(),
                    android.R.interpolator.fast_out_slow_in);

            fab.animate()
                    .scaleX(1)
                    .scaleY(1)
                    .setInterpolator(interpolador)
                    .setDuration(600)
                    .setStartDelay(1000);


        }*/

        /* fab.animate()
                                    .scaleY(0)
                                    .scaleX(0)
                                    .setInterpolator(interpolador)
                                    .setDuration(600)
                                    .start();*/


    }

}
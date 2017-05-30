package com.alexurangareyes.mysqlite;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity {

    private Fragment selectedFragment;
    private  BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*TabLayout.Tab tabCall = tableLayout.getTabAt(0);
        tabCall.setIcon(R.drawable.selector_home);*/

        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                /*for (int i = 0; i < bottomBar.getTabCount(); i++) {
                    BottomBarTab tab = bottomBar.getTabAtPosition(0);
                    tab.findViewById(com.roughike.bottombar.R.id.bb_bottom_bar_icon).setSelected(tab.getId() == tabId);
                }*/

                selectedFragment = null;

                switch (tabId) {
                    case R.id.navigation_home:
                        selectedFragment = HomeFragment.newInstance();
                        break;
                    case R.id.navigation_favorite:
                        selectedFragment = FavoritesFragment.newInstance();
                        break;
                    case R.id.navigation_map:
                        selectedFragment = MapFragment.newInstance();
                        break;
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
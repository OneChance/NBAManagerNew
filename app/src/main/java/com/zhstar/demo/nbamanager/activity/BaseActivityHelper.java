package com.zhstar.demo.nbamanager.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.services.TeamInfoObserver;
import com.zhstar.demo.nbamanager.util.GameNetUtil;
import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenu;
import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenuDrawable;
import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenuDrawable.IconState;

public class BaseActivityHelper {

    private MaterialMenu materialIcon;
    private DrawerLayout drawerLayout;
    private boolean direction;
    private View drawer;
    private TeamInfoObserver teamInfoObserver;
    private boolean loaded = false;

    public void init(View parent, MaterialMenu actionBarIcon, final Context context) {

        materialIcon = actionBarIcon;
        drawer = parent.findViewById(R.id.nav_view);


        NavigationView navigationView = (NavigationView) parent.findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.info_team_name:
                        Toast.makeText(context, "team name", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.info_money:
                        Toast.makeText(context, "money", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.info_fans:
                        Toast.makeText(context, "fans", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return true;
                }
            }
        });

        teamInfoObserver = new TeamInfoObserver(context, parent, navigationView);


        drawerLayout = ((DrawerLayout) parent.findViewById(R.id.drawer_layout));
        drawerLayout.setScrimColor(Color.parseColor("#66000000"));
        drawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                materialIcon.setTransformationOffset(
                        MaterialMenuDrawable.AnimationState.BURGER_ARROW,
                        direction ? 2 - slideOffset : slideOffset
                );
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);

                if (!loaded && newState != DrawerLayout.STATE_IDLE) {
                    loaded = true;
                    GameNetUtil.SetObserverCommonAction(GameNetUtil.getGameServices().getTeamInfo())
                            .subscribe(teamInfoObserver);
                } else {

                }
            }

            @Override
            public void onDrawerOpened(android.view.View drawerView) {
                direction = true;
            }

            @Override
            public void onDrawerClosed(android.view.View drawerView) {
                direction = false;
                loaded = false;
            }

        });
    }

    public void menuToggle() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(drawer);
        } else {
            drawerLayout.openDrawer(drawer);
        }
    }


    public void refreshDrawerState() {
        this.direction = drawerLayout.isDrawerOpen(GravityCompat.START);
    }


    public static IconState intToState(int state) {
        switch (state) {
            case 0:
                return IconState.BURGER;
            case 1:
                return IconState.ARROW;
        }
        throw new IllegalArgumentException("error state!");
    }


}

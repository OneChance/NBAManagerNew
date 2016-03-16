package com.zhstar.demo.nbamanager.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.Entity.TeamInfoItem;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.adapter.TeamInfoItemAdapter;
import com.zhstar.demo.nbamanager.services.TeamInfoObserver;
import com.zhstar.demo.nbamanager.util.GameNetUtil;
import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenu;
import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenuDrawable;
import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenuDrawable.IconState;

import java.util.ArrayList;
import java.util.List;

public class BaseActivityHelper{

    private MaterialMenu materialIcon;
    private DrawerLayout drawerLayout;
    private boolean direction;
    private View drawer;
    private TeamInfoObserver teamInfoObserver;
    private boolean loaded = false;
    private TeamInfoItemAdapter teamInfoItemAdapter;
    private List<TeamInfoItem> infoItems;
    private RecyclerView infoItemList;

    public void init(View parent, MaterialMenu actionBarIcon, final Context context) {

        materialIcon = actionBarIcon;
        drawer = parent.findViewById(R.id.drawer);

        //抽屉菜单项列表
        infoItemList = (RecyclerView) parent.findViewById(R.id.info_list);
        infoItemList.setLayoutManager(new LinearLayoutManager(context));
        infoItems = new ArrayList<TeamInfoItem>();
        teamInfoItemAdapter = new TeamInfoItemAdapter(context, infoItems);

        teamInfoItemAdapter.setOnItemClickLitener(new TeamInfoItemAdapter.OnItemClickLitener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(context, position + " long click",
                        Toast.LENGTH_SHORT).show();
            }
        });

        infoItemList.setAdapter(teamInfoItemAdapter);
        teamInfoObserver = new TeamInfoObserver(context,parent,teamInfoItemAdapter,infoItems);
        //end

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

                if(!loaded && newState!=DrawerLayout.STATE_IDLE){
                    loaded = true;
                    GameNetUtil.SetObserverCommonAction(GameNetUtil.getGameServices().getTeamInfo())
                            .subscribe(teamInfoObserver);
                }else{

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

    public void menuToggle(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(drawer);
        }else{
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

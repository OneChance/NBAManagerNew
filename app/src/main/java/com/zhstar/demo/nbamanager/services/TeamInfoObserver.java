package com.zhstar.demo.nbamanager.services;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.Entity.Team;
import com.zhstar.demo.nbamanager.Entity.TeamData;
import com.zhstar.demo.nbamanager.R;

import rx.Observer;


public class TeamInfoObserver implements Observer<TeamData> {

    public Context context;
    public ImageView arenaImage;
    public NavigationView navigationView;
    public Menu menu;

    public TeamInfoObserver(Context context, View view,NavigationView navigationView) {
        this.context = context;
        arenaImage = (ImageView)navigationView.inflateHeaderView(R.layout.drawer_header).findViewById(R.id.d_header);;
        this.navigationView = navigationView;
        menu = navigationView.getMenu();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Toast.makeText(context, R.string.get_teaminfo_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(TeamData data) {

        String msg = data.getMessage();

        if (msg.equals("")) {
            Team team = data.getData();

            Resources res = context.getResources();

            int resId = res.getIdentifier("arena_" + team.getArena().getEq_level(), "drawable", "com.zhstar.demo.nbamanager");

            arenaImage.setImageResource(resId);

            menu.getItem(0).setTitle(team.getTeam_name());
            menu.getItem(1).setTitle(team.getTeam_money().toString());
            menu.getItem(2).setTitle(team.getEv().toString());

        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}

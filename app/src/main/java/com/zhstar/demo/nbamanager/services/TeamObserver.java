package com.zhstar.demo.nbamanager.services;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ListView;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.Entity.Player;
import com.zhstar.demo.nbamanager.Entity.Team;
import com.zhstar.demo.nbamanager.Entity.TeamData;
import com.zhstar.demo.nbamanager.adapter.TeamPlayerAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;


public class TeamObserver implements Observer<TeamData> {

    private TeamPlayerAdapter teamPlayerAdapter;
    private List<Player> players;
    private ListView listView;

    public Context context;


    public TeamObserver(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Toast.makeText(context, "获取球队信息异常", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(TeamData teamData) {

        String msg = teamData.getMessage();

        if (msg.equals("")) {
            Team team = teamData.getData();
            setData(team);
            teamPlayerAdapter = new TeamPlayerAdapter(context, players);
            listView.setAdapter(teamPlayerAdapter);

        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(Team team) {

        if (players == null) {
            players = new ArrayList<Player>();
        }

        players.clear();

        if (team != null) {
            List<Player> playerList = team.getPlayerList();

            if (playerList != null) {
                for (Player player : playerList) {

                    Resources res = context.getResources();
                    int resId = res.getIdentifier("player_" + player.getPlayer_id(), "drawable", "com.zhstar.demo.nbamanager");
                    player.setHead_img(resId);

                    players.add(player);
                }
            }
        }
    }
}

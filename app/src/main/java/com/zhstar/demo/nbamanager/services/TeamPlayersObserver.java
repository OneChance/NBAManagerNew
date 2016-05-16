package com.zhstar.demo.nbamanager.services;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.entity.Player;
import com.zhstar.demo.nbamanager.entity.PlayerData;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.adapter.TeamPlayerAdapter;

import java.util.List;

import rx.Observer;


public class TeamPlayersObserver implements Observer<PlayerData> {

    private TeamPlayerAdapter adapter;
    public Context context;
    private List<Player> players;
    private SwipeRefreshLayout refreshComponent;


    public TeamPlayersObserver(Context context, List<Player> players, TeamPlayerAdapter adapter, SwipeRefreshLayout refreshComponent) {
        this.context = context;
        this.players = players;
        this.adapter = adapter;
        this.refreshComponent = refreshComponent;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Toast.makeText(context, R.string.get_teamplayers_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(PlayerData playerData) {

        String msg = playerData.getMessage();

        if (msg.equals("")) {
            List<Player> playerList = playerData.getData();
            setData(playerList);
        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(List<Player> playerList) {

        if (playerList != null) {

            players.clear();

            Resources res = context.getResources();

            for (Player player : playerList) {

                int resId = res.getIdentifier("player_" + player.getPlayer_id(), "drawable", "com.zhstar.demo.nbamanager");
                player.setHead_img(resId);

                players.add(player);
            }

            adapter.notifyDataSetChanged();

            if (refreshComponent != null) {
                refreshComponent.setRefreshing(false);
            }
        }

    }
}

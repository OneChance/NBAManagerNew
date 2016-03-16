package com.zhstar.demo.nbamanager.services;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.Entity.Player;
import com.zhstar.demo.nbamanager.Entity.PlayerData;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.adapter.TeamPlayerAdapter;

import java.util.List;

import rx.Observer;


public class TeamPlayersObserver implements Observer<PlayerData> {

    private TeamPlayerAdapter adapter;
    public Context context;
    private List<Player> players;


    public TeamPlayersObserver(Context context, List<Player> players, TeamPlayerAdapter adapter) {
        this.context = context;
        this.players = players;
        this.adapter = adapter;
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

            for (Player player : playerList) {

                Resources res = context.getResources();
                int resId = res.getIdentifier("player_" + player.getPlayer_id(), "drawable", "com.zhstar.demo.nbamanager");
                player.setHead_img(resId);

                players.add(player);
            }

            adapter.notifyDataSetChanged();
        }

    }
}

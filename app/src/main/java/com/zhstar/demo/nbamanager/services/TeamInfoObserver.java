package com.zhstar.demo.nbamanager.services;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.Entity.Team;
import com.zhstar.demo.nbamanager.Entity.TeamData;
import com.zhstar.demo.nbamanager.Entity.TeamInfoItem;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.adapter.TeamInfoItemAdapter;

import java.util.List;

import rx.Observer;


public class TeamInfoObserver implements Observer<TeamData> {

    public Context context;
    public TextView nameT;
    private TeamInfoItemAdapter teamInfoItemAdapter;
    private List<TeamInfoItem> infoItems;

    public TeamInfoObserver(Context context, View view, TeamInfoItemAdapter teamInfoItemAdapter, List<TeamInfoItem> infoItems) {
        this.context = context;
        nameT = (TextView) view.findViewById(R.id.team_name);
        this.teamInfoItemAdapter = teamInfoItemAdapter;
        this.infoItems = infoItems;
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

            nameT.setText(team.getTeam_name());

            infoItems.clear();

            infoItems.add(new TeamInfoItem(R.string.money, team.getTeam_money().toString()));
            infoItems.add(new TeamInfoItem(R.string.evalue, team.getEv().toString()));

            teamInfoItemAdapter.notifyDataSetChanged();

        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}

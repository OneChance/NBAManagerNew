package com.zhstar.demo.nbamanager.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.entity.Player;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.adapter.TeamPlayerAdapter;
import com.zhstar.demo.nbamanager.services.TeamPlayersObserver;
import com.zhstar.demo.nbamanager.util.GameNetUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class PlayersFragment extends Fragment {

    @InjectView(R.id.play_list)
    RecyclerView listView;
    @InjectView(R.id.refreshComponent)
    SwipeRefreshLayout refreshComponent;

    private List<Player> players;
    private TeamPlayerAdapter adapter;
    private TeamPlayersObserver teamPlayersObserver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.team_players, container, false);
        ButterKnife.inject(this, view);

        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        players = new ArrayList<Player>();
        adapter = new TeamPlayerAdapter(getActivity(), players);

        adapter.setOnItemClickLitener(new TeamPlayerAdapter.OnItemClickLitener() {

            @Override
            public void onItemClick(View view, Long playerId) {
                Toast.makeText(getActivity(), playerId + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, Long playerId) {
                Toast.makeText(getActivity(), playerId + " long click",
                        Toast.LENGTH_SHORT).show();
            }
        });


        listView.setAdapter(adapter);

        refreshComponent.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 执行刷新操作
                GetTeam();
            }
        });

        refreshComponent.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);

        teamPlayersObserver = new TeamPlayersObserver(getActivity(), players, adapter, refreshComponent);

        GetTeam();

        return view;
    }


    @Override
    public void onHiddenChanged(boolean hidden) {

        if (!hidden) {
            GetTeam();
        }

        super.onHiddenChanged(hidden);
    }

    public void GetTeam() {
        GameNetUtil.SetObserverCommonAction(GameNetUtil.getGameServices().getTeamPlayers())
                .subscribe(teamPlayersObserver);
    }
}

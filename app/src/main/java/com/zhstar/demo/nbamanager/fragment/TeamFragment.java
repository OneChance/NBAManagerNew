package com.zhstar.demo.nbamanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhstar.demo.nbamanager.Entity.Player;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.adapter.TeamPlayerAdapter;
import com.zhstar.demo.nbamanager.services.TeamObserver;
import com.zhstar.demo.nbamanager.util.GameNetUtil;

import java.util.ArrayList;
import java.util.List;


public class TeamFragment extends Fragment {

    private RecyclerView listView;
    private List<Player> players;
    private TeamPlayerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.team, container, false);

        listView = (RecyclerView) view.findViewById(R.id.play_list);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        players = new ArrayList<Player>();
        adapter = new TeamPlayerAdapter(getActivity(), players);
        listView.setAdapter(adapter);

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

        GameNetUtil.SetObserverCommonAction(GameNetUtil.getGameServices().getTeam())
                .subscribe(new TeamObserver(getActivity(), players, adapter));

    }
}

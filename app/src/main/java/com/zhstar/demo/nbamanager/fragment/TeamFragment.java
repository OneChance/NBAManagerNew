package com.zhstar.demo.nbamanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.services.TeamObserver;
import com.zhstar.demo.nbamanager.util.GameNetUtil;

/**
 * Created by ceeg on 2015/3/23.
 */
public class TeamFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.team_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.player_list);
        listView.setOnItemClickListener(this);

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String player_id = ((TextView) view.findViewById(R.id.player_id)).getText().toString();
        Toast.makeText(getActivity(), player_id, Toast.LENGTH_SHORT).show();
    }

    public void GetTeam() {

        GameNetUtil.SetObserverCommonAction(GameNetUtil.getGameServices().getTeam())
                .subscribe(new TeamObserver(getActivity(), listView));

    }
}

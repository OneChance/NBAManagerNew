package com.zhstar.demo.nbamanager.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.zhstar.demo.nbamanager.Entity.MenuItem;
import com.zhstar.demo.nbamanager.Entity.User;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.fragment.MarketFragment;
import com.zhstar.demo.nbamanager.fragment.TeamFragment;

import java.util.List;


public class MainActivity extends Activity{

    private MenuAdapter menuAdapter;
    private List<MenuItem> menuItems;
    private ListView listView;
    private static FragmentManager fragmentManager;
    private static TeamFragment teamfragment;
    private static MarketFragment marketfragment;
    private static Context context;
    private User user;
    private TextView username;

    private void changeFragment(String tag) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        if (tag.equals("team") && teamfragment.isHidden()) {
            ft.hide(marketfragment);
            ft.show(teamfragment);
        } else if (tag.equals("market") && marketfragment.isHidden()) {
            ft.hide(teamfragment);
            ft.show(marketfragment);
        }

        ft.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mainpage);

        context = this;
        listView = (ListView) findViewById(R.id.listView);
        fragmentManager = getFragmentManager();
        teamfragment = new TeamFragment();
        marketfragment = new MarketFragment();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment_frame, teamfragment);
        ft.add(R.id.fragment_frame, marketfragment);
        ft.hide(marketfragment);
        ft.commit();

    }
}

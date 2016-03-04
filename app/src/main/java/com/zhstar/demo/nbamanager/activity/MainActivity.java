package com.zhstar.demo.nbamanager.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.zhstar.demo.nbamanager.Entity.MenuItem;
import com.zhstar.demo.nbamanager.Entity.Team;
import com.zhstar.demo.nbamanager.Entity.User;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.adapter.MenuAdapter;
import com.zhstar.demo.nbamanager.fragment.MarketFragment;
import com.zhstar.demo.nbamanager.fragment.TeamFragment;
import com.zhstar.demo.nbamanager.view.SlidingMenu;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private MenuAdapter menuAdapter;
    private List<MenuItem> menuItems;

    private ListView listView;
    private SlidingMenu slidingMenu;
    private RadioGroup radioGroup;
    private static FragmentManager fragmentManager;
    private static TeamFragment teamfragment;
    private static MarketFragment marketfragment;
    private static Context context;
    private User user;

    private TextView username;

    public void initFragment(String tag) {
        changeFragment(tag);
    }

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
        slidingMenu = (SlidingMenu) findViewById(R.id.menu);
        radioGroup = (RadioGroup) findViewById(R.id.r_group);
        radioGroup.setOnCheckedChangeListener(this);

        fragmentManager = getFragmentManager();
        teamfragment = new TeamFragment();
        marketfragment = new MarketFragment();

        //set user team data
        username = (TextView) findViewById(R.id.username);
        Intent intent = this.getIntent();
        user = (User) intent.getSerializableExtra("user");
        username.setText(user.getUser_name());

        //menu list
        setMenuItems(user.getTeam());
        menuAdapter = new MenuAdapter(context,menuItems,R.layout.menu_list);
        listView.setAdapter(menuAdapter);

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment_frame, teamfragment);
        ft.add(R.id.fragment_frame, marketfragment);
        ft.hide(marketfragment);
        ft.commit();

    }

    private void setMenuItems(Team team) {

        if (menuItems == null) {
            menuItems = new ArrayList<MenuItem>();
        }

        menuItems.clear();

        if (team != null) {
            MenuItem moneyMenu = new MenuItem();
            moneyMenu.setMenuImage(R.drawable.money);
            moneyMenu.setMenuText(team.getTeam_money() + "");
            menuItems.add(moneyMenu);

            MenuItem fansMenu = new MenuItem();
            fansMenu.setMenuImage(R.drawable.fans);
            fansMenu.setMenuText(team.getEv() + "");
            menuItems.add(fansMenu);
        }
    }

    public void toggle(View view) {
        slidingMenu.toggleMenu();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        switch (checkedId) {
            case R.id.r1:
                changeFragment("team");
                break;
            case R.id.r2:
                changeFragment("market");
                break;
        }
    }
}

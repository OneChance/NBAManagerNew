package com.zhstar.demo.nbamanager.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.fragment.MarketFragment;
import com.zhstar.demo.nbamanager.fragment.PlayersFragment;
import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenuDrawable.Stroke;
import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenuIconToolbar;


public class MainActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;
    private static PlayersFragment playersFragment;
    private static MarketFragment marketFragment;
    private static Context context;
    private Toolbar toolbar;
    private MaterialMenuIconToolbar materialMenu;
    protected BaseActivityHelper helper;

    private void changeFragment(String tag) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        if (tag.equals("t") && playersFragment.isHidden()) {
            ft.hide(marketFragment);
            ft.show(playersFragment);
        } else if (tag.equals("market") && marketFragment.isHidden()) {
            ft.hide(playersFragment);
            ft.show(marketFragment);
        }

        ft.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        context = this;
        fragmentManager = getFragmentManager();
        playersFragment = new PlayersFragment();
        marketFragment = new MarketFragment();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment_frame, playersFragment);
        ft.add(R.id.fragment_frame, marketFragment);
        ft.hide(marketFragment);
        ft.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        helper = new BaseActivityHelper();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.menuToggle();
            }
        });
        materialMenu = new MaterialMenuIconToolbar(this, Color.WHITE, Stroke.THIN) {
            @Override public int getToolbarViewId() {
                return R.id.toolbar;
            }
        };

        helper.init(getWindow().getDecorView(), materialMenu,context);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        helper.refreshDrawerState();
        materialMenu.syncState(savedInstanceState);
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        materialMenu.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }
}

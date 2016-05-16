package com.zhstar.demo.nbamanager.services;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.entity.Team;
import com.zhstar.demo.nbamanager.entity.TeamData;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.view.dialog.MaterialDialog;
import com.zhstar.demo.nbamanager.view.button.ButtonRectangle;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.Observer;


public class TeamInfoObserver implements Observer<TeamData> {

    public Context context;
    public ImageView arenaImage;
    public NavigationView navigationView;
    public Menu menu;
    MaterialDialog materialDialog;
    final View arenaInfoView;

    @InjectView(R.id.arena_name)
    TextView arenaName;
    @InjectView(R.id.arena_capacity)
    TextView arenaCapacity;
    @InjectView(R.id.ticket_price)
    TextView arenaTicketPrice;
    @InjectView(R.id.arena_attendance)
    TextView arenaAttendance;
    @InjectView(R.id.arena_today_in)
    TextView arenaTodayIn;
    @InjectView(R.id.arena_close)
    ButtonRectangle arenaClose;

    public TeamInfoObserver(final Context context, View view, NavigationView navigationView) {
        this.context = context;

        materialDialog = new MaterialDialog(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        arenaInfoView = inflater.inflate(R.layout.arena_info, null);

        ButterKnife.inject(this, arenaInfoView);

        arenaImage = (ImageView) navigationView.inflateHeaderView(R.layout.drawer_header).findViewById(R.id.d_header);

        arenaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDialog.setView(arenaInfoView).show();
            }
        });

        arenaClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               materialDialog.dismiss(view);
            }
        });

        this.navigationView = navigationView;
        menu = navigationView.getMenu();
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

            Resources res = context.getResources();

            int resId = res.getIdentifier("arena_" + team.getArena().getEq_level(), "drawable", "com.zhstar.demo.nbamanager");

            arenaImage.setImageResource(resId);

            menu.getItem(0).setTitle(team.getTeam_name());
            menu.getItem(1).setTitle(team.getTeam_money().toString());
            menu.getItem(2).setTitle(team.getEv().toString());

            arenaName.setText(team.getArena().getArena_name());
            arenaCapacity.setText(team.getArena().getCap().toString());
            arenaTicketPrice.setText(team.getArena().getTicket_price().toString());
            arenaAttendance.setText(team.getArena().getAttendance().toString());
            arenaTodayIn.setText(team.getArena().getToday_in().toString());

        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}

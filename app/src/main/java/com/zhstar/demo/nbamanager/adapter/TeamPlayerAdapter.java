package com.zhstar.demo.nbamanager.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.Entity.MenuItem;
import com.zhstar.demo.nbamanager.Entity.Player;
import com.zhstar.demo.nbamanager.R;

import java.util.List;

/**
 * Created by ceeg on 2015/5/19.
 */
public class TeamPlayerAdapter extends CommonAdapter<Player> {

    private Context context;

    public TeamPlayerAdapter(Context context, List datas) {
        super(context, datas, R.layout.player_list);
        this.context = context;
    }

    @Override
    public void convert(ViewHolder holder, final Player player) {

        holder.setImgRes(R.id.player_head, player.getHead_img());
        holder.setText(R.id.player_name, player.getPlayer_name());
        holder.setText(R.id.player_pos, player.getPos());
        holder.setText(R.id.market_sal, player.getSal() + "");
        holder.setText(R.id.sign_sal, player.getSign_sal() + "");
        holder.setText(R.id.fg, player.getShoot());
        holder.setText(R.id.ft, player.getFree_throw());
        holder.setText(R.id.reb, player.getRebound());
        holder.setText(R.id.ast, player.getAssist());
        holder.setText(R.id.stl, player.getSteal());
        holder.setText(R.id.blk, player.getBlock());
        holder.setText(R.id.tur, player.getFault());
        holder.setText(R.id.pf, player.getFoul());
        holder.setText(R.id.pts, player.getPoint());
        holder.setText(R.id.ev, player.getEv() + "");
        holder.setText(R.id.player_id,player.getPlayer_id()+"");

        Button unsignButton = holder.getView(R.id.unsign);
        unsignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,player.getPlayer_id()+"",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

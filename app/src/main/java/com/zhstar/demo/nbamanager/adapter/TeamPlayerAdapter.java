package com.zhstar.demo.nbamanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhstar.demo.nbamanager.Entity.Player;
import com.zhstar.demo.nbamanager.R;

import java.util.List;

public class TeamPlayerAdapter extends RecyclerView.Adapter<TeamPlayerAdapter.ViewHolder> {

    private Context context;
    private List<Player> players;

    public TeamPlayerAdapter(Context context, List<Player> players) {
        this.players = players;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_card, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Player p = players.get(position);

        /*

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
                    Toast.makeText(context, player.getPlayer_id() + "", Toast.LENGTH_SHORT).show();
                }
            });*/
    }

    @Override
    public int getItemCount() {
        return players == null ? 0 : players.size();
    }


    public static class ViewHolder
            extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);


        }
    }

}

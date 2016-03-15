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

        holder.headI.setImageResource(p.getHead_img());
        holder.nameT.setText(p.getPlayer_name());
        holder.posT.setText(p.getPos());
        holder.marketSalT.setText(p.getSal()+"");
        holder.signSalT.setText(p.getSign_sal()+"");
        holder.shootT.setText(p.getShoot());
        holder.ftT.setText(p.getFree_throw());
        holder.rebT.setText(p.getRebound());
        holder.astT.setText(p.getAssist());
        holder.stlT.setText(p.getSteal());
        holder.blkT.setText(p.getBlock());
        holder.turT.setText(p.getFault());
        holder.pfT.setText(p.getFault());
        holder.ptsT.setText(p.getPoint());
        holder.evT.setText(p.getEv()+"");
        holder.idT.setText(p.getPlayer_id().toString());

    }

    @Override
    public int getItemCount() {
        return players == null ? 0 : players.size();
    }


    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        public ImageView headI;
        public TextView nameT;
        public TextView posT;
        public TextView marketSalT;
        public TextView signSalT;
        public TextView shootT;
        public TextView ftT;
        public TextView rebT;
        public TextView astT;
        public TextView stlT;
        public TextView blkT;
        public TextView turT;
        public TextView pfT;
        public TextView ptsT;
        public TextView evT;
        public TextView idT;

        public ViewHolder(View v) {
            super(v);

            headI = (ImageView)v.findViewById(R.id.player_head);
            nameT = (TextView) v.findViewById(R.id.player_name);
            posT = (TextView) v.findViewById(R.id.player_pos);
            marketSalT = (TextView) v.findViewById(R.id.market_sal);
            signSalT = (TextView) v.findViewById(R.id.sign_sal);
            shootT = (TextView) v.findViewById(R.id.fg);
            ftT = (TextView) v.findViewById(R.id.ft);
            rebT = (TextView) v.findViewById(R.id.reb);
            astT = (TextView) v.findViewById(R.id.ast);
            stlT = (TextView) v.findViewById(R.id.stl);
            blkT = (TextView) v.findViewById(R.id.blk);
            turT = (TextView) v.findViewById(R.id.tur);
            pfT = (TextView) v.findViewById(R.id.pf);
            ptsT = (TextView) v.findViewById(R.id.pts);
            evT = (TextView) v.findViewById(R.id.ev);
            idT = (TextView) v.findViewById(R.id.player_id);

        }
    }

}

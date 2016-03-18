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

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TeamPlayerAdapter extends RecyclerView.Adapter<TeamPlayerAdapter.ViewHolder> {

    private Context context;
    private List<Player> players;

    public interface OnItemClickLitener {
        void onItemClick(View view, Long playerId);
        void onItemLongClick(View view, Long playerId);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Player p = players.get(position);

        holder.headI.setImageResource(p.getHead_img());
        holder.nameT.setText(p.getPlayer_name());
        holder.posT.setText(p.getPos());
        holder.marketSalT.setText(p.getSal() + "");
        holder.signSalT.setText(p.getSign_sal() + "");
        holder.shootT.setText(p.getShoot());
        holder.ftT.setText(p.getFree_throw());
        holder.rebT.setText(p.getRebound());
        holder.astT.setText(p.getAssist());
        holder.stlT.setText(p.getSteal());
        holder.blkT.setText(p.getBlock());
        holder.turT.setText(p.getFault());
        holder.pfT.setText(p.getFault());
        holder.ptsT.setText(p.getPoint());
        holder.evT.setText(p.getEv() + "");
        holder.idT.setText(p.getPlayer_id().toString());

        if (mOnItemClickLitener != null) {
            holder.itemView.findViewById(R.id.player_info_wrap).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, p.getPlayer_id());
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, p.getPlayer_id());
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return players == null ? 0 : players.size();
    }


    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        @InjectView(R.id.player_head)
        public ImageView headI;
        @InjectView(R.id.player_name)
        public TextView nameT;
        @InjectView(R.id.player_pos)
        public TextView posT;
        @InjectView(R.id.market_sal)
        public TextView marketSalT;
        @InjectView(R.id.sign_sal)
        public TextView signSalT;
        @InjectView(R.id.fg)
        public TextView shootT;
        @InjectView(R.id.ft)
        public TextView ftT;
        @InjectView(R.id.reb)
        public TextView rebT;
        @InjectView(R.id.ast)
        public TextView astT;
        @InjectView(R.id.stl)
        public TextView stlT;
        @InjectView(R.id.blk)
        public TextView blkT;
        @InjectView(R.id.tur)
        public TextView turT;
        @InjectView(R.id.pf)
        public TextView pfT;
        @InjectView(R.id.pts)
        public TextView ptsT;
        @InjectView(R.id.ev)
        public TextView evT;
        @InjectView(R.id.player_id)
        public TextView idT;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }
    }

}

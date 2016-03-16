package com.zhstar.demo.nbamanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhstar.demo.nbamanager.Entity.TeamInfoItem;
import com.zhstar.demo.nbamanager.R;

import java.util.List;

public class TeamInfoItemAdapter extends RecyclerView.Adapter<TeamInfoItemAdapter.ViewHolder> {

    private Context context;
    private List<TeamInfoItem> infoItems;

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public TeamInfoItemAdapter(Context context, List<TeamInfoItem> infoItems) {
        this.infoItems = infoItems;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.team_info_item, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        TeamInfoItem item = infoItems.get(position);
        holder.nameT.setText(item.getItemName());
        holder.valueT.setText(item.getItemValue());

        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return infoItems == null ? 0 : infoItems.size();
    }


    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        public TextView nameT;
        public TextView valueT;

        public ViewHolder(View v) {
            super(v);
            nameT = (TextView) v.findViewById(R.id.item_name);
            valueT = (TextView) v.findViewById(R.id.item_val);
        }
    }


}

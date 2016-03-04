package com.zhstar.demo.nbamanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhstar.demo.nbamanager.Entity.MenuItem;
import com.zhstar.demo.nbamanager.R;

import java.util.List;

/**
 * Created by ceeg on 2015/5/19.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context context;
    protected List<T> datas;
    protected LayoutInflater inflater;
    private int layout;

    public CommonAdapter(Context context, List<T> datas,int layout) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = ViewHolder.get(context,convertView,parent, layout,position);

        convert(holder, (T) getItem(position));

        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,T data);
}

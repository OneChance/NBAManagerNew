package com.zhstar.demo.nbamanager.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ceeg on 2015/5/19.
 */
public class ViewHolder {

    private SparseArray<View> views;
    private int pos;
    private View convertView;

    public ViewHolder(Context context, ViewGroup parent, int layout, int pos) {
        this.pos = pos;
        this.views = new SparseArray<View>();
        convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        convertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layout, int pos) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layout, pos);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.pos = pos;
            return holder;
        }
    }

    public View getConvertView() {
        return convertView;
    }

    public <T extends View> T getView(int viewid) {
        View view = views.get(viewid);
        if (view == null) {
            view = convertView.findViewById(viewid);
        }
        views.put(viewid, view);
        return (T) view;
    }

    public ViewHolder setText(int viewid,String text){
        TextView tv = getView(viewid);
        tv.setText(text);
        return this;
    }

    public ViewHolder setImgRes(int viewid,int resid){
        ImageView iv = getView(viewid);
        iv.setImageResource(resid);
        return this;
    }

    public ViewHolder setImgBitmap(int viewid,Bitmap bitmap){
        ImageView iv = getView(viewid);
        iv.setImageBitmap(bitmap);
        return this;
    }
}

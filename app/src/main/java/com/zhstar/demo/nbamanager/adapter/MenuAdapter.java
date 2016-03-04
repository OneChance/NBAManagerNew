package com.zhstar.demo.nbamanager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.zhstar.demo.nbamanager.Entity.MenuItem;
import com.zhstar.demo.nbamanager.R;

import java.util.List;

/**
 * Created by ceeg on 2015/5/19.
 */
public class MenuAdapter extends CommonAdapter<MenuItem>{

    public MenuAdapter(Context context, List datas,int layout) {
        super(context, datas,layout);
    }

    @Override
    public void convert(ViewHolder holder, MenuItem data) {
        holder.setText(R.id.s_a_text,data.getMenuText());
        holder.setImgRes(R.id.s_a_img,data.getMenuImage());
    }
}

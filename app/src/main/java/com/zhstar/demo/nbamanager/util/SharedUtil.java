package com.zhstar.demo.nbamanager.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ceeg on 2015/5/13.
 */
public class SharedUtil {
    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getSharedPreferences(Context context){
        if(sharedPreferences==null){
            sharedPreferences = context.getSharedPreferences("myshare", Context.MODE_PRIVATE);
        }

        return sharedPreferences;
    }
}

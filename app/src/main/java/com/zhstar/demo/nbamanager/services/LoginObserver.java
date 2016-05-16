package com.zhstar.demo.nbamanager.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.entity.User;
import com.zhstar.demo.nbamanager.entity.UserData;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.activity.MainActivity;

import rx.Observer;


public class LoginObserver implements Observer<UserData> {

    public Context context;


    public LoginObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Toast.makeText(context, R.string.login_error, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onNext(UserData userData) {

        String msg = userData.getMessage();

        if (msg.equals("")) {

            User user = userData.getData();

            Intent intent = new Intent();
            intent.setClass(context, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("user", user);
            intent.putExtras(bundle);

            context.startActivity(intent);
        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

}

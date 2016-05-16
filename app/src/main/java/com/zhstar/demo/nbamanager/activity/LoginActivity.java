package com.zhstar.demo.nbamanager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.entity.User;
import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.databinding.LoginBinding;
import com.zhstar.demo.nbamanager.services.LoginObserver;
import com.zhstar.demo.nbamanager.util.Code;
import com.zhstar.demo.nbamanager.util.GameNetUtil;
import com.zhstar.demo.nbamanager.util.SharedUtil;


public class LoginActivity extends Activity {

    private SharedPreferences.Editor editor;
    private Context context;
    private LoginBinding binding;
    LoginObserver loginObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login);
        setContentView(R.layout.login);
        context = this;

        loginObserver = new LoginObserver(context);

        //仅仅是尝试使用dagger2,暂且没有明白如何高效利用
        //DaggerObserverComponent.builder().observerModule(new ObserverModule(context)).build().inject(this);

        SharedPreferences sharedPreferences = SharedUtil.getSharedPreferences(context);
        editor = sharedPreferences.edit();

        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        User user = new User(username, password);
        user.setUser_name("zh");
        binding.setUser(user);
    }

    public void login(View v) {

        String username = binding.getUser().getUser_name();
        String password = binding.getUser().getPassword();

        if (checkAccount(username, password)) {
            GameNetUtil.SetObserverCommonAction(GameNetUtil.getGameServices().Login(username, password))
                    .subscribe(loginObserver);
        }
    }

    public void reg(View v) {

    }

    public boolean checkAccount(String username, String password) {

        if (username.equals("")) {
            Toast.makeText(context, Code.EMPTYUSERNAME, Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.equals("")) {
            Toast.makeText(context, Code.EMPTYPASSWORD, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

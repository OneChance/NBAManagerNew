package com.zhstar.demo.nbamanager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.component.DaggerObserverComponent;
import com.zhstar.demo.nbamanager.module.ObserverModule;
import com.zhstar.demo.nbamanager.services.LoginObserver;
import com.zhstar.demo.nbamanager.util.Code;
import com.zhstar.demo.nbamanager.util.GameNetUtil;
import com.zhstar.demo.nbamanager.util.SharedUtil;
import com.zhstar.demo.nbamanager.view.button.ButtonRectangle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class LoginActivity extends Activity implements View.OnClickListener {

    @InjectView(R.id.account_edit)
    public EditText editName;
    @InjectView(R.id.password_edit)
    public EditText editPassword;
    @InjectView(R.id.login_btn)
    public ButtonRectangle loginBtn;
    @InjectView(R.id.reg_btn)
    public ButtonRectangle regBtn;
    private SharedPreferences.Editor editor;
    private Context context;

    @Inject
    LoginObserver loginObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.inject(this);
        context = this;


        //仅仅是尝试使用dagger2,暂且没有明白如何高效利用这个技术
        DaggerObserverComponent.builder().observerModule(new ObserverModule(context)).build().inject(this);

        SharedPreferences sharedPreferences = SharedUtil.getSharedPreferences(context);
        editor = sharedPreferences.edit();

        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        editName.setText(username);
        editPassword.setText(password);

        loginBtn.setOnClickListener(this);
        regBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String username = editName.getText().toString();
        String password = editPassword.getText().toString();

        if (username.equals("")) {
            Toast.makeText(context, Code.EMPTYUSERNAME, Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(context, Code.EMPTYPASSWORD, Toast.LENGTH_SHORT).show();
        } else {
            switch (v.getId()) {
                case R.id.login_btn:
                    GameNetUtil.SetObserverCommonAction(GameNetUtil.getGameServices().Login(username, password))
                            .subscribe(loginObserver);
                    break;
                case R.id.reg_btn:
                    break;
            }
        }
    }

}

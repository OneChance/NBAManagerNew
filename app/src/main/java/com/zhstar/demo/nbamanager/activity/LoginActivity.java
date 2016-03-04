package com.zhstar.demo.nbamanager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.zhstar.demo.nbamanager.R;
import com.zhstar.demo.nbamanager.services.LoginObserver;
import com.zhstar.demo.nbamanager.util.Code;
import com.zhstar.demo.nbamanager.util.GameNetUtil;
import com.zhstar.demo.nbamanager.util.SharedUtil;


public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText editName;
    private EditText editPassword;
    private Button loginBtn;
    private Button regBtn;
    private CheckBox checkSave;
    private SharedPreferences.Editor editor;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        context = this;

        editName = (EditText) findViewById(R.id.account_edit);
        editPassword = (EditText) findViewById(R.id.password_edit);
        loginBtn = (Button) findViewById(R.id.login_btn);
        regBtn = (Button) findViewById(R.id.reg_btn);
        checkSave = (CheckBox) findViewById(R.id.save_check);

        SharedPreferences sharedPreferences = SharedUtil.getSharedPreferences(context);
        editor = sharedPreferences.edit();

        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        if (!username.equals("")) {
            checkSave.setChecked(true);
        }

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
                            .subscribe(new LoginObserver(context));
                    break;
                case R.id.reg_btn:
                    break;
            }
        }
    }

}

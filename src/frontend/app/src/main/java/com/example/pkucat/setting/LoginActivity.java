package com.example.pkucat.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pkucat.App;
import com.example.pkucat.MainActivity;
import com.example.pkucat.R;
import com.example.pkucat.net.*;
import com.example.pkucat.net.Client;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class LoginActivity extends Activity {
    private App app;
    private EditText pkumail;
    private EditText pw;
    private Button register;
    private Button login;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        app = (App)getApplication();
        pkumail = findViewById(R.id.email);
        pw = findViewById(R.id.passward1);
        message = findViewById(R.id.textView7);
        // register
        register = findViewById(R.id.button6);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tostart = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(tostart);
                finish();
            }
        });

        // login
        login = findViewById(R.id.button5);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = pkumail.getText().toString();
                String password = pw.getText().toString();
                Client client = app.client;
                System.out.println(client.user.isLogin());
                try {
                    UserProfile profile = client.user.login(email, password);
                    System.out.println("登录成功");
                    System.out.println(profile.username);
                    System.out.println(profile.userID);
                    System.out.println(profile.email);
                    System.out.println(profile.whatsup);
                    System.out.println(profile.getAvatar());
                    System.out.println(client.user.isLogin());
                    app.login(profile.username, profile.email, profile.isAdmin);
                    app.setWhatsup(profile.whatsup);
                    finish();
                } catch (APIException e) {
                    message.setText(e.getDescription());
                }
            }
        });
    }
}
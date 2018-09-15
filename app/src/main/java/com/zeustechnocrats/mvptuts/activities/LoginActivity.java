package com.zeustechnocrats.mvptuts.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zeustechnocrats.mvptuts.R;
import com.zeustechnocrats.mvptuts.presenter.LoginPresenterImp;
import com.zeustechnocrats.mvptuts.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText etEmail, etPassword;
    Button btnLogin;
    private LoginPresenterImp loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        loginPresenter = new LoginPresenterImp(this);

        etEmail = (EditText) findViewById(R.id.etemail);
        etPassword = (EditText) findViewById(R.id.etpassword);
        btnLogin = (Button) findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = etEmail.getText().toString().trim();
                String strPassword = etPassword.getText().toString().trim();

                loginPresenter.performLogin(strEmail, strPassword);


            }
        });
    }

    @Override
    public void loginValidation() {
        Toast.makeText(this, "Please enter both value....", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Login error", Toast.LENGTH_SHORT).show();
    }
}

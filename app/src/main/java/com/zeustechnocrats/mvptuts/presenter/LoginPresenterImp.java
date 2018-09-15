package com.zeustechnocrats.mvptuts.presenter;

import com.zeustechnocrats.mvptuts.view.LoginView;

public class LoginPresenterImp implements  LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void performLogin(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            loginView.loginValidation();
        } else if (email.equals("admin") && password.equals("admin")) {
            loginView.onSuccess();
        }else{
            loginView.loginError();
        }
    }



}

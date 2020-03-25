package com.anindya.aplikasiku;

import com.anindya.aplikasiku.Model.Account;

public class Application extends android.app.Application{

    private static Account account;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Account getAccount() {
        return account;
    }
}

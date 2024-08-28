package com.prokys.demoAOP.dao;

import com.prokys.demoAOP.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    // getters and setters
    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}

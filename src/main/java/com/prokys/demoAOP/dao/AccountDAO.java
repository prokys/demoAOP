package com.prokys.demoAOP.dao;

import com.prokys.demoAOP.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    // getters and setters
    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    public List<Account> findAccounts();
}

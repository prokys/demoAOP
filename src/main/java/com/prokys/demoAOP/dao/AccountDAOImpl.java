package com.prokys.demoAOP.dao;

import com.prokys.demoAOP.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " Doing my db work - adding account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " doWork()");
        return false;
    }

    // getters and setters
    public String getName() {
        System.out.println(getClass() + " getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode");
        this.serviceCode = serviceCode;
    }
}

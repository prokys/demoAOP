package com.prokys.demoAOP.dao;

import com.prokys.demoAOP.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        //simulate exception

        if (tripWire){
            throw new RuntimeException("No soup for you");
        }

        List<Account> accounts = new ArrayList<>();

        //create sample accounts
        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Platinum");
        Account account3 = new Account("Luca", "Gold");

        //add them to the list
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }
}

package com.prokys.demoAOP.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addSillyMember() {
        System.out.println(getClass() + " DOING MY DB WORK - adding account");
    }
}

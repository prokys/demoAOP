package com.prokys.demoAOP.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + " DOING MY DB WORK - adding account");

        return true;
    }
}

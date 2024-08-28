package com.prokys.demoAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // add @Before advice
    @Before("execution(public void com.prokys.demoAOP.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){

        System.out.println("\n =====>>>> Executing @Before advice on addAccount()");

    }

}


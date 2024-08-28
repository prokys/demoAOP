package com.prokys.demoAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // creating pointcut declaration
    @Pointcut("execution(* com.prokys.demoAOP.dao.*.*(..))")
    private void forDAOPackage() {};


    // add @Before advice
    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice(){

        System.out.println("\n =====>>>> Executing @Before advice on addAccount()");

    }

}


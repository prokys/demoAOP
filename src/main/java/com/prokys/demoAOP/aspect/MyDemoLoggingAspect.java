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

    @Pointcut("execution(* com.prokys.demoAOP.dao.*.get*(..))")
    private void forGetterMethods(){};

    @Pointcut("execution(* com.prokys.demoAOP.dao.*.set*(..))")
    private void forSetterMethods(){};

    @Pointcut("forDAOPackage() && !(forGetterMethods() || forSetterMethods())")
    private void forDaoPackageNoGetterSetter(){};


    // add @Before advice
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){

        System.out.println("\n =====>>>> Executing @Before advice on method");

    }
    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n =====>>>> Performing api analytics");
    }

}


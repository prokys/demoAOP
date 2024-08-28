package com.prokys.demoAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLoggingAspect {

    // add @Before advice
    @Before("com.prokys.demoAOP.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloud(){
        System.out.println("\n =====>>>> Logging into cloud");
    }
}

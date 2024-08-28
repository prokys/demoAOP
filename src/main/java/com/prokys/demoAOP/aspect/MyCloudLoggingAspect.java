package com.prokys.demoAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLoggingAspect {

    // add @Before advice
    @Before("forDaoPackageNoGetterSetter()")
    public void logToCloud(){
        System.out.println("\n =====>>>> Logging into cloud");
    }
}

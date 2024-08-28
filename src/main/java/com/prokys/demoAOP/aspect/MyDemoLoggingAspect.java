package com.prokys.demoAOP.aspect;

import com.prokys.demoAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // add @Before advice
    @Before("com.prokys.demoAOP.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("\n =====>>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display the method arguments
        //get args
        Object[] args = joinPoint.getArgs();

        //loop through args
        for (Object arg : args){
            System.out.println(arg);

            if (arg instanceof Account){

                // downcast and print Account specific stuff
                Account account = (Account) arg;

                System.out.println("Account name: "+ account.getName());
                System.out.println("Account level: "+ account.getLevel());
            }
        }
    }

    //add @AfterReturning on findAccountsMethod
    @AfterReturning(pointcut = "execution(* com.prokys.demoAOP.dao.AccountDAO.findAccounts())", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterReturning on method: "+ method);

        //print out the results of method call
        System.out.println("\n====>>>> Result is: "+ result);

    }

}


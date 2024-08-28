package com.prokys.demoAOP.aspect;

import com.prokys.demoAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
    @AfterReturning(pointcut = "execution(* com.prokys.demoAOP.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterReturning on method: "+ method);

        //print out the results of method call
        System.out.println("\n====>>>> Result is: "+ result);

        //post-process data, modify it

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        //print out the results of method call
        System.out.println("\n====>>>> Result is: "+ result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        //loop through accounts
        for (Account account : result){

            //get uppercase version of names
            String upperCaseName = account.getName().toUpperCase();

            //update the name of account
            account.setName(upperCaseName);

        }
    }
    @AfterThrowing(pointcut = "execution(* com.prokys.demoAOP.dao.AccountDAO.findAccounts(..))", throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterThrowing on method: "+ method);

        //log the exception
        System.out.println("\n====>>>> Exception is: "+ exc);
    }

    @After("execution(* com.prokys.demoAOP.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @After on method: "+ method);

    }

    @Around("execution(* com.prokys.demoAOP.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @Around on method: "+ method);

        // get begin timestamp

        long begin = System.currentTimeMillis();

        // execute method
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            // log exception
            System.out.println("Exception = " + e.getMessage());

            //rethrow exception
            throw e;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end-begin;
        System.out.println("\nDuration = " + duration/1000.0000 + " seconds");

        return result;
    }

}


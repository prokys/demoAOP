package com.prokys.demoAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {
    // creating pointcut declaration
    @Pointcut("execution(* com.prokys.demoAOP.dao.*.*(..))")
    public void forDAOPackage() {};

    @Pointcut("execution(* com.prokys.demoAOP.dao.*.get*(..))")
    public void forGetterMethods(){};

    @Pointcut("execution(* com.prokys.demoAOP.dao.*.set*(..))")
    public void forSetterMethods(){};

    @Pointcut("forDAOPackage() && !(forGetterMethods() || forSetterMethods())")
    public void forDaoPackageNoGetterSetter(){};
}

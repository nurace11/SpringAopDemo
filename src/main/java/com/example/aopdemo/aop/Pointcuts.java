package com.example.aopdemo.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.example.aopdemo.service.ClientService.get*(..))")
    public void allGetMethods() {}

    @Pointcut("execution(* com.example.aopdemo.service.ClientService.add*(..))")
    public void allAddMethods() {}
}

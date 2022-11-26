package com.example.aopdemo.aop;

import com.example.aopdemo.entity.Client;
import com.example.aopdemo.util.CustomResponse;
import com.example.aopdemo.util.CustomStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@Slf4j
public class MyAspect {

    @Around("Pointcuts.allAddMethods()")
    public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Client client = null;

        if (methodSignature.getName().equals("addClient")){
            Object[] arguments = joinPoint.getArgs();
            for(Object arg : arguments) {
                if (arg instanceof Client) {
                    client = (Client) arg;
                    log.info("Try to add client {} at {}", client, LocalDate.now());
                }
            }
        }

        Object result = null;
        try {
            result = joinPoint.proceed(); // proceed() - executes the method (in this case addBook() method will be executed)
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }

        log.info("Client {} has been added", client.getName());
        return result;
    }

    @Around("Pointcuts.allGetMethods()")
    public Object aroundGettingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String name = null;

        if(methodSignature.getName().equals("getAll")){
            log.info("Try to get all clients");
        } else if (methodSignature.getName().equals("getClientByName")) {
            Object[] arguments = joinPoint.getArgs();
            for(Object arg : arguments) {
                if(arg instanceof String) {
                    name = (String) arg;
                    log.info("Try to get a client with name {}", name);
                }
            }
        }

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }

        if(methodSignature.getName().equals("getAll")){
            log.info("All clients received");
        } else if (methodSignature.getName().equals("getClientByName")) {
            log.info("Client with name {} has been found", name);
        }

        return result;
    }
}

package com.library.exercise_borrow.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    @After("execution(* com.library.exercise_borrow.services.impl.BookServiceImpl.findAll(..))")
    public void afterFindAll(JoinPoint joinPoint) {
        System.err.println("After end the function: " + joinPoint.getSignature().getName());
    }
}

package com.library.exercise_borrow.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    @After("execution(* com.library.exercise_borrow.services.impl.BookServiceImpl.findAll(..))")
    public void afterFindAll(JoinPoint joinPoint) {
        System.err.println("After end the function: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.library.exercise_borrow.services.impl.BookServiceImpl.borrow(..))")
    public void afterBorrowBook(JoinPoint joinPoint) {
        System.err.println("After end the function: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.library.exercise_borrow.services.impl.BookServiceImpl.pay(..))")
    public void afterPayBook(JoinPoint joinPoint) {
        System.err.println("After end the function: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.library.exercise_borrow.services.impl.BookServiceImpl.borrow(..))")
    public void afterZeroException(JoinPoint joinPoint) {
        System.err.println("After end the exception: " + joinPoint.getSignature().getName());
    }
}

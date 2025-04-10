package ru.innopolis.springaop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* ru.innopolis.springaop.service.BookService.get*(..))")
    public void allGetMethods() {}

    @Pointcut("execution(* ru.innopolis.springaop.service.BookService.add*(..))")
    public void allAddMethods() {}
}

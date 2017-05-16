package com.example.aspects;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.BeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by sza on 15.05.2017.
 */

@org.aspectj.lang.annotation.Aspect
public class AspectToLogAdditionInfo implements BeforeAdvice {
    private static final Logger LOGGER = Logger.getRootLogger();

    public void logInit(){
        LOGGER.setLevel(Level.INFO);
    }

    public void beforeCheck(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        String password = (String) args[0];

        if (password.equals("")) {
            LOGGER.info("VISTJETFUTURE-39223: passw is! ");
            LOGGER.info("Current stack is: " + Thread.currentThread().getStackTrace().toString());
            System.out.println("No pasw");
        }else{
            LOGGER.info(" passw is! ");
            System.out.println(password);
        }
    }
}

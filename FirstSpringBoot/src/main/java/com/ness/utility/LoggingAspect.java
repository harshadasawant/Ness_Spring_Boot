package com.ness.utility;

import com.ness.exception.HndBankException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
    @Before("execution(* com.ness.service.*Impl.*(..))")
    public void before() throws HndBankException {
        LOGGER.info("Before advice called.");
    }
    @After("execution(* com.ness.service.*Impl.*(..))")
    public void after() throws HndBankException {
        LOGGER.info("After advice called.");
    }
    @AfterReturning("execution(* com.ness.service.*Impl.*(..))")
    public void afterReturning() throws HndBankException {
        LOGGER.info("After returning advice called.");
    }
    @AfterThrowing(pointcut = "execution(* com.ness.service.*Impl.*(..))", throwing = "exception")
    public void afterThrowing(HndBankException exception) throws HndBankException {
        LOGGER.error(exception.getMessage(), exception);
    }
}

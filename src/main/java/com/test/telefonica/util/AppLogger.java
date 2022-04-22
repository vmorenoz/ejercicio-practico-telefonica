package com.test.telefonica.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class AppLogger {

    @Pointcut(value = "execution(* com.test.telefonica.services.*.*(..) )")
    public void executionCutPoint() {
    }

    @Around("executionCutPoint()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        String methodName, className;
        Object[] args;
        ObjectMapper mapper = new ObjectMapper();

        methodName = pjp.getSignature().getName();
        className = pjp.getTarget().getClass().getName();
        args = pjp.getArgs();

        log.info("Invoked method {}.{} with args: {}", className, methodName, mapper.writeValueAsString(args));

        Object result = pjp.proceed();

        log.info("Success execution of {}.{}", className, methodName);

        return result;
    }

    @AfterThrowing(value = "executionCutPoint()", throwing = "ex")
    public void applicationLoggerAfterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName, className, exceptionMessage;

        methodName = joinPoint.getSignature().getName();
        className = joinPoint.getTarget().getClass().getName();
        exceptionMessage = ex.getMessage();

        log.error("There was an error on {}.{}: {}", className, methodName, exceptionMessage);
    }

}

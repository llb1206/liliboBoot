package com.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.aop.aop.IndexController.*(..))")
    public void LogAspect(){}

    @Pointcut("execution(* com.aop.aop.ssController.*(..))")
    public void LogAspect1(){}

    @Before("LogAspect() || LogAspect1()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("------------------------------");
//        joinPoint.getArgs();
//        System.out.printl
//        n(joinPoint.getArgs()+"参数列表"+joinPoint.getTarget()+joinPoint.getKind());
//        System.out.println("doBefore");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("参数:{},value:{}", name, request.getParameter(name));
        }

    }

    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("doAfter");
    }

    @AfterReturning(value = "LogAspect()",returning = "returnValue")
    public void doAfterReturning(JoinPoint joinPoint,Object returnValue){
        System.out.println("方法返回值为：" + returnValue);
    }

    @AfterThrowing("LogAspect()")
    public void deAfterThrowing(JoinPoint joinPoint){

        System.out.println("deAfterThrowing");
    }

    @Around("LogAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("deAround");
        return joinPoint.proceed();
    }
}

package com.aop.aop2;//package com.xx.aop2;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//@Order(-1)
//@org.aspectj.lang.annotation.Aspect  //做标记，这是一个切面
//@Component
//public class Aspect2 {
//       @Pointcut("execution(* com.xx.aop2.*.*(..))")
//       public void poincut(){
//       }
//       @Before("poincut()")
//       public void asd(JoinPoint join) {
//         String name ="llb";
//
//       }
//       @Around("poincut()")
//       public void around(ProceedingJoinPoint pjp) throws Throwable{
//              System.out.println("已经记录下操作日志@Around 方法执行前");
//              pjp.proceed();
//              System.out.println("已经记录下操作日志@Around 方法执行后");
//       }
//}

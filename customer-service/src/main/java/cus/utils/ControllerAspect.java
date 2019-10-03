package cus.utils;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
//@Aspect
//@Component
public class ControllerAspect {

    @Pointcut("execution(public * cus.controller.*.*(..))")
    public void method(){

    }


    @Around("method()")
    public Object aroundMethod(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("环绕通知");


        //获取请求报文头部元数据
        ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取请求对象
        HttpServletRequest request=requestAttributes.getRequest();
        //记录控制器执行前的时间毫秒数
        //startTime.set(System.currentTimeMillis());

        //request.getMethod().equals("POST") && request.getContentType()

        log.info("前置通知执行：");
        log.info("url:"+request.getRequestURL());
        log.info("method:"+request.getMethod());
        log.info("ip:"+request.getRemoteAddr());
        log.info("class_method:"+pjp.getSignature().getDeclaringTypeName()+
                "."+pjp.getSignature().getName());
        log.info("args:"+ Arrays.toString(pjp.getArgs()));



        Object ret = pjp.proceed();
//      不能trycatch 否则下面的异常处理和全局异常处理都会无效
//        try{
//            ret = pjp.proceed();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }



        return ret;
    }


    @AfterThrowing("method()")
    public void afterThrowing()throws Throwable{

        try{
            System.out.println("异常通知");
        }catch (Exception ex){
            ex.printStackTrace();
        }



    }

}

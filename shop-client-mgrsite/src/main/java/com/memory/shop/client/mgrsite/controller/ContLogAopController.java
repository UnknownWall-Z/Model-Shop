package com.memory.shop.client.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.shop.api.goods.domain.Log;
import com.memory.shop.api.goods.service.IlogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import java.util.Date;

@Aspect
@Component
@Controller
public class ContLogAopController {
    /*定义拦截规则：拦截  包下面的所有类中，有@RequestMapping注解的方法。*/

    @Pointcut("execution(* com.memory.shop.client.mgrsite.controller.*.*(..)) AND @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void adviceCount(){}

    @Reference
    private IlogService logService;

    long beginTime;
    long endTime;

    @Before("adviceCount()")
    public void beforeAdvice(JoinPoint joinPoint){
        beginTime = System.currentTimeMillis();
    }

    @After("adviceCount()")
    public void afterAdive(JoinPoint joinPoint){
        endTime = System.currentTimeMillis();
        //通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        Log log = new Log();
        log.setUrl(signature.getName());
        log.setTime(endTime-beginTime+"ms");
        log.setDate(new Date());
        logService.save(log);
    }

}

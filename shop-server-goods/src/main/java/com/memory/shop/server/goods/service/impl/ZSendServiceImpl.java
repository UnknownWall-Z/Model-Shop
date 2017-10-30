package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.Log;
import com.memory.shop.api.goods.event.Attonity;
import com.memory.shop.api.goods.event.SendEvent;
import com.memory.shop.api.goods.service.IZSendService;
import com.memory.shop.api.goods.service.IlogService;
import com.memory.shop.server.goods.service.ZCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by wall on 2017/10/17.
 */
@Service
public class ZSendServiceImpl implements IZSendService , ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private IlogService logService;

    private ZCountVO countVO = new ZCountVO();

    public void printSend(Log log){

        ctx.publishEvent(new SendEvent(this,log));
    }

    @Override
    public void empty() {
        ctx.publishEvent(new Attonity(this));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        countVO.setCountSum(logService.count());
        System.out.println("老子启动了。");
    }

    /***
     * 5s执行一次
     */
//  @Scheduled(cron="*/5 * * * * ?")
    public void loadCount(){
        countVO.setCountSum(logService.count());
        System.out.println("加载成功");
    }

    @Override
    public int getLogCount(){
        return countVO.getCountSum();
    }

}

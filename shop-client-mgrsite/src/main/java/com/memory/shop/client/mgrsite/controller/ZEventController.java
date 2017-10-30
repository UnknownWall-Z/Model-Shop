package com.memory.shop.client.mgrsite.controller;

import com.memory.shop.api.goods.service.IZSendService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/10/17.
 */
@Controller
//@EnableScheduling
public class ZEventController {

    @com.alibaba.dubbo.config.annotation.Reference
    private IZSendService sendService;

    Logger logger = Logger.getLogger(ZEventController.class);

//    @Scheduled(cron="*/5 * * * * ?")
    @RequestMapping("send")
    @ResponseBody
    public String sendDemo(){

//        Log log = new Log();
//        log.setUrl("send");
//        log.setDate(new Date());
//        log.setTime("0ms");
//        sendService.printSend(log);
        sendService.empty();

//        int logCount = sendService.getLogCount();
//        System.out.println(logCount);


        logger.trace("+当前线程+");
        String name = Thread.currentThread().getName();
        logger.info(name);

        return "print";
    }

}

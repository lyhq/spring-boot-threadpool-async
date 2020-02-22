package com.you.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/***
 * MessageService 消息服务类
 *
 * 模拟取消订单后发短信和邮件
 *
 * @author: YangYoung
 * @date: 2020/2/21
 */
@Service
public class MessageService {

    // 发送提醒短信，假设发短信没有返回信息
    //@PostConstruct // 加上该注解项目启动时就执行一次该方法
    //taskExecutor: 指定使用自定义线程池, 没有指定就使用默认的
    @Async("poolTaskExecutor")
//    @Async
    public void sendSmsMessage() throws InterruptedException {
        System.out.println("[" + Thread.currentThread().getName() + "] 发送短信   执行开始");
        Thread.sleep(5000); // 模拟耗时
        System.out.println("[" + Thread.currentThread().getName() + "] 发送短信   执行结束");
    }

    // 发送提醒邮件，假设发邮件有返回信息
    //@PostConstruct // 加上该注解项目启动时就执行一次该方法
    //taskExecutor: 指定使用自定义线程池, 没有指定就使用默认的
    @Async("poolTaskExecutor")
//    @Async
    public Future<String> sendEmailMessage() throws InterruptedException {
        System.out.println("[" + Thread.currentThread().getName() + "] 发送邮件   执行开始");
        Thread.sleep(2000); // 模拟耗时
        System.out.println("[" + Thread.currentThread().getName() + "] 发送邮件   执行结束");
        //返回的结果需要通过AsyncResult这个类包装
        return new AsyncResult<>("[success]客户已收到消息");
    }
}

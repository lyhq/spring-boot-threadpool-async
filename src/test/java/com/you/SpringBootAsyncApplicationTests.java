package com.you;

import com.you.async.SpringBootAsyncApplication;
import com.you.async.service.OrderTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAsyncApplication.class)
public class SpringBootAsyncApplicationTests {

    @Autowired
    private OrderTaskService orderTaskService;

    @Test
    public void testMessage() throws IOException {
        try {
            orderTaskService.cancelOrderTask();
            //不让主线程过早结束，否则控制台看不到异步方法中的输出内容
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void contextLoads() {
    }

}

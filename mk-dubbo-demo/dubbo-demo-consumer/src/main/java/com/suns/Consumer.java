/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns <br>
 *
 * @author mk <br>
 * Date:2018-11-17 11:27 <br>
 */

package com.suns;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.suns.service.DemoService;
import com.suns.service.async.BarService;
import com.suns.service.async.FooService;
import com.suns.service.impl.eventNotify.NotifyImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * ClassName: Consumer <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-17 11:27 <br>
 * @version
 */
public class Consumer {

    ClassPathXmlApplicationContext context = null;
    @Before()
    public void before(){
        context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer.xml"});
        context.start();
    }

    @After
    public void after(){
        context.close();
    }


    @Test
    public void demo(){
        DemoService demoService = (DemoService) context.getBean("demoService");
        System.out.println(demoService.sayHello("suns"));
    }

    @Test
    public void demo1(){
        for(int i=0;i<10;i++){
            DemoService demoService = (DemoService) context.getBean("demoService");
            System.out.println(demoService.sayHello("suns"));
        }
    }

    @Test
    public void demo2(){
        // 回声测试可用性
        EchoService echoService = (EchoService) context.getBean("demoService");
        System.out.println(echoService.$echo("OK"));
    }

    @Test
    public void demo3() throws ExecutionException, InterruptedException {
        // 异步调用
        BarService barService = (BarService) context.getBean("barService");
        System.out.println(barService.find("abc"));// 此调用会立即返回null
        // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        Future<Object> future1 = RpcContext.getContext().getFuture();


        FooService fooService = (FooService) context.getBean("fooService");
        System.out.println(fooService.find("abc"));// 此调用会立即返回null
        // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        Future<Object> future2 = RpcContext.getContext().getFuture();


        Object result1 = future1.get();
        System.out.println("result1:"+result1);

        Object result2= future2.get();
        System.out.println("result2:"+result2);
    }


    @Test
    public void demo4() throws ExecutionException, InterruptedException {
        // 泛化
        GenericService genericService = (GenericService) context.getBean("myGenericService");
        Object result = genericService.$invoke("sayHello",new String[]{"java.lang.String"},new Object []{"泛化"});
        System.out.println(result);
    }


    @Test
    public void demo5() throws InterruptedException {
        //事件通知
        DemoService demoService = (DemoService) context.getBean("demoService2");
        System.out.println(demoService.sayHello("mk"));

        NotifyImpl notify = (NotifyImpl) context.getBean("demoCallback");
        //for Test：只是用来说明callback正常被调用，业务具体实现自行决定.
        System.out.println(notify.ret);
        for (int i = 0; i < 100; i++) {
            if (notify.ret.size() <= 0) {
                System.out.println(notify.ret);
                Thread.sleep(1000);
            } else {
                break;
            }
        }
        System.out.println(notify.ret);
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer.xml"});
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        System.out.println(demoService.sayHello("suns"));
        context.close();
    }
}

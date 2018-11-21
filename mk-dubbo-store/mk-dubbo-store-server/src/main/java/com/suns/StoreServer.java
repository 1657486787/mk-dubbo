/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns <br>
 *
 * @author mk <br>
 * Date:2018-11-12 17:31 <br>
 */

package com.suns;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * ClassName: StoreServer <br>
 * Description: dubbo的启动及配置方式方式 <br>
 * 1.引入pom:zk,zkclient,dubbo
 * 2.配置dubbo：
 *      1）XML的方式dubbo.xml
 *      2）properties的方式dubbo_properties.xml 及dubbo.properties :注意XML中的会覆盖properties的值
 *      3）annotation的方式dubbo_annotation.xml:注意需要将@Service改成dubbo自己的注解com.alibaba.dubbo.config.annotation.Service
 *      4）api的方式dubbo_api.xml
 *      5）spring boot的方式:详见mk-dubbo-store-server-springboot项目
 * 3.需要启动zookeeper
 * 4.启动，用main启动就行了，如StoreServer.main
 *
 * @author mk
 * @Date 2018-11-12 17:31 <br>
 * @version
 */
public class StoreServer {

    public static void main(String[] args) throws IOException {

        /**
         * dubbo.xml
         * dubbo_properties.xml
         * dubbo_annotation.xml
         * dubbo_api.xml
         */
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo.xml");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo_properties.xml");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo_annotation.xml");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo_api.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo_spi.xml");
        context.start();
        System.out.println("dubbo server start..............................");

        //为了保证服务一直运行，利用输入流的阻塞来模拟
//        System.in.read();// 按任意键退出
        synchronized (StoreServer.class){
            try {
                StoreServer.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

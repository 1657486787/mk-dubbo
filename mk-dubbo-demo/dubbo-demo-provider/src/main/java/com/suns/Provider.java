/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns <br>
 *
 * @author mk <br>
 * Date:2018-11-17 11:09 <br>
 */

package com.suns;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * ClassName: Provider <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-17 11:09 <br>
 * @version
 */
public class Provider {

    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo.xml"});
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-async.xml"});
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-geneic.xml"});
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-events-notify.xml"});
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-exception.xml"});
        context.start();
        System.out.println("provider start ...");

//        System.in.read();

        // 保证服务一直开着
        synchronized (Provider.class) {
            try {
                Provider.class.wait();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}

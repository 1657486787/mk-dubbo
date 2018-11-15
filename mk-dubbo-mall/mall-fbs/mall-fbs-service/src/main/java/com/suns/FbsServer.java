/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns <br>
 *
 * @author mk <br>
 * Date:2018-11-15 14:37 <br>
 */

package com.suns;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * ClassName: FbsServer <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-15 14:37 <br>
 * @version
 */
public class FbsServer {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo.xml");
        context.start();

        System.out.println("mall-fbs-service启动了...");
        System.in.read();
    }
}

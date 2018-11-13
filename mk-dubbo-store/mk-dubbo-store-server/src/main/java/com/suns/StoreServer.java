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
 * Description:  <br>
 * @author mk
 * @Date 2018-11-12 17:31 <br>
 * @version
 */
public class StoreServer {

    public static void main(String[] args) throws IOException {

        /**
         * dubbo.xml
         * dubbo_annotation.xml
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo.xml");
        context.start();
        System.out.println("dubbo server start..............................");
        System.in.read();// 按任意键退出
    }
}

/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns <br>
 *
 * @author mk <br>
 * Date:2018-11-15 10:07 <br>
 */

package com.suns.app;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: SpringBootStoreApplication <br>
 * Description: spring boot的方式:详见mk-dubbo-store-server-springboot项目 <br>
 * 1.启动storeServer项目
 * 2.启动SpringBootStoreApplication.main
 * 3.访问路径 http://localhost:8081/index?id=2
 *
 * 4.swagger访问路径：http://localhost:8081/swagger-ui.html
 * @author mk
 * @Date 2018-11-15 10:07 <br>
 * @version
 */
@SpringBootApplication(scanBasePackages = "com.suns")
@DubboComponentScan(basePackages = "com.suns.impl")
public class SpringBootStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStoreApplication.class,args);
        System.out.println("SpringBootStoreApplication start .......");
    }
}

/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.spi.jdk <br>
 *
 * @author mk <br>
 * Date:2018-11-20 8:58 <br>
 */

package com.suns.spi.jdk;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * ClassName: SpiMain <br>
 * Description: spi的两种实现方式：jdk自带的，dubbo <br>
 * 1.jdk:
 *  a.定义一个接口如JdkSpiService，多种实现DubboJdkSpiServiceImpl,RmiJdkSpiServiceImpl,RestJdkSpiServiceImpl
 *  b.在resources/META-INF/services/下，新建一个名为接口全路径的文件，如com.suns.spi.jdk.JdkSpiService，里面的内容就是具体的实现，自己根据业务来设置
 *  c.写个main方法运行，通过ServerLoader.load(JdkSpiService.class)，迭代，就可以获取具体的实现
 * 2.dubbo:
 *  a.在pom中引入dubbo的依赖
 *  b.对有@SPI接口，写自己的实现类，如FirstLoadBalance，LastLoadBalance
 *  c.在resources/META-INF/dubbo/下，新建一个名为接口全路径的文件，如com.alibaba.dubbo.rpc.cluster.LoadBalance，里面的内容（key-value）就是具体的实现，自己根据业务来设置
 *  d.配合提供者和消费者食用，如提供者mk-dubbo-store-server，消费者mk-dubbo-store-portal，在消费者的配置文件dubbo_spi.xml中新增如下配置
 *      <dubbo:reference interface="com.suns.service.UserService" id="userService" loadbalance="first"/>
 *     <dubbo:reference interface="com.suns.service.OrderService" id="orderService" loadbalance="last"/>
 * @author mk
 * @Date 2018-11-20 8:58 <br>
 * @version
 */
public class SpiMain {

    public static void main(String[] args) {
        ServiceLoader<JdkSpiService> load = ServiceLoader.load(JdkSpiService.class);
        Iterator<JdkSpiService> iterator = load.iterator();
        while(iterator.hasNext()){
            JdkSpiService jdkSpiService = iterator.next();
            String result = jdkSpiService.sayHello("mk");
            System.out.println("result==>"+result);
        }
    }
}

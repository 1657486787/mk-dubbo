package com.suns; /**
 * Project Name:mk-dubbo <br>
 * Package Name:PACKAGE_NAME <br>
 *
 * @author mk <br>
 * Date:2018-11-16 9:06 <br>
 */

import com.suns.service.OrderService;
import com.suns.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: StoreClient <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-16 9:06 <br>
 * @version
 */
public class StoreClient {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo.xml"});
        context.start();
        UserService userService = (UserService) context.getBean("userService");
        String detail = userService.getDetail("1");
        System.out.println("detail:"+detail);

        OrderService orderService = (OrderService) context.getBean("orderService");
        detail = orderService.getDetail("2");
        System.out.println("detail:"+detail);

        context.destroy();
    }
}

/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.controller <br>
 *
 * @author mk <br>
 * Date:2018-11-14 16:07 <br>
 */

package com.suns.controller;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.suns.service.OrderService;
import com.suns.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: IndexController <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-14 16:07 <br>
 * @version
 */
@Controller
public class IndexController implements ApplicationContextAware {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    private ApplicationContext context;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response){
        try{
            String id = request.getParameter("id");
            String userView = userService.getDetail(id);
            String orderView = orderService.getDetail(id);
            request.setAttribute("userView",userView);
            request.setAttribute("orderView",orderView);
            return "index";

        }catch (Exception e){
            System.out.println("...........error.............");
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public String check(HttpServletRequest request, HttpServletResponse response) {
        String serviceId = request.getParameter("serviceId");
        Object checkMsg = serviceId + " is not ready";
        try {
            EchoService echoService = (EchoService) context.getBean(serviceId);
            if ("OK".equals(echoService.$echo("OK"))){
                checkMsg = serviceId + " is OK";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(checkMsg);
        return checkMsg.toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}

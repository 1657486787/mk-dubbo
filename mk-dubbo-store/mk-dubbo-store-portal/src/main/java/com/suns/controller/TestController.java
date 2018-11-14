/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.controller <br>
 *
 * @author mk <br>
 * Date:2018-11-13 15:11 <br>
 */

package com.suns.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * ClassName: TestController <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-13 15:11 <br>
 * @version
 */
@Controller
public class TestController implements ApplicationContextAware {

    private ApplicationContext context;

    @RequestMapping("/test.do")
    @ResponseBody
    public String test(){
        System.out.println("test.....");
        return "tttt"+new Date();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}

/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.controller <br>
 *
 * @author mk <br>
 * Date:2018-11-15 16:24 <br>
 */

package com.suns.controller;

import com.suns.entity.OrderEntiry;
import com.suns.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: OrderController <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-15 16:24 <br>
 * @version
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        OrderEntiry orderView = orderService.getDetail(id);
        request.setAttribute("orderView", orderView);
        return "index";
    }
}

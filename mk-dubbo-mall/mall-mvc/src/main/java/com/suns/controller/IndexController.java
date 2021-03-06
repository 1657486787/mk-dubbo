package com.suns.controller;

import com.suns.entity.OrderEntiry;
import com.suns.entity.UserEntiry;
import com.suns.service.OrderService;
import com.suns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        UserEntiry userView = userService.getDetail(id);
        OrderEntiry orderView = orderService.getDetail(id);

        request.setAttribute("userView", userView);
        request.setAttribute("orderView", orderView);
        return "index";
    }

}

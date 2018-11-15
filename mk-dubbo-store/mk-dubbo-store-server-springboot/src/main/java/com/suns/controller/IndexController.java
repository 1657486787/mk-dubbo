/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.controller <br>
 *
 * @author mk <br>
 * Date:2018-11-15 10:24 <br>
 */

package com.suns.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.suns.service.OrderService;
import com.suns.service.ProductService;
import com.suns.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: IndexController <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-15 10:24 <br>
 * @version
 */
@Api("IndexController相关的api")
@RestController
public class IndexController {

    @Reference(check = true)
    private UserService userService;

    @Reference(check = true)
    private OrderService orderService;

    @Autowired
    private ProductService productService;//本地服务


    @RequestMapping("/index")
    public Object index(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String userView = userService.getDetail(id);
        String orderView = orderService.getDetail(id);
        String productView = productService.getDetail(id);

        Map map = new HashMap<>();
        map.put("userView", userView);
        map.put("orderView", orderView);
        map.put("productView", productView);
        return map;
    }


    @ApiOperation(notes = "查询detail",value = "根据id获取dubbo服务内容")
    @RequestMapping(value = "/swaggerIndex/{ida}",method={RequestMethod.GET})
    public Object swaggerIndex(@PathVariable(name = "ida") String id, HttpServletRequest request, HttpServletResponse response){
//        String id = request.getParameter("id");
        String userView = userService.getDetail(id);
        String orderView = orderService.getDetail(id);
        String productView = productService.getDetail(id);

        Map map = new HashMap<>();
        map.put("userView", userView);
        map.put("orderView", orderView);
        map.put("productView", productView);
        return map;
    }
}

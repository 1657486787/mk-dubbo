/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.controller <br>
 *
 * @author mk <br>
 * Date:2018-11-15 16:04 <br>
 */

package com.suns.controller;

import com.suns.entity.OrderEntiry;
import com.suns.entity.UserEntiry;
import com.suns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: UserController <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-15 16:04 <br>
 * @version
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        UserEntiry userView = userService.getDetail(id);
        request.setAttribute("userView", userView);
        return "index";
    }

}

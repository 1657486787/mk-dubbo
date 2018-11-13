/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl <br>
 *
 * @author mk <br>
 * Date:2018-11-12 17:27 <br>
 */

package com.suns.service.impl;

import com.suns.dao.UserDao;
import com.suns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-12 17:27 <br>
 * @version
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
        return userDao.getDetail(id);
    }
}

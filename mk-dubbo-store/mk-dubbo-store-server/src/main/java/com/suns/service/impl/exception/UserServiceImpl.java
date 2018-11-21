/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl <br>
 *
 * @author mk <br>
 * Date:2018-11-12 17:27 <br>
 */

package com.suns.service.impl.exception;

import com.suns.dao.UserDao;
import com.suns.service.UserService;
import com.suns.service.exception.BusinessException;
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
//@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
        System.out.println("提供者getDetail:" + id + "throw new BusinessException(\"提供者业务异常，消费者你能收到吗？\")");
        throw new BusinessException("提供者业务异常，消费者你能收到吗？");
//        return userDao.getDetail(id);
    }
}

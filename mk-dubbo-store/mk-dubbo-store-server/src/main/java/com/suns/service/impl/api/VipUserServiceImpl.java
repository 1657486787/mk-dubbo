/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl <br>
 *
 * @author mk <br>
 * Date:2018-11-12 17:29 <br>
 */

package com.suns.service.impl.api;

import com.suns.dao.UserDao;
import com.suns.service.VipUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: VipUserServiceImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-12 17:29 <br>
 * @version
 */
@Service
public class VipUserServiceImpl implements VipUserService {

    @Autowired
    private UserDao userDao;


    @Override
    public String getVipDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
        return userDao.getDetail(id) + "-->1234";
    }
}

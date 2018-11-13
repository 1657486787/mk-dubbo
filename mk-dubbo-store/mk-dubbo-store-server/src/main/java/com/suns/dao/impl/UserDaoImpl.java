/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.dao <br>
 *
 * @author mk <br>
 * Date:2018-11-12 17:33 <br>
 */

package com.suns.dao.impl;

import com.suns.dao.UserDao;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserDaoImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-12 17:33 <br>
 * @version
 */
@Service
public class UserDaoImpl implements UserDao {

    @Override
    public String getDetail(String id) {
        return "订单金额:100000000";
    }
}

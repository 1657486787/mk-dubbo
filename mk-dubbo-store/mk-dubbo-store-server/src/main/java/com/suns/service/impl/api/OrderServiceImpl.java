/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl <br>
 *
 * @author mk <br>
 * Date:2018-11-12 17:25 <br>
 */

package com.suns.service.impl.api;

import com.suns.dao.OrderDao;
import com.suns.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: OrderServiceImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-12 17:25 <br>
 * @version
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public String getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
        return orderDao.getDetail(id);
    }
}

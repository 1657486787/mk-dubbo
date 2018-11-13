/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.dao.impl <br>
 *
 * @author mk <br>
 * Date:2018-11-12 17:34 <br>
 */

package com.suns.dao.impl;

import com.suns.dao.OrderDao;
import org.springframework.stereotype.Service;

/**
 * ClassName: OrderDaoImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-12 17:34 <br>
 * @version
 */
@Service
public class OrderDaoImpl implements OrderDao {

    @Override
    public String getDetail(String id) {
        return "订单金额:100";
    }
}

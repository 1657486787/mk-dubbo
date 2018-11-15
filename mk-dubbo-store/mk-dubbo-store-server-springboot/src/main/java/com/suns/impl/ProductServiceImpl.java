/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.impl <br>
 *
 * @author mk <br>
 * Date:2018-11-15 10:26 <br>
 */

package com.suns.impl;

import com.suns.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * ClassName: ProductServiceImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-15 10:26 <br>
 * @version
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public String getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
        return "iponex 售价：1万元";
    }
}

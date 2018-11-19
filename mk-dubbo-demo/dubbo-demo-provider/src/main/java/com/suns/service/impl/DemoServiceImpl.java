/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl <br>
 *
 * @author mk <br>
 * Date:2018-11-17 11:07 <br>
 */

package com.suns.service.impl;

import com.suns.service.DemoService;

/**
 * ClassName: DemoServiceImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-17 11:07 <br>
 * @version
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        try {
            System.out.println("提供者sayHello:" + name);
            return "hello:" + name;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

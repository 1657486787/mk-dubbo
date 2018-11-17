/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl.async <br>
 *
 * @author mk <br>
 * Date:2018-11-17 17:01 <br>
 */

package com.suns.service.impl.async;

import com.suns.service.async.FooService;
import org.springframework.stereotype.Service;

/**
 * ClassName: FooServiceImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-17 17:01 <br>
 * @version
 */
@Service("fooService")
public class FooServiceImpl implements FooService {
    @Override
    public String find(String name) {
        try {
            Thread.sleep(200);
            System.out.println("FooServiceImpl:"+name);
            return "find foo :"+name;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

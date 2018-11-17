/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl.async <br>
 *
 * @author mk <br>
 * Date:2018-11-17 17:00 <br>
 */

package com.suns.service.impl.async;

import com.suns.service.async.BarService;
import org.springframework.stereotype.Service;

/**
 * ClassName: BarServiceImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-17 17:00 <br>
 * @version
 */
@Service("barService")
public class BarServiceImpl implements BarService {
    @Override
    public String find(String name) {
        try {
            Thread.sleep(100);
            System.out.println("提供者BarServiceImpl:"+name);
            return "find bar :"+name;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

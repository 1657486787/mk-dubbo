/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl.geneic <br>
 *
 * @author mk <br>
 * Date:2018-11-17 17:38 <br>
 */

package com.suns.service.impl.geneic;

import org.springframework.stereotype.Service;

/**
 * ClassName: GeneicServiceImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-17 17:38 <br>
 * @version
 */
@Service("myGeneicService")
public class MyGenericServiceImpl implements MyGeneicService {
    @Override
    public String sayHello(String name) {
        System.out.println("泛化调用:"+name);
        return "geneic:"+name;
    }
}

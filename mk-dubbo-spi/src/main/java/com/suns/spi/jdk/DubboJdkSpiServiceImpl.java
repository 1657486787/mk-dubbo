/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.spi.jdk <br>
 *
 * @author mk <br>
 * Date:2018-11-20 8:56 <br>
 */

package com.suns.spi.jdk;

/**
 * ClassName: DubboJdkSpiService <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-20 8:56 <br>
 * @version
 */
public class DubboJdkSpiServiceImpl implements JdkSpiService {
    @Override
    public String sayHello(String name) {
        System.out.println("I am DubboJdkSpiService..."+name);
        return "I am DubboJdkSpiService..."+name;
    }
}

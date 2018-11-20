/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.spi.jdk <br>
 *
 * @author mk <br>
 * Date:2018-11-20 8:55 <br>
 */

package com.suns.spi.jdk;

/**
 * ClassName: RmiJdkSpiService <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-20 8:55 <br>
 * @version
 */
public class RmiJdkSpiServiceImpl implements JdkSpiService {

    @Override
    public String sayHello(String name) {
        System.out.println("I am RmiJdkSpiService..."+name);
        return "I am RmiJdkSpiService..."+name;
    }
}

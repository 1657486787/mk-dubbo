/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.spi.jdk <br>
 *
 * @author mk <br>
 * Date:2018-11-20 8:57 <br>
 */

package com.suns.spi.jdk;

/**
 * ClassName: RestJdkSpiService <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-20 8:57 <br>
 * @version
 */
public class RestJdkSpiServiceImpl implements JdkSpiService {
    @Override
    public String sayHello(String name) {
        System.out.println("I am RestJdkSpiService..."+name);
        return "I am RestJdkSpiService..."+name;
    }
}

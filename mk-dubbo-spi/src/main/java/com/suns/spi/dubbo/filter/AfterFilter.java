/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.spi.dubbo.filter <br>
 *
 * @author mk <br>
 * Date:2018-11-20 16:25 <br>
 */

package com.suns.spi.dubbo.filter;

import com.alibaba.dubbo.rpc.*;

/**
 * ClassName: AfterFilter <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-20 16:25 <br>
 * @version
 */
public class AfterFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("this is my AfterFilter...."+invoker.getUrl());
        return invoker.invoke(invocation);
    }
}

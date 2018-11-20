/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.spi.dubbo.loadbalance <br>
 *
 * @author mk <br>
 * Date:2018-11-20 9:45 <br>
 */

package com.suns.spi.dubbo.loadbalance;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;

import java.util.List;

/**
 * ClassName: FirstLoadBalance <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-20 9:45 <br>
 * @version
 */
public class FirstLoadBalance implements LoadBalance {

    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        System.out.println("启动第一个LoadBalance");
        return invokers.get(0);//固定使用第一个
    }
}

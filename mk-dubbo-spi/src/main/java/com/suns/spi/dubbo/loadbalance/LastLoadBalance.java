/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.spi.dubbo.loadbalance <br>
 *
 * @author mk <br>
 * Date:2018-11-20 9:46 <br>
 */

package com.suns.spi.dubbo.loadbalance;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;

import java.util.List;

/**
 * ClassName: LastLoadBalance <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-20 9:46 <br>
 * @version
 */
public class LastLoadBalance implements LoadBalance {
    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        System.out.println("启动最后一个LoadBalance");
        return invokers.get(invokers.size()-1);//固定最后一个
    }
}

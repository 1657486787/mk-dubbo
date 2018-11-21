/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.spi.dubbo.filter <br>
 *
 * @author mk <br>
 * Date:2018-11-20 16:25 <br>
 */

package com.suns.spi.dubbo.filter;

import com.alibaba.dubbo.rpc.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ConsumerFilter <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-20 16:25 <br>
 * @version
 */
public class ConsumerFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        start();//过滤之前做点事情
        Result result = invoker.invoke(invocation);
        end();//过滤之后做点事情
        return result;
    }

    private void end() {
        System.out.println("消费端设置参数 ...end");
    }

    private void start() {
        System.out.println("消费端设置参数 ...start");
        try {
            Map<String,String> param = new HashMap<>();
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            param.put("ip",hostAddress);
            RpcContext.getContext().setAttachments(param);

            System.out.println("add param,ip:"+hostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}

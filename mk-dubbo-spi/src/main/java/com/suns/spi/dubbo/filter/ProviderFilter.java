/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.spi.dubbo.filter <br>
 *
 * @author mk <br>
 * Date:2018-11-20 16:25 <br>
 */

package com.suns.spi.dubbo.filter;

import com.alibaba.dubbo.rpc.*;

import java.util.Map;

/**
 * ClassName: AfterFilter <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-20 16:25 <br>
 * @version
 */
public class ProviderFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("this is my AfterFilter...."+invoker.getUrl());
        start();
        Result result = invoker.invoke(invocation);
        end();
        return result;
    }

    private void start() {
        System.out.println("提供者接受参数 ...start");
        String ip = RpcContext.getContext().getAttachment("ip");
        System.out.println("receive param,ip="+ip);
        Map<String, String> attachments = RpcContext.getContext().getAttachments();
        System.out.println("receive param,attachments="+attachments);
    }

    private void end() {
        System.out.println("提供者接受参数 ...end");
    }
}

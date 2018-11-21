package com.suns.spi.dubbo.filter;

import com.alibaba.dubbo.common.utils.ReflectUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.suns.service.exception.BusinessException;

import java.lang.reflect.Method;

/** 
 * 处理自定义异常
 */
public class BusinessExceptionFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            Result result = invoker.invoke(invocation);
            if (result.hasException() && GenericService.class != invoker.getInterface()) {
                try {
                    Throwable exception = result.getException();

                    // 如果是checked异常，直接抛出
                    if (!(exception instanceof RuntimeException) && (exception instanceof Exception)) {
                        return result;
                    }

                    //如果是自定义异常，直接抛出，2017-12-15
                    if (exception instanceof BusinessException) {
                        return result;
                    }

                    // 在方法签名上有声明，直接抛出
                    try {
                        Method method = invoker.getInterface().getMethod(invocation.getMethodName(), invocation.getParameterTypes());
                        Class<?>[] exceptionClassses = method.getExceptionTypes();
                        for (Class<?> exceptionClass : exceptionClassses) {
                            if (exception.getClass().equals(exceptionClass)) {
                                return result;
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        return result;
                    }

                    // 未在方法签名上定义的异常，在服务器端打印ERROR日志
                    System.out.println("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost() + ". service: "
                            + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: "
                            + exception.getClass().getName() + ": " + exception.getMessage());

                    // 异常类和接口类在同一jar包里，直接抛出
                    String serviceFile = ReflectUtils.getCodeBase(invoker.getInterface());
                    String exceptionFile = ReflectUtils.getCodeBase(exception.getClass());
                    if (serviceFile == null || exceptionFile == null || serviceFile.equals(exceptionFile)) {
                        return result;
                    }
                    // 是JDK自带的异常，直接抛出
                    String className = exception.getClass().getName();
                    if (className.startsWith("java.") || className.startsWith("javax.")) {
                        return result;
                    }
                    // 是Dubbo本身的异常，直接抛出
                    if (exception instanceof RpcException) {
                        return result;
                    }

                    // 否则，包装成RuntimeException抛给客户端
                    return new RpcResult(new RuntimeException(StringUtils.toString(exception)));
                } catch (Throwable e) {
                    System.out.println("Fail to ExceptionFilter when called by " + RpcContext.getContext().getRemoteHost() + ". service: "
                            + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName()
                            + ": " + e.getMessage());
                    return result;
                }
            }
            return result;
        } catch (RuntimeException e) {
            System.out.println("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost() + ". service: "
                    + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName() + ": "
                    + e.getMessage());
            throw e;
        }
    }

}

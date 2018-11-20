/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl.api <br>
 *
 * @author mk <br>
 * Date:2018-11-15 9:22 <br>
 */

package com.suns.service.impl.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.suns.service.VipUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: ApiConfiguration <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-15 9:22 <br>
 * @version
 */
@Configuration
public class ApiConfiguration {

    @Bean
    public ApplicationConfig applicationConfig(){
        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("mk-dubbo-store-server-api");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        // 连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://10.50.10.169:2181");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("rmi");
        protocolConfig.setPort(20884);
        return protocolConfig;
    }

    @Bean
    public ServiceConfig serviceConfig(){
        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
        // 服务提供者暴露服务配置
        // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        ServiceConfig<VipUserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(VipUserService.class);
        serviceConfig.setRef(new VipUserServiceImpl());

        serviceConfig.setApplication(applicationConfig());
        serviceConfig.setRegistry(registryConfig());
        serviceConfig.setProtocol(protocolConfig());

        // 暴露及注册服务
        serviceConfig.export();
        return serviceConfig;
    }

}

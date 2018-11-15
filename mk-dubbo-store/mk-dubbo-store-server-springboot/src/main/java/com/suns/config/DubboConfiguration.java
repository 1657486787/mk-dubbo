/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.impl.api <br>
 *
 * @author mk <br>
 * Date:2018-11-15 9:22 <br>
 */

package com.suns.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: DubboConfiguration <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-15 9:22 <br>
 * @version
 */
@Configuration
public class DubboConfiguration {

    @Value("${dubbo.name}")
    private String applicationName;

    @Value("${dubbo.zookeeper}")
    private String zookeeperAddress;

    @Bean
    public ApplicationConfig applicationConfig(){
        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        // 连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(zookeeperAddress);
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

}

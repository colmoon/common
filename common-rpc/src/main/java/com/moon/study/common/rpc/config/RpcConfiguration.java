package com.moon.study.common.rpc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign异常配置
 *
 * @author wuxiaojian
 * @time 2022/03/05
 */
@Configuration
public class RpcConfiguration {

    @Bean
    @ConditionalOnMissingBean(ExceptionWrapper.class)
    public DefaultExceptionWrapper defaultExceptionWrapper() {
        return new DefaultExceptionWrapper();
    }

}

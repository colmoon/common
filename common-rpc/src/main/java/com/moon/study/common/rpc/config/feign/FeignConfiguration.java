package com.moon.study.common.rpc.config.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moon.study.common.rpc.config.ExceptionWrapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign异常配置
 *
 * @author wuxiaojian
 * @time 2022/02/20
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public ErrorDecoder feignErrorDecoder(ObjectMapper objectMapper, ExceptionWrapper exceptionWrapper) {
        return new FeignErrorDecoder(objectMapper, exceptionWrapper);
    }

}

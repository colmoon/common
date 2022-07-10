package com.moon.study.common.service.config.message;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * MessageSource自动配置类
 *
 * @author wuxiaojian
 * @time 2022/07/06 09:28
 */
@Configuration
public class MessageSourceConfiguration {

    @Bean
    @ConditionalOnMissingBean(MessageSource.class)
    public MessageSource getMessageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("i18n/message");
        resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
        return resourceBundleMessageSource;
    }

}
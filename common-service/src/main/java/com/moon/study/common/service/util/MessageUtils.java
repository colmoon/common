package com.moon.study.common.service.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 获取i18n资源文件
 * 国际化信息目录：/i18n/message
 * 中文文件  message_zh_CN.properties
 * 英文文件  message_en_US.properties
 *
 * 设置中文 ：   LocaleContextHolder.getLocale()、Locale.SIMPLIFIED_CHINESE
 * 设置英文：    Locale.US
 * @author wuxiaojian
 */
@Slf4j
public class MessageUtils {


    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return 获取国际化翻译值
     */
    public static String message(String code, Object... args) {
        ResourceBundleMessageSource messageSource = SpringContextUtil.getBean(ResourceBundleMessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    /**
     * 数据处理
     * @param code 错误码
     * @param defaultMessage 默认错误信息
     * @param params 配置文件中错误信息
     * @return 获取国际化翻译值
     */
    public static String message(String code, String defaultMessage, Object... params){
        ResourceBundleMessageSource messageSource = SpringContextUtil.getBean(ResourceBundleMessageSource.class);
        return messageSource.getMessage(code, params, defaultMessage, LocaleContextHolder.getLocale());
    }

}

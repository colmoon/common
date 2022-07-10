package com.moon.study.common.base.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;

/**
 * i18n util
 *
 * @author wuxiaojian
 */
@Slf4j
public class I18nUtil {

    private static Properties propEn = null;
    private static Properties propZh = null;


    public static void loadI18nProp(){
        if (propEn != null && propZh != null) {
            return ;
        }
        try {
            // build i18n prop
            String i18nFile = "base/i18n/message_en_US.properties";

            // load prop
            Resource resource = new ClassPathResource(i18nFile);
            EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
            propEn = PropertiesLoaderUtils.loadProperties(encodedResource);

            i18nFile = "base/i18n/message_zh_CN.properties";

            // load prop
            resource = new ClassPathResource(i18nFile);
            encodedResource = new EncodedResource(resource,"UTF-8");
            propZh = PropertiesLoaderUtils.loadProperties(encodedResource);

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * get val of i18n key
     *
     * @param key:
     * @return
     */
    public static String getString(String key) {
        if (StringUtil.isEmpty(key)){
            return key;
        }
        Locale locale = LocaleContextHolder.getLocale();
        if (Objects.isNull(propEn) || Objects.isNull(propZh)){
            loadI18nProp();
        }
        String property;
        if (Locale.US.equals(locale)){
            property = propEn.getProperty(key);
        } else {
            property = propZh.getProperty(key);
        }
        return StringUtil.isNotEmpty(property) ? property : key;
    }


}

package com.moon.study.common.service.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * spring上下文工具类
 *
 * @author wuxiaojian
 * @date 2020/11/13
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    /**
     * spring应用上下文
     */
    private static ApplicationContext applicationContext;

    /**
     * 0-2表示开发，测试，生产环境
     */
    private static byte environ = 2;

    /**
     * 实现ApplicationContextAware接口的回调方法。设置上下文环境
     * @param applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
        //获取当前的系统环境
        Environment evn = applicationContext.getEnvironment();
        String[] activeProfiles = evn.getActiveProfiles();
        for (String profile : activeProfiles) {
            if ("dev".equals(profile)){
                environ = 0;
                break;
            } else if ("test".equals(profile)){
                environ = 1;
                break;
            } else if ("prod".equals(profile)){
                environ = 2;
                break;
            }
        }
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象
     * @param name
     * @return Object
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * 获取对象
     * @param clazz
     * @return Object
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return applicationContext.getBean(clazz);
    }

    /**
     * 当前是否为开发环境
     * @return: boolean
     **/
    public static boolean isDev() {
        return environ == 0;
    }

    /**
     * 是否为测试环境
     * @return: boolean
     **/
    public static boolean isTest(){
        return environ == 1;
    }

    /**
     * 是否为生产环境
     * @return: boolean
     **/
    public static boolean isProd(){
        return environ == 2;
    }

    /**
     * 获取当前环境
     * @return: boolean
     **/
    public static byte getEnviron(){
        return environ;
    }

}

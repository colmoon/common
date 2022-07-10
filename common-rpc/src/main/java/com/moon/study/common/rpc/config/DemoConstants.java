package com.moon.study.common.rpc.config;

/**
 * client配置
 *
 * @author wuxiaojian
 * @time 2022/02/20
 */
public class DemoConstants {

    public static final String DEFAULT_SERVICE_NAME = "${common.client.name:common}";

    public static class Demo {
        public static final String NAME = "demo";
        public static final String SERVICE_NAME = "${" + NAME + ".client.name:" + DEFAULT_SERVICE_NAME + "}";
    }

}

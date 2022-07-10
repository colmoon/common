package com.moon.study.common.start;

import org.springframework.cloud.client.SpringCloudApplication;

import java.lang.annotation.*;

/**
 * 启动类注解
 *
 * @author wuxiaojian
 * @time 2022/2/20 14:45
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringCloudApplication
public @interface Application {
}

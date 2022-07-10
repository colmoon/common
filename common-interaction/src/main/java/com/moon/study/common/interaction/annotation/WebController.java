package com.moon.study.common.interaction.annotation;

import org.springframework.stereotype.Controller;

import java.lang.annotation.*;

/**
 * web请求注解
 * @author wuxiaojian
 * @date 2021/03/05
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Web
@Controller
public @interface WebController {
}

package com.moon.study.common.rpc.config;


/**
 * 默认异常处理
 *
 * @author wuxiaojian
 * @time 2022/02/20
 */
public class DefaultExceptionWrapper implements ExceptionWrapper {
    @Override
    public Exception wrap(Exception wrapped) {
        return wrapped;
    }
}

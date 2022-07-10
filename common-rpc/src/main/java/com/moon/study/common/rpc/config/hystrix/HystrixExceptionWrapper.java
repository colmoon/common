package com.moon.study.common.rpc.config.hystrix;

import com.moon.study.common.rpc.config.ExceptionWrapper;
import com.netflix.hystrix.exception.HystrixBadRequestException;

public class HystrixExceptionWrapper implements ExceptionWrapper {
    @Override
    public Exception wrap(Exception wrapped) {
        return new HystrixBadRequestException(wrapped.getMessage(), wrapped);
    }
}

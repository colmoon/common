package com.moon.study.common.rpc.rpc;

import com.moon.study.common.api.api.DemoApi;
import com.moon.study.common.rpc.config.DemoConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author wuxiaojian
 * @time 2020/12/09
 */
@FeignClient(
        name = DemoConstants.Demo.SERVICE_NAME,
        contextId = DemoConstants.Demo.NAME,
        fallback = DemoApiClient.AccessFallback.class,
        configuration = DemoApiClient.AccessFallback.class
)
public interface DemoApiClient extends DemoApi {

    @Component
    class AccessFallback implements DemoApiClient {

        @Override
        public void delete(Long id){}

    }

}

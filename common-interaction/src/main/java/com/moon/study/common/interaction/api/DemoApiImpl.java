package com.moon.study.common.interaction.api;

import com.moon.study.common.api.api.DemoApi;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * rpc调用实现类demo
 *
 * @author wuxiaojian
 * @time 2022/02/20
 */
@Api(tags = "rpc调用demo")
@RestController
public class DemoApiImpl implements DemoApi {

    @Override
    public void delete(Long id){
       //进行删除逻辑服务调用，等于controller层调用service层
    }

}

package com.moon.study.common.service.event;

import com.moon.study.common.base.model.event.BaseDomainEvent;

/**
 * 领域事件发布接口
 *
 * @author wuxiaojian
 * @date  2021/02/21
 */
public interface DomainEventPublisher {

    /**
     * 发布事件
     *
     * @param event 领域事件
     */
    void publishEvent(BaseDomainEvent event);

}

package com.moon.study.common.base.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moon.study.common.base.utils.DateUtil;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * dto 时间到毫秒
 *
 * 逻辑删除
 *
 * @author wuxiaojian
 * @date 2022/11/13
 */
@Data
public class BaseEntityMsDTO {

    /**
     * 主键id 采用默认雪花算法
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = DateUtil.YYYY_MM_DD_HH_MM_SS_SSS)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = DateUtil.YYYY_MM_DD_HH_MM_SS_SSS)
    private LocalDateTime gmtModified;

    /**
     * 是否删除，0位未删除
     */
    private Long deleted;

}

package com.moon.study.common.base.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 分页数据返回实体
 *
 * @author wuxiaojian
 * @time 2020/11/13 13:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PageResult<T> extends BaseResult {

    private Long total;

    private List<T> data;

    public PageResult() {
    }

    public static <T> PageResult<T> ok(Page<T> result) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setCode(CODE_SUCCESS);
        pageResult.setMessage(QUERY_SUCCESS);
        pageResult.setTotal(result.getTotal());
        pageResult.setData(result.getRecords());
        return pageResult;
    }

    public static <T> PageResult<T> ok(Long total,List<T> data) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setCode(CODE_SUCCESS);
        pageResult.setMessage(QUERY_SUCCESS);
        pageResult.setTotal(total);
        pageResult.setData(data);
        return pageResult;
    }

}


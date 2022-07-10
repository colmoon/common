package com.moon.study.common.base.model.query;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.moon.study.common.base.result.Page;
import com.moon.study.common.base.utils.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页查询
 * @author wuxiaojian
 * @time 2020/11/17 13:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PageQuery extends Page {

    private Long offset = -1L;

    private Long limit = 20L;

    private String sort;

    private String order;

    protected final Map<String, String> SORTS_MAP = new HashMap<>();

    protected final Map<String, String> ORDER_MAP = new HashMap<>();

    protected final Map<String, String> REVERSAL_ORDER_MAP = new HashMap<>();

    {
        SORTS_MAP.put("asc", "asc");
        SORTS_MAP.put("desc", "desc");
    }

    public Long getOffset() {
        return offset;
    }

    @Override
    public void setOffset(Long offset) {
        this.offset = offset;
        super.setOffset(offset);
    }

    public Long getLimit() {
        return getSize();
    }

    @Override
    public void setLimit(Long limit) {
        this.limit = limit;
        setSize(limit);
    }

    public Long getPageNo() {
        return getCurrent();
    }

    public void setPageNo(Long pageNum) {
        setCurrent(pageNum);
    }

    public Long getPageSize() {
        return getSize();
    }

    public void setPageSize(Long pageSize) {
        setSize(pageSize);
    }

    @Override
    public long offset() {
        if (getOffset() >= 0) {
            return getOffset();
        }
        return getCurrent() > 0 ? (getCurrent() - 1) * getSize() : 0;
    }

    @Override
    @ApiModelProperty(hidden = true)
    public List getRecords() {
        return super.getRecords();
    }

    @Override
    @ApiModelProperty(hidden = true)
    public long getSize() {
        return super.getSize();
    }

    @Override
    @ApiModelProperty(hidden = true)
    public long getTotal() {
        return super.getTotal();
    }

    public String getOrder() {
        String order = ORDER_MAP.get(this.order);
        if (StringUtil.isNotBlank(order)) {
            return order;
        } else if (ORDER_MAP.containsValue(this.order)){
            return this.order;
        }

        order = REVERSAL_ORDER_MAP.get(this.order);
        if (StringUtil.isNotBlank(order)) {
            reversalSort();
            return order;
        }

        return null;
    }

    public String getSort() {
        String sort = SORTS_MAP.get(this.sort);
        return StringUtil.isBlank(sort) ? "desc" : sort;
    }

    private void reversalSort() {
        String sort = getSort();
        if ("asc".equals(sort)) {
            setSort("desc");
        } else {
            setSort("asc");
        }
    }

    public void addOrderItem() {
        List<OrderItem> orderItems = new ArrayList();
        if (StringUtil.isNotBlank(this.getOrder())) {
            orderItems.add(this.getSort().equals("asc") ? OrderItem.asc(this.getOrder()) : OrderItem.desc(this.getOrder()));
        } else {
            orderItems.add(OrderItem.desc("id"));
        }
        this.addOrder(orderItems);
    }
}


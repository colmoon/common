package com.moon.study.common.base.result;

import com.moon.study.common.base.utils.I18nUtil;
import lombok.Data;

/**
 * 基础返回实体
 *
 * @author wuxiaojian
 * @time 2020/11/13 13:17
 */
@Data
public class BaseResult {
    /**
     * httpCode
     */
    private Integer code;

    /**
     * 业务code
     */
    private String errorCode;

    /**
     * 业务信息
     */
    private String message;

    /**
     * 链路id
     */
    private String traceId;

    public BaseResult() {
    }

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = I18nUtil.getString(message);
    }

    public BaseResult(Integer code, String errorCode, String message) {
        this.code = code;
        this.errorCode = errorCode;
        this.message = I18nUtil.getString(message);
    }

    /**
     * 通用业务请求状态码
     */
    public static final Integer CODE_SUCCESS = 200;
    public static final Integer CODE_SYSTEM_ERROR = 500;
    public static final Integer CODE_AUTH_ERROR = 403;

    /**
     * 通用请求信息
     */
    public static final String SYSTEM_ERROR = "system.error";
    public static final String SYSTEM_AUTH_ERROR = "system.auth.error";
    public static final String MESSAGE_SUCCESS = "message.success";
    public static final String QUERY_SUCCESS = "query.success";
    public static final String INSERT_SUCCESS = "insert.success";
    public static final String UPDATE_SUCCESS = "update.success";
    public static final String DELETE_SUCCESS = "delete.success";
    public static final String IMPORT_SUCCESS = "import.success";
    public static final String EXPORT_SUCCESS = "export.success";
    public static final String DOWNLOAD_SUCCESS = "download.success";

}

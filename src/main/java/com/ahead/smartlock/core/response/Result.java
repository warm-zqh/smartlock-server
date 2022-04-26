package com.ahead.smartlock.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 返回集
 * @author zqh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "结果集")
public class Result<T> {

    @ApiModelProperty(value = "业务状态码")
    private Integer code;

    @ApiModelProperty(value = "请求信息")
    private String msg;

    @ApiModelProperty(value = "分页数据")
    private T data;

    public static <T> Result<T> success(T data) {
        return Result.<T>builder().code(HttpStatus.OK.value()).msg("执行成功").data(data).build();
    }

    public static <T> Result<T> fails(String msg) {
        return Result.<T>builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).msg(msg).data(null).build();
    }

    public static <T> Result<T> fails(Integer code, String msg) {
        return Result.<T>builder().code(code).msg(msg).data(null).build();
    }
}

package com.ahead.smartlock.core.response;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * 分页返回集
 *
 * @author zqh
 */
@Data
@Builder
@ApiModel(value = "分页结果集")
public class ResultPage<T> {
    @ApiModelProperty(value = "业务状态码")
    private Integer code;

    @ApiModelProperty(value = "请求信息")
    private String msg;

    @ApiModelProperty(value = "分页数据")
    private Data<T> data;


    public static <T> ResultPage<T> success(Page<T> page) {
        Data<T> data = new Data<>();
        data.setResult(page.getRecords());
        data.setMeta(Meta.builder().page(page.getCurrent()).perPage(page.getSize()).total(page.getTotal()).build());

        return ResultPage.<T>builder().code(HttpStatus.OK.value()).msg("执行成功").data(data).build();
    }

    @lombok.Data
    static class Data<T> {
        private List<T> result;
        private Meta meta;
    }

    @lombok.Data
    @Builder
    static class Meta {
        private Long page;
        private Long perPage;
        private Long total;
    }
}

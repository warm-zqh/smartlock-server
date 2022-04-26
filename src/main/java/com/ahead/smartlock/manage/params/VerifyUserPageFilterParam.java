package com.ahead.smartlock.manage.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zqh
 * @description 身份认证分页筛选参数
 */
@Data
public class VerifyUserPageFilterParam {
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String phone;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String status;
}

package com.ahead.smartlock.manage.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zqh
 * @description 身份认证修改参数
 */
@Data
public class VerifyUserUpdateParam {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String status;
}

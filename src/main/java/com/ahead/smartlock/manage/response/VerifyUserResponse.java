package com.ahead.smartlock.manage.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zqh
 * @description 身份认证返回参数
 */
@Data
public class VerifyUserResponse {
    /**
     * 学校名称
     */
    @ApiModelProperty(value = "学校名称")
    private String schoolName;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String telephoneNumber;
    /**
     * 学号/工号
     */
    @ApiModelProperty(value = "学号/工号")
    private String workId;
    /**
     * 学院
     */
    @ApiModelProperty(value = "学院")
    private String college;
    /**
     * 班级
     */
    @ApiModelProperty(value = "班级")
    private String className;
    /**
     * 楼栋
     */
    @ApiModelProperty(value = "楼栋")
    private String buildingId;
    /**
     * 宿舍
     */
    @ApiModelProperty(value = "宿舍")
    private String dormitory;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String status;

    @JsonIgnore
    private String collegeId;
    @JsonIgnore
    private String classId;
    @JsonIgnore
    private String dormitoryId;
}

package com.ahead.smartlock.manage.entity;

import lombok.Data;

/**
 * @author zqh
 */
@Data
public class User {
    /**
     * 用户id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 学号/工号
     */
    private String workId;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 宿舍号
     */
    private String dormitoryId;
    /**
     * 班级号
     */
    private String classId;
    /**
     * 楼栋号
     */
    private String buildingId;
    /**
     * 学院号
     */
    private String collegeId;
    /**
     * 电话号码
     */
    private String telephoneNumber;
    /**
     * 用户类型(0-管理员、1-校领导、2-辅导员、3-宿管、4-维修人员、5-服务商、6-学生)
     */
    private String types;
    /**
     * 服务商姓名
     */
    private String spName;
    /**
     * 优先级
     */
    private String priority;
    /**
     * 用户状态(1-匿名、2-审批中、3-已注册用户)
     */
    private String status;
}

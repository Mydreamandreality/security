package com.mobile.security.model.po.web;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/27 18:17
 * @Version v1.0
 * @Description 告警信息
 */
@Data
@Accessors(chain = true)
@TableName(value = "web_sys_app_alarm")
public class IAlarmPO {

    private Integer id;

    /**
     * 应用id
     */
    private String appKey;

    /**
     * 告警类型 应用漏洞|应用安全
     */
    private String alarmType;

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 网络类型 默认WIFI
     */
    private String networkType;

    /**
     * 请求IP
     */
    private String requestIp;

    /**
     * 地区 默认内网
     */
    private String location;

    /**
     * 域名
     */
    private String domain;

    /**
     * 接口信息
     */
    private String interfaceInfo;

    /**
     * 请求报文
     */
    private String payload;

    /**
     * 事件产生时间
     */
    private Date createTime;

    private String appName;
}

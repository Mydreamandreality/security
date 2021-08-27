package com.mobile.security.model.po.web;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/28 1:19
 * @Version v1.0
 * @Description TODO
 */
@Data
@Accessors(chain = true)
@TableName(value = "web_sys_app_device")
public class IAppDevicePO {

    /**
     * id
     */
    private Integer id;

    private String appKey;

    /**
     * 设备品牌
     */
    private String deviceBrand;

    /**
     * 型号
     */
    private String deviceModel;

    /**
     * 制造商
     */
    private String deviceMade;

    /**
     * 系统版本
     */
    private String sysVersion;

    /**
     * 安卓id
     */
    private String androidId;

    /**
     * mac地址
     */
    private String mac;

    /**
     * sdk版本
     */
    private String sdkVersion;

    /**
     * 运行模式
     */
    private String runtimeModel;

    /**
     * 指令集
     */
    private String instructionSet;

    /**
     * 主板
     */
    private String mainBoard;

    /**
     * 时区
     */
    private String timeZone;

    /**
     * wifi_mac
     */
    private String wifiMac;

    /**
     * 基站编号
     */
    private String baseStation;

    /**
     * 运营商
     */
    private String operator;

    /**
     * 设备形态
     */
    private String deviceForm;

    /**
     * 屏幕分辨率
     */
    private String screenResolution;

    /**
     * 系统名称
     */
    private String sysName;

    /**
     * 系统名称
     */
    private String imei;

    /**
     * imsi
     */
    private String imsi;

    /**
     * 蓝牙mac
     */
    private String bluetoothMac;

    /**
     * 序列号
     */
    private String serialNumber;

    /**
     * 硬件名称
     */
    private String hardwareName;

    /**
     * 指令集2
     */
    private String instructionSetTwo;

    /**
     * build_date
     */
    private String buildDate;

    /**
     * 经纬度
     */
    private String isLong;

    /**
     * 基站位置区域码
     */
    private String baseStationCode;

    /**
     * 附近基站数量
     */
    private Integer baseStationNumber;

    /**
     * 业务使用
     */
    private Integer count;
}

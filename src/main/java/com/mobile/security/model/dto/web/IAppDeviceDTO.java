package com.mobile.security.model.dto.web;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "APP设备登录信息记录DTO", description = "APP设备登录信息请求所需数据")
public class IAppDeviceDTO {

    /**
     * id
     */
    private Integer id;


    private String appKey;

    /**
     * 设备品牌
     */
    @ApiModelProperty(value = "设备品牌")
    private String deviceBrand;

    /**
     * 型号
     */
    @ApiModelProperty(value = "设备型号")
    private String deviceModel;

    /**
     * 制造商
     */
    @ApiModelProperty(value = "制造商")
    private String deviceMade;

    /**
     * 系统版本
     */
    @ApiModelProperty(value = "系统版本")
    private String sysVersion;

    /**
     * 安卓id
     */
    @ApiModelProperty(value = "安卓id")
    private String androidId;

    /**
     * mac地址
     */
    @ApiModelProperty(value = "mac")
    private String mac;

    /**
     * sdk版本
     */
    @ApiModelProperty(value = "sdk版本")
    private String sdkVersion;

    /**
     * 运行模式
     */
    @ApiModelProperty(value = "运行模式")
    private String runtimeModel;

    /**
     * 指令集
     */
    @ApiModelProperty(value = "指令集")
    private String instructionSet;

    /**
     * 主板
     */
    @ApiModelProperty(value = "主板")
    private String mainBoard;

    /**
     * 时区
     */
    @ApiModelProperty(value = "时区")
    private String timeZone;

    /**
     * wifi_mac
     */
    @ApiModelProperty(value = "wifi_mac")
    private String wifiMac;

    /**
     * 基站编号
     */
    @ApiModelProperty(value = "基站编号")
    private String baseStation;

    /**
     * 运营商
     */
    @ApiModelProperty(value = "运营商")
    private String operator;

    /**
     * 设备形态
     */
    @ApiModelProperty(value = "设备形态")
    private String deviceForm;

    /**
     * 屏幕分辨率
     */
    @ApiModelProperty(value = "屏幕分辨率")
    private String screenResolution;

    /**
     * 系统名称
     */
    @ApiModelProperty(value = "系统名称")
    private String sysName;

    /**
     * imei
     */
    @ApiModelProperty(value = "imei")
    private String imei;

    /**
     * imsi
     */
    @ApiModelProperty(value = "imsi")
    private String imsi;

    /**
     * 蓝牙mac
     */
    @ApiModelProperty(value = "蓝牙mac")
    private String bluetoothMac;

    /**
     * 序列号
     */
    @ApiModelProperty(value = "序列号")
    private String serialNumber;

    /**
     * 硬件名称
     */
    @ApiModelProperty(value = "硬件名称")
    private String hardwareName;

    /**
     * 指令集2
     */
    @ApiModelProperty(value = "指令集2")
    private String instructionSetTwo;

    /**
     * build_date
     */
    @ApiModelProperty(value = "build_date")
    private String buildDate;

    /**
     * 经纬度
     */
    @ApiModelProperty(value = "经纬度")
    private String isLong;

    /**
     * 基站位置区域码
     */
    @ApiModelProperty(value = "基站位置区域码")
    private String baseStationCode;

    /**
     * 附近基站数量
     */
    @ApiModelProperty(value = "附近基站数量")
    private Integer baseStationNumber;

}

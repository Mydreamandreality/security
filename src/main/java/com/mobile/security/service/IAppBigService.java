package com.mobile.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/28 23:11
 * @Version v1.0
 * @Description TODO
 */
public interface IAppBigService extends IService<Map> {

    /**
     * 获取大屏展示数据
     * [
     * {
     * "应用漏洞":
     * [
     * {
     * "XSS漏洞" : 11
     * },
     * {
     * "SQL漏洞" : 22
     * }
     * ]
     * },
     * {
     * "应用安全": xxxxxx
     * }
     * ]
     *
     * @return
     */
    Map<String, List<Map<String, Integer>>> getBigData();

    /**
     * 设备统计
     *
     * @return
     */
    Map<String, Integer> getDeviceCount();

    /**
     * 获取漏洞统计
     *
     * @param appKey
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map<String, Integer>> getAlarmCount(String appKey, Date startTime, Date endTime);
}

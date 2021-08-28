package com.mobile.security.mapper.web;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/28 22:58
 * @Version v1.0
 * @Description TODO
 */
@Mapper
public interface IAppBigMapper extends BaseMapper<Map> {

    /**
     * 获取大屏展示数据
     *
     * @param alarmType
     * @return
     */
    List<Map<String, Integer>> getBigData(@Param("alarm_type") String alarmType);

    /**
     * 活跃设备
     *
     * @return
     */
    Integer activeDeviceCount();

    /**
     * 异常设备
     *
     * @return
     */
    Integer alarmDeviceCount();

    /**
     * 漏洞统计
     *
     * @param appKey
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map<String, Integer>> getAlarmCount(@Param("app_key") String appKey,
                                       @Param("start_time") Date startTime,
                                       @Param("end_time") Date endTime);
}

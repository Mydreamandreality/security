package com.mobile.security.mapper.web;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mobile.security.model.po.web.IAlarmPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/27 18:38
 * @Version v1.0
 * @Description TODO
 */
@Mapper
public interface IAlarmMapper extends BaseMapper<IAlarmPO> {

    /**
     * 获取告警列表、自定义请求条件
     *
     * @param alarmType
     * @param appKey
     * @param startTime
     * @param endTime
     * @return
     */
    List<IAlarmPO> getAllAlarmCondition(@Param("alarm_type") String alarmType,
                                        @Param("app_key") String appKey,
                                        @Param("start_time") Date startTime,
                                        @Param("end_time") Date endTime);

    /**
     * 获取告警详情
     *
     * @param id
     * @return
     */
    IAlarmPO getAlarmById(@Param("id") Integer id);
}

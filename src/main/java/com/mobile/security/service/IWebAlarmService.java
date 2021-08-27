package com.mobile.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.mobile.security.model.po.web.IAlarmPO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/27 18:43
 * @Version v1.0
 * @Description TODO
 */
public interface IWebAlarmService extends IService<IAlarmPO> {

    /**
     * 获取告警列表、自定义请求条件
     *
     * @param page_size
     * @param page_num
     * @param alarmType
     * @param appKey
     * @param startTime
     * @param endTime
     * @return
     */
    PageInfo<IAlarmPO> getAllAlarmCondition(Integer page_num, Integer page_size, String alarmType, String appKey, Date startTime, Date endTime);

    /**
     * 获取告警详情
     *
     * @param id
     * @return
     */
    IAlarmPO getAlarmById(Integer id);
}

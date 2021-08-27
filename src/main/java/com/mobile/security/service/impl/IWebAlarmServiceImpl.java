package com.mobile.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mobile.security.mapper.web.IAlarmMapper;
import com.mobile.security.model.po.web.IAlarmPO;
import com.mobile.security.service.IWebAlarmService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description TODO
 */
@Service
public class IWebAlarmServiceImpl extends ServiceImpl<IAlarmMapper, IAlarmPO> implements IWebAlarmService {
    @Override
    public PageInfo<IAlarmPO> getAllAlarmCondition(Integer page_num, Integer page_size, String alarmType, String appKey, Date startTime, Date endTime) {
        PageHelper.startPage(page_num, page_size);
        List<IAlarmPO> alarmPOS = baseMapper.getAllAlarmCondition(alarmType, appKey, startTime, endTime);
        return new PageInfo<>(alarmPOS);
    }

    @Override
    public IAlarmPO getAlarmById(Integer id) {
        return baseMapper.getAlarmById(id);
    }
}

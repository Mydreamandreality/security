package com.mobile.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableMap;
import com.mobile.security.mapper.app.IAppMapper;
import com.mobile.security.model.dto.app.IAppAlarmDto;
import com.mobile.security.model.po.app.IAppAlarmPO;
import com.mobile.security.service.IAppAlarmService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/27 20:23
 * @Version v1.0
 * @Description TODO
 */
@Service
public class IAppAlarmServiceImpl extends ServiceImpl<IAppMapper, IAppAlarmPO> implements IAppAlarmService {

    @Override
    public Boolean recordAppSecurity(IAppAlarmDto alarmDto) {
        String alarmType = "";
        switch (alarmDto.getEventType()) {
            case "SQL注入":
            case "XSS注入":
            case "信息泄露":
            case "越权漏洞":
                alarmType = "应用漏洞";
                break;
            case "应用安全":
                alarmType = "应用安全";
                break;
            default:
                alarmType = "未知";
                break;
        }
        ImmutableMap<String, String> immutableMap = ImmutableMap.<String, String>builder().
                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif").
                put("Accept-Encoding", "gzip, deflate").
                put("Accept-Language", "zh-CN,zh;q=0.9,zh-TW;q=0.8,en-US;q=0.7,en;q=0.6").
                put("Cache-Control", "max-age=0").
                build();

        IAppAlarmPO alarmPO = new IAppAlarmPO().
                setAlarmType(alarmType).
                setNetworkType("WIFI").
                setLocation("内网").
                setDomain("http://estest.com").
                setInterfaceInfo("http://estest.com/search.detail").
                setPayload(immutableMap.toString()).
                setCreateTime(new Date());

        BeanUtils.copyProperties(alarmDto, alarmPO);
        baseMapper.recordAppSecurityAlarm(alarmPO);
        return Boolean.TRUE;
    }
}

package com.mobile.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mobile.security.mapper.web.IAppBigMapper;
import com.mobile.security.service.IAppBigService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/28 23:13
 * @Version v1.0
 * @Description TODO
 */
@Service
public class IAppBigServiceImpl extends ServiceImpl<IAppBigMapper, Map> implements IAppBigService {
    @Override
    public Map<String, List<Map<String, Integer>>> getBigData() {
        List<Map<String, Integer>> loophole = baseMapper.getBigData("应用漏洞");

        List<Map<String, Integer>> security = baseMapper.getBigData("应用安全");

        Map<String, List<Map<String, Integer>>> loopholeResult = new HashMap<>(1);
        loopholeResult.put("应用漏洞", loophole);

        Map<String, List<Map<String, Integer>>> securityResult = new HashMap<>(1);
        loopholeResult.put("应用安全", security);

        Map<String, List<Map<String, Integer>>> result = new HashMap<>();
        result.putAll(loopholeResult);
        result.putAll(securityResult);
        return result;
    }

    @Override
    public Map<String, Integer> getDeviceCount() {
        Integer active = baseMapper.activeDeviceCount();
        Integer alarm = baseMapper.alarmDeviceCount();
        ImmutableMap<String, Integer> result = ImmutableMap.<String, Integer>builder().
                put("异常设备数", alarm).
                put("活跃设备数", active).build();
        return result;
    }

    @Override
    public List<Map<String, Integer>> getAlarmCount(String appKey, Date startTime, Date endTime) {
        return baseMapper.getAlarmCount(appKey, startTime, endTime);
    }
}

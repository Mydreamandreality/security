package com.mobile.security.mapper.app;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mobile.security.model.po.app.IAppAlarmPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/27 19:51
 * @Version v1.0
 * @Description TODO
 */
@Mapper
public interface IAppMapper extends BaseMapper<IAppAlarmPO> {

    /**
     * 记录APP告警信息
     *
     * @param appPO
     */
    void recordAppSecurityAlarm(IAppAlarmPO appPO);
}

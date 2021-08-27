package com.mobile.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mobile.security.model.dto.app.IAppAlarmDto;
import com.mobile.security.model.po.app.IAppAlarmPO;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/27 20:21
 * @Version v1.0
 * @Description TODO
 */
public interface IAppAlarmService extends IService<IAppAlarmPO> {

    /**
     * 新增应用漏洞信息
     *
     * @param alarmPO
     * @return Boolean
     */
    Boolean recordAppSecurity(IAppAlarmDto alarmPO);
}

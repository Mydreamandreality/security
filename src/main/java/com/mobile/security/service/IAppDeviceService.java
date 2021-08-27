package com.mobile.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mobile.security.model.dto.web.IAppDeviceDTO;
import com.mobile.security.model.po.web.IAppDevicePO;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/28 1:29
 * @Version v1.0
 * @Description TODO
 */
public interface IAppDeviceService extends IService<IAppDevicePO> {

    /**
     * 获取app登录者详细信息
     *
     * @param appKey
     * @return
     */
    IAppDevicePO getAppDetailByAppKey(String appKey);

    /**
     * 记录登录app用户设备信息
     *
     * @param appDeviceDTO
     * @return
     */
    Boolean recordAppDetail(IAppDeviceDTO appDeviceDTO);
}

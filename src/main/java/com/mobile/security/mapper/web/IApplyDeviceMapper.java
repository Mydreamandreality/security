package com.mobile.security.mapper.web;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mobile.security.model.po.web.IAppDevicePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/28 1:25
 * @Version v1.0
 * @Description TODO
 */
@Mapper
public interface IApplyDeviceMapper extends BaseMapper<IAppDevicePO> {

    /**
     * 获取app登录者详细信息
     *
     * @param appKey
     * @return
     */
    IAppDevicePO getAppDetailByAppKey(@Param("app_key") String appKey);

    /**
     * 记录登录app用户设备信息
     *
     * @param appDetailPO
     */
    void recordAppDetail(IAppDevicePO appDetailPO);
}

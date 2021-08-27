package com.mobile.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobile.security.mapper.web.IApplyDeviceMapper;
import com.mobile.security.model.dto.web.IAppDeviceDTO;
import com.mobile.security.model.po.web.IAppDevicePO;
import com.mobile.security.service.IAppDeviceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/28 1:37
 * @Version v1.0
 * @Description TODO
 */
@Service
public class IAppDeviceServiceImpl extends ServiceImpl<IApplyDeviceMapper, IAppDevicePO> implements IAppDeviceService {


    @Override
    public IAppDevicePO getAppDetailByAppKey(String appKey) {
        return baseMapper.getAppDetailByAppKey(appKey);
    }

    @Override
    public Boolean recordAppDetail(IAppDeviceDTO appDeviceDTO) {
        IAppDevicePO appDevicePO = new IAppDevicePO();
        BeanUtils.copyProperties(appDeviceDTO, appDevicePO);
        baseMapper.recordAppDetail(appDevicePO);
        return Boolean.TRUE;
    }
}

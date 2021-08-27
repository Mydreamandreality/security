package com.mobile.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mobile.security.mapper.web.IApplyMapper;
import com.mobile.security.model.dto.web.IAppDTO;
import com.mobile.security.model.po.web.IAppManagerPO;
import com.mobile.security.service.IWebAppService;
import org.springframework.beans.BeanUtils;
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
public class IWebAppServiceImpl extends ServiceImpl<IApplyMapper, IAppManagerPO> implements IWebAppService {

    @Override
    public PageInfo<IAppManagerPO> getAllApp(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<IAppManagerPO> getAppList = baseMapper.getAllApp();
        return new PageInfo<>(getAppList);
    }

    @Override
    public Boolean addAppInfo(IAppDTO appDTO) {
        IAppManagerPO appPO = new IAppManagerPO().setCreateTime(new Date());
        BeanUtils.copyProperties(appDTO, appPO);
        baseMapper.addAppInfo(appPO);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteAppInfo(String appKey) {
        baseMapper.deleteAppInfo(appKey);
        return Boolean.TRUE;
    }
}

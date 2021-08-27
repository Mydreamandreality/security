package com.mobile.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.mobile.security.model.dto.web.IAppDTO;
import com.mobile.security.model.po.web.IAppManagerPO;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/25 18:08
 * @Version v1.0
 * @Description TODO
 */
public interface IWebAppService extends IService<IAppManagerPO> {

    /**
     * 分页获取所有app信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<IAppManagerPO> getAllApp(Integer pageNum, Integer pageSize);


    /**
     * 添加应用信息
     *
     * @param appDTO
     * @return
     */
    Boolean addAppInfo(IAppDTO appDTO);

    /**
     * 删除应用(包括业务数据)
     *
     * @param appKey
     * @return
     */
    Boolean deleteAppInfo(String appKey);
}

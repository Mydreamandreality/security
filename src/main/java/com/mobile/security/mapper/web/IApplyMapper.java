package com.mobile.security.mapper.web;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mobile.security.model.po.web.IAppManagerPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/25 18:00
 * @Version v1.0
 * @Description 应用管理
 */
@Mapper
public interface IApplyMapper extends BaseMapper<IAppManagerPO> {

    /**
     * 获取所有应用列表
     *
     * @return
     */
    List<IAppManagerPO> getAllApp();

    /**
     * 添加应用
     *
     * @param appManagerPO
     */
    void addAppInfo(IAppManagerPO appManagerPO);

    /**
     * 删除应用(包括业务数据)
     *
     * @param appKey
     */
    void deleteAppInfo(@Param("app_key") String appKey);
}

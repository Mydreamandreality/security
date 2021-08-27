package com.mobile.security.mapper.web;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mobile.security.model.po.web.IUserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description TODO
 */
@Mapper
public interface IUserMapper extends BaseMapper<IUserPO> {

    /**
     * 获取所有用户信息
     *
     * @return
     */
    List<IUserPO> getAllUser(@Param("id") Integer id);

    /**
     * 获取用户信息-ByID
     *
     * @param id
     * @return
     */
    IUserPO getUserById(@Param("id") Integer id);

    /**
     * 删除用户
     *
     * @param id
     */
    void removeUserById(@Param("id") Integer id);

    /**
     * 创建用户
     *
     * @param IUserPO
     */
    void createUser(IUserPO IUserPO);

    /**
     * 通过邮箱检查用户是否存在
     *
     * @param email
     * @return
     */
    IUserPO getUserByEmail(@Param("username") String username, @Param("email") String email);

    /**
     * 登录验证接口
     *
     * @param username
     * @param password
     * @return
     */
    IUserPO getUserByNameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 更新用户信息
     *
     * @param userPO
     */
    void UpdateUserById(IUserPO userPO);
}

package com.mobile.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.mobile.security.model.dto.web.IPwdDTO;
import com.mobile.security.model.dto.web.IUserDTO;
import com.mobile.security.model.po.web.IUserPO;
import com.mobile.security.model.vo.web.IUserVO;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description TODO
 */
public interface IWebUserService extends IService<IUserPO> {

    /**
     * 获取所有用户
     *
     * @return
     */
    PageInfo<IUserPO> getAllUser(Integer pageNum, Integer pageSize);

    /**
     * 通过id获取用户信息
     * @param pwdDTO
     * @return
     */
    Boolean changePassword(IPwdDTO pwdDTO);

    /**
     * 通过邮箱获取用户
     *
     * @param email
     * @param username
     * @return true 存在
     */
    Boolean CheckTheNameAndEmailAlreadyExist(String username, String email);

    /**
     * 登录信息是否正确检查
     *
     * @param username
     * @param password
     * @return true 正确
     */
    IUserVO loginInfoIsItCorrect(String username, String password);

    /**
     * 删除用户
     *
     * @param id
     */
    void removeUserById(Integer id);

    /**
     * 创建用户
     *
     * @param userDTO
     */
    void createUser(IUserDTO userDTO);
}

package com.mobile.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mobile.security.base.IException;
import com.mobile.security.base.constants.SysConst;
import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import com.mobile.security.mapper.web.IUserMapper;
import com.mobile.security.model.dto.web.IPwdDTO;
import com.mobile.security.model.dto.web.IUserDTO;
import com.mobile.security.model.po.web.IUserPO;
import com.mobile.security.model.vo.web.IUserVO;
import com.mobile.security.service.IWebUserService;
import com.mobile.security.utils.ToolUtils;
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
public class IWebUserServiceImpl extends ServiceImpl<IUserMapper, IUserPO> implements IWebUserService {

    @Override
    public PageInfo<IUserPO> getAllUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<IUserPO> IUserPOList = baseMapper.getAllUser(null);
        return new PageInfo<>(IUserPOList);
    }

    @Override
    public Boolean changePassword(IPwdDTO pwdDTO) {
        IUserPO userPO = baseMapper.getUserById(pwdDTO.getId());
        if (ToolUtils.isEmpty(userPO)) {
            throw new IException(GeekExceptionMsg.REMOVE_EMPTY_USER);
        }
        if (!ToolUtils.equals(userPO.getPassword(), pwdDTO.getOldPassword())) {
            throw new IException(GeekExceptionMsg.OLD_PWD_WRONG);
        }
        if (!ToolUtils.equals(pwdDTO.getNewPassword(), pwdDTO.getConfirmNewPassword())) {
            throw new IException(GeekExceptionMsg.TWO_PWD_WRONG);
        }
        userPO.setPassword(pwdDTO.getConfirmNewPassword());
        baseMapper.UpdateUserById(userPO);
        return Boolean.TRUE;
    }

    @Override
    public Boolean CheckTheNameAndEmailAlreadyExist(String username, String email) {
        if (ToolUtils.isNotEmpty(username)) {
            return ToolUtils.isEmpty(baseMapper.getUserByEmail(username, null)) ? false : true;
        }
        if (ToolUtils.isNotEmpty(email)) {
            return ToolUtils.isEmpty(baseMapper.getUserByEmail(null, email)) ? false : true;
        }
        return Boolean.FALSE;
    }

    @Override
    public IUserVO loginInfoIsItCorrect(String username, String password) {
        IUserPO userPO = baseMapper.getUserByNameAndPwd(username, password);
        IUserVO userVO = new IUserVO();
        if (ToolUtils.isEmpty(userPO)) {
            userVO.setId(0);
            return userVO;
        }
        BeanUtils.copyProperties(userPO, userVO);
        return userVO;
    }

    @Override
    public void removeUserById(Integer id) {
        List<IUserPO> poList = baseMapper.getAllUser(id);
        if (ToolUtils.isEmpty(poList)) {
            throw new IException(GeekExceptionMsg.REMOVE_EMPTY_USER);
        }
        if (ToolUtils.equals(poList.get(0).getRole(), SysConst.SYS_ROLE)) {
            throw new IException(GeekExceptionMsg.REMOVE_SYS_USER);
        }
        baseMapper.removeUserById(id);
    }

    @Override
    public void createUser(IUserDTO userDTO) {
        // 检查邮箱是否唯一
        // 检查两次密码是否一致
        if (!ToolUtils.equals(userDTO.getPassword(), userDTO.getConfirmPassword())) {
            throw new IException(GeekExceptionMsg.PASSWORD_WRONG);
        }
        if (this.CheckTheNameAndEmailAlreadyExist(null, userDTO.getEmail())) {
            throw new IException(GeekExceptionMsg.EMAIL_EXIST);
        }
        if (this.CheckTheNameAndEmailAlreadyExist(userDTO.getUsername(), null)) {
            throw new IException(GeekExceptionMsg.USERNAME_EXIST);
        }
        IUserPO IUserPO = new IUserPO().setRole(SysConst.OPERATION_ROLE).setCreateTime(new Date());
        BeanUtils.copyProperties(userDTO, IUserPO);
        baseMapper.createUser(IUserPO);
    }
}

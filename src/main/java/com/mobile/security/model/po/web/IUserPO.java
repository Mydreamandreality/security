package com.mobile.security.model.po.web;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/24 16:21
 * @Version v1.0
 * @Description TODO
 */
@Data
@Accessors(chain = true)
@TableName(value = "web_sys_user")
public class IUserPO {

    private Integer id;

    private String username;

    private String email;

    private String password;

    private String role;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}

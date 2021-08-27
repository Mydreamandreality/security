package com.mobile.security.model.po.web;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description TODO
 */
@Data
@Accessors(chain = true)
@TableName(value = "web_sys_app")
public class IAppManagerPO {

    private Integer id;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用标识
     */
    private String appKey;

    /**
     * 联系人
     */
    private String person;

    private Date createTime;
}

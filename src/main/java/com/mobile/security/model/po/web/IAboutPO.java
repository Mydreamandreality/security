package com.mobile.security.model.po.web;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description 关于我们
 */
@Data
@Accessors(chain = true)
public class IAboutPO {

    private Integer id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品版本
     */
    private String productVersion;

    /**
     * 产品简介
     */
    private String productIntroduction;
}

package com.mobile.security.model.dto.app;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/27 18:17
 * @Version v1.0
 * @Description 告警信息
 */
@Data
@Accessors(chain = true)
public class IAppAlarmDto {

    /**
     * 事件类型
     */
    @NotBlank(message = "事件类型为必填项")
    private String eventType;

    /**
     * 应用id
     */
    private String appKey;

    /**
     * 请求IP
     */
    private String requestIp;

}

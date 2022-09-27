package com.repeatsubmit.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置类
 *
 * @author repeatsubmit
 */
@ConfigurationProperties(prefix = "repeatsubmit")
public class RepeatSubmitProperties {

    private boolean enable = true;

    private static Long expireTime = 5L;

    public static Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        RepeatSubmitProperties.expireTime = expireTime;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}

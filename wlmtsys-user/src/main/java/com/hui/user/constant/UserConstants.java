package com.hui.user.constant;

import java.time.Duration;

public interface UserConstants {
    String DEFAULT_PASSWORD = "123456";

    Long INTERNAL_USER_ID = 2L;
    String INTERNAL_ROLE_NAME = "内部用户";

    Long EXTERNAL_USER_ID = 3L;
    String EXTERNAL_ROLE_NAME = "外部用户";

    // 验证码的Redis key前缀
    String USER_VERIFY_CODE_KEY = "sms:user:code:phone:";
    // 验证码有效期，5分钟
    Duration USER_VERIFY_CODE_TTL = Duration.ofMinutes(5);
}

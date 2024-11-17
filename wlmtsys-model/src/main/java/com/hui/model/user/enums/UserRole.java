package com.hui.model.user.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

import com.hui.common.constants.ErrorInfo;
import com.hui.common.exceptions.BadRequestException;
import lombok.Getter;

@Getter
public enum UserRole {
    INTERNAL(2, "internal"),
    EXTERNAL(3, "external"),
    ;
    @EnumValue
    int value;
    String desc;

    UserRole(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static UserRole of(int value) {
        if (value == 2) {
            return INTERNAL;
        }
        if (value == 3) {
            return EXTERNAL;
        }
        throw new BadRequestException(ErrorInfo.Msg.INVALID_USER_TYPE);
    }
}
package com.hui.model.user.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

import com.hui.common.constants.ErrorInfo;
import com.hui.common.enums.BaseEnum;
import com.hui.common.exceptions.BadRequestException;
import lombok.Getter;

@Getter
public enum UserType implements BaseEnum {
//    用户类型：1-内部人员, 2-外部人员，3-管理员
    STAFF(3, "其他员工"),
    INTERNAL_USER(1, "内部人员"),
    EXTERNAL_USER(2, "外部人员"),
    ;
    @EnumValue
    int value;
    String desc;

    UserType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static UserType of(int value) {
        for (UserType type : UserType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new BadRequestException(ErrorInfo.Msg.INVALID_USER_TYPE);
    }
}

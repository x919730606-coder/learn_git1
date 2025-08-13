package com.bjpowernode.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public enum DicEnum {
    APPELLATION("appellation"),
    SOURCE("source"),
    STATE("clueState"),
    INTENTION_STATE("intentionState"),
    INTENTION_PRODUCT("intentionProduct"),
    NEED_LOAN("needLoan");

    @Setter
    @Getter
    private String code;
}

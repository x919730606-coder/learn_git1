package com.bjpowernode.service;

import com.bjpowernode.entity.TDicValue;

import java.util.List;

public interface DicValueService {
    List<TDicValue> getDicValueByTypeCode(String typeCode);
}

package com.bjpowernode.service.impl;

import com.bjpowernode.entity.TDicValue;
import com.bjpowernode.mapper.TDicTypeMapper;
import com.bjpowernode.mapper.TDicValueMapper;
import com.bjpowernode.service.DicValueService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicValueServiceImpl implements DicValueService {

    @Resource
    private TDicValueMapper dicValueMapper;

    @Override
    public List<TDicValue> getDicValueByTypeCode(String typeCode) {
        return dicValueMapper.getDicValueByTypeCode(typeCode);
    }
}

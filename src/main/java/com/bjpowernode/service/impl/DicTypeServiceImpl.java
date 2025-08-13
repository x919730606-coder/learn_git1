package com.bjpowernode.service.impl;

import com.bjpowernode.entity.TDicType;
import com.bjpowernode.entity.TDicValue;
import com.bjpowernode.mapper.TDicTypeMapper;
import com.bjpowernode.service.DicTypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicTypeServiceImpl implements DicTypeService {
    @Resource
    private TDicTypeMapper dicTypeMapper;
    @Override
    public List<TDicType> getDicType() {
        return dicTypeMapper.getDicTypes();
    }

    @Override
    public List<TDicValue> getDicValueByTypeCode(String typeCode) {
        return dicTypeMapper.getDicValueByTypeCode(typeCode);
    }
}

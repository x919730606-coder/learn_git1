package com.bjpowernode.service.impl;

import com.bjpowernode.entity.TProduct;
import com.bjpowernode.mapper.TProductMapper;
import com.bjpowernode.service.ProDuctService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProDuctServiceImpl implements ProDuctService {
    @Resource
    private TProductMapper tProductMapper;
    @Override
    public List<TProduct> getProduct() {
        return tProductMapper.selectProducts();
    }
}

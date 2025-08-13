package com.bjpowernode.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.bjpowernode.DlykServerApplication;
import com.bjpowernode.constant.DicEnum;
import com.bjpowernode.entity.TDicValue;

import java.util.List;

public class AppellationConverter implements Converter<Integer> {
    @Override
    public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String appellation = cellData.getStringValue();
        List<TDicValue> tDicValues = (List<TDicValue>) DlykServerApplication.cacheMap.get(DicEnum.APPELLATION.getCode());
        for (TDicValue tDicValue : tDicValues){
            Integer id = tDicValue.getId();
            String typeValue = tDicValue.getTypeValue();
            if (appellation.equals(typeValue)){
                return id;
            }
        }
        return tDicValues.get(0).getId();
    }
}

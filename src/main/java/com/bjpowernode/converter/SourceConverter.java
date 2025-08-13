package com.bjpowernode.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.bjpowernode.DlykServerApplication;
import com.bjpowernode.constant.DicEnum;
import com.bjpowernode.entity.TDicValue;

import java.util.List;

public class SourceConverter implements Converter<Integer> {
    @Override
    public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String excelValue = cellData.getStringValue(); //读取到的Excel单元格的数据
        //转成java中的Integer
        List<TDicValue> tDicValueList =  (List<TDicValue>) DlykServerApplication.cacheMap.get(DicEnum.SOURCE.getCode());
        for (TDicValue tDicValue : tDicValueList) {
            Integer id = tDicValue.getId();
            String typeValue = tDicValue.getTypeValue();
            if (excelValue.equals(typeValue)) {
                return id;
            }
        }
        return tDicValueList.get(0).getId();
    }
}

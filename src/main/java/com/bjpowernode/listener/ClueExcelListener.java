package com.bjpowernode.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.bjpowernode.mapper.TClueMapper;
import com.bjpowernode.query.ClueExcel;
import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ClueExcelListener implements ReadListener<ClueExcel> {
    private static final int BATCH_COUNT = 100;
    public List<ClueExcel> clueDataList = new ArrayList<>(BATCH_COUNT);

    private TClueMapper clueMapper;
    private Integer loginUserId;
    public ClueExcelListener(TClueMapper clueMapper, Integer loginUserId) {
        this.clueMapper = clueMapper;
        this.loginUserId = loginUserId;
    }

    @Override
    public void invoke(ClueExcel data, AnalysisContext analysisContext) {
        data.setCreateBy(loginUserId);
        data.setCreateTime(new Date());
        clueDataList.add(data);
        if (clueDataList.size() >= BATCH_COUNT) {
            clueMapper.saveExcel(clueDataList);
            clueDataList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        clueMapper.saveExcel(clueDataList);
    }
}

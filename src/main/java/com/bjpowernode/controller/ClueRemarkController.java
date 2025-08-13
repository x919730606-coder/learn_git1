package com.bjpowernode.controller;

import com.bjpowernode.constant.Constant;
import com.bjpowernode.entity.TClue;
import com.bjpowernode.query.ClueRemarkQuery;
import com.bjpowernode.result.Result;
import com.bjpowernode.service.ClueRemarkService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClueRemarkController {

    @Resource
    private ClueRemarkService clueRemarkService;

    @PostMapping("/api/clue/remark")
    public Result addClueRemark(@RequestBody ClueRemarkQuery clueRemarkQuery) {
        int num = clueRemarkService.saveClueRemark(clueRemarkQuery);
        return num > 0 ? Result.OK() : Result.FAIL();
    }

    @GetMapping("api/clue/{clueId}/remark")
    public Result getClueRemarkByPage(@PathVariable Integer clueId, Integer current){
        PageInfo<TClue> pageInfo = clueRemarkService.getClueRemarkByPage(current,clueId);
        return Result.OK(pageInfo);
    }
}

package com.bjpowernode.controller;


import com.bjpowernode.entity.TClue;
import com.bjpowernode.result.Result;
import com.bjpowernode.service.ClueService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ClueController {

    @Resource
    private ClueService clueService;

    @GetMapping("/api/clues")
    public Result getClueByPage(Integer num){
        PageInfo<TClue> clues = clueService.getClueByPage(num);
        return Result.OK(clues);
    }

    @PostMapping("/api/importExcel")
    public Result importExcel(@RequestParam("excelFile") MultipartFile excelFile) throws IOException {
        clueService.importExcel(excelFile.getInputStream());
        System.out.println(Result.OK());
        return Result.OK();
    }

    @GetMapping("/api/clue/{id}")
    public Result getClueById(@PathVariable("id") Integer id){
        TClue clue = clueService.getClueById(id);
        return Result.OK(clue);
    }
}


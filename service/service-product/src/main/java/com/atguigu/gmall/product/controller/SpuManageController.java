package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.ManageService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/product")
public class SpuManageController {
    @Autowired
    ManageService manageService;

    @GetMapping("${page}/${limit}")
    public Result getSpuInfoList(@PathVariable Long page, @PathVariable Long limit, @RequestBody SpuInfo spuInfo) {
        Page<SpuInfo> spuInfoPage = new Page(page, limit);
        IPage<SpuInfo> iPage = manageService.getSpuInfoList(spuInfoPage, spuInfo);
        return Result.ok(iPage);
    }
}

package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.*;
import com.atguigu.gmall.product.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mqx
 * @date 2021-4-10 11:45:11
 */
@RestController
@RequestMapping("admin/product")
public class BaseManageController {
    //  控制器：注入服务层
    @Autowired
    private ManageService manageService;

    //  查询所有的一级分类数据
    //  http://api.gmall.com/admin/product/getCategory1
    @GetMapping("getCategory1")
    public Result getCategory1(){
        //  返回数据
        List<BaseCategory1> baseCategory1List = manageService.getBaseCategory1();
        return Result.ok(baseCategory1List);
    }

    //  根据一级分类Id 查询二级分类数据
    //  http://api.gmall.com/admin/product/getCategory2/{category1Id}
    @GetMapping("getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable Long category1Id){
        //  返回数据
        List<BaseCategory2> baseCategory2List = manageService.getBaseCategory2(category1Id);
        return Result.ok(baseCategory2List);
    }

    //  根据二级分类Id 查询三级分类数据
    //  http://api.gmall.com/admin/product/getCategory3/{category2Id}
    @GetMapping("getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable Long category2Id){
        //  返回数据
        List<BaseCategory3> baseCategory3List = manageService.getBaseCategory3(category2Id);
        return Result.ok(baseCategory3List);
    }

    //  根据分类Id 查询平台属性集合
    //  http://api.gmall.com/admin/product/attrInfoList/{category1Id}/{category2Id}/{category3Id}
    @GetMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable Long category1Id ,
                               @PathVariable Long category2Id ,
                               @PathVariable Long category3Id ){
        //  返回数据
        return Result.ok(manageService.getBaseAttrInfoList(category1Id,category2Id,category3Id));
    }
    @PostMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
        manageService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }
}

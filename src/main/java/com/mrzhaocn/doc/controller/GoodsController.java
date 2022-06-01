package com.mrzhaocn.doc.controller;

import com.mrzhaocn.doc.entity.GoodsDo;
import com.mrzhaocn.doc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods/{id}")
    public GoodsDo getOne(@PathVariable("id") long id) {
        return goodsService.getById(id);
    }

    @PostMapping("/goods")
    public void add(@RequestBody GoodsDo goods) {
        goodsService.add(goods);
    }

    @PutMapping("/goods/{id}")
    public void update(@PathVariable("id") long id, @RequestBody GoodsDo goods) {
        goods.setId(id);
        goodsService.edit(goods);
    }

    @DeleteMapping("/goods/{id}")
    public void delete(@PathVariable("id") long id) {
        goodsService.remove(id);
    }
}

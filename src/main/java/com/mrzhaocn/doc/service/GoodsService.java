package com.mrzhaocn.doc.service;

import com.mrzhaocn.doc.entity.GoodsDao;
import com.mrzhaocn.doc.entity.GoodsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务
 */
@Service // 注册为服务类
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public void add(GoodsDo goods) {

    }

    public void remove(Long id) {

    }

    public void  edit(GoodsDo goods) {

    }

}

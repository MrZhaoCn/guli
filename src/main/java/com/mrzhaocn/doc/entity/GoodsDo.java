package com.mrzhaocn.doc.entity;

import lombok.Data;

@Data
/**
 * 商品类
 */
public class GoodsDo {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品库存
     */
    private Long num;

}


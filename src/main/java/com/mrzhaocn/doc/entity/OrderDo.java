package com.mrzhaocn.doc.entity;

import lombok.Data;

/**
 * 订单类
 */
@Data
public class OrderDo {
    /**
     * 订单id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 购买数量
     */
    private Long count;
    // 省略 get set
}

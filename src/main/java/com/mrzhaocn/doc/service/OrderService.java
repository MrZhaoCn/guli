package com.mrzhaocn.doc.service;

import com.mrzhaocn.doc.entity.GoodsDao;
import com.mrzhaocn.doc.entity.GoodsDo;
import com.mrzhaocn.doc.entity.OrderDao;
import com.mrzhaocn.doc.entity.OrderDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private OrderDao orderDao;

    @Transactional(rollbackFor = Exception.class)
    public int createrOrder(Long goodsId, Long count) {
        // 锁定商品库存
        GoodsDo goods = goodsDao.selectForUpdate(goodsId);
        // 扣减库存
        Long newNum = goods.getNum() - count;
        goods.setNum(newNum);
        goodsDao.update(goods);

        // 生成订单
        OrderDo orderDo = new OrderDo();
        orderDo.setGoodsId(goodsId);
        orderDo.setCount(count);
        int affectRows = orderDao.insert(orderDo);
        return  affectRows;
    }

}

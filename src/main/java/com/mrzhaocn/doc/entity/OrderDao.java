package com.mrzhaocn.doc.entity;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    public int insert(OrderDo order);
}

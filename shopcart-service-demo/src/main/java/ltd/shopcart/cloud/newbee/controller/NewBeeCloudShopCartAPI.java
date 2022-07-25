/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2022 程序员十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.shopcart.cloud.newbee.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBeeCloudShopCartAPI {

    @Value("${server.port}")
    private String applicationServerPort;// 读取当前应用的启动端口

    @GetMapping("/shop-cart/{cartId}")
    public String cartItemDetail(@PathVariable("cartId") int cartId) {
        // 根据id查询商品并返回给调用端
        if (cartId < 0 || cartId > 100000) {
            return "查询购物项为空，当前服务的端口号为" + applicationServerPort;
        }
        String cartItem = "购物项" + cartId;
        // 返回信息给调用端
        return cartItem + "，当前服务的端口号为" + applicationServerPort;
    }

    @GetMapping("/shop-cart/page/{pageNum}")
    public String cartItemList(@PathVariable("pageNum") int pageNum) throws InterruptedException {
        // 返回信息给调用端
        return "请求cartItemList，当前服务的端口号为" + applicationServerPort;
    }
}
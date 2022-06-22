/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2022 程序员十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.order.cloud.newbee.controller;

import ltd.order.cloud.newbee.openfegin.NewBeeGoodsDemoService;
import ltd.order.cloud.newbee.openfegin.NewBeeShopCartDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NewBeeCloudOrderAPI {

//    @Resource
//    private RestTemplate restTemplate;

    @Resource
    private NewBeeGoodsDemoService newBeeGoodsDemoService;

    @Resource
    private NewBeeShopCartDemoService newBeeShopCartDemoService;

    // 商品服务调用地址
//    private final String CLOUD_GOODS_SERVICE_URL = "http://newbee-cloud-goods-service";
//
//    // 购物车服务调用地址
//    private final String CLOUD_SHOPCART_SERVICE_URL = "http://newbee-cloud-shopcart-service";

    @GetMapping("/order/saveOrder")
    public String saveOrder(@RequestParam("cartId") int cartId, @RequestParam("goodsId") int goodsId) {
        // 简单的模拟下单流程，包括服务间的调用流程。后续openfeign相关的改造和优化将基于当前项目进行改造。

//        // 调用商品服务
//        String goodsResult = restTemplate.getForObject(CLOUD_GOODS_SERVICE_URL + "/goods/" + goodsId, String.class);
//
//        // 调用购物车服务
//        String cartResult = restTemplate.getForObject(CLOUD_SHOPCART_SERVICE_URL + "/shop-cart/" + cartId, String.class);
// 调用商品服务
        String goodsResult = newBeeGoodsDemoService.getGoodsDetail(goodsId);

        // 调用购物车服务
        String cartResult = newBeeShopCartDemoService.getCartItemDetail(cartId);
        // 执行下单逻辑

        return "success! goodsResult={" + goodsResult + "},cartResult={" + cartResult + "}";
    }
}
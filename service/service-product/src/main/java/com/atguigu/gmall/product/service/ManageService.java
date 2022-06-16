package com.atguigu.gmall.product.service;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.gmall.model.product.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author mqx
 * @date 2021-4-10 10:24:49
 */
public interface ManageService {

   /*
        3.1	先加载所有的一级分类数据！

		3.2	通过选择一级分类Id数据加载二级分类数据！

		3.3	通过选择二级分类数据加载三级分类数据！

		3.4	根据分类Id 加载 平台属性列表！
    */

    /**
     * 获取所有一级分类数据
      * @return
     */
   List<BaseCategory1> getBaseCategory1();

    /**
     * 根据一级分类Id ，获取二级分类数据
     * @param category1Id
     * @return
     */
   List<BaseCategory2> getBaseCategory2(Long category1Id);

    /**
     * 根据二级分类Id ，获取三级分类数据
     * @param category2Id
     * @return
     */
    List<BaseCategory3> getBaseCategory3(Long category2Id);

    /**
     * 根据分类Id 获取平台属性列表
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> getBaseAttrInfoList(Long category1Id,Long category2Id,Long category3Id);

}

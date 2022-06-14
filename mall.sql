use mall;
CREATE TABLE `activity_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(255),
  `activity_type` varchar(255),
  `activity_desc` varchar(255),
  `start_time` DATETIME,
  `end_time` DATETIME,
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `activity_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20),
  `condition_amount` DECIMAL,
  `condition_num` bigint(20),
  `benefit_amount` DECIMAL,
  `benefit_discount` DECIMAL,
  `benefit_level` bigint(20),
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `activity_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20),
  `sku_id` bigint(20),
  `start_time` DATETIME NOT NULL DEFAULT NOW(), 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `coupon_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `condition_amount` DECIMAL,
  `coupon_type` varchar(255),
  `coupon_name` varchar(255),
  `condition_num` bigint(20),
  `activity_id` bigint(20),
  `benefit_amount` DECIMAL ,
  `benefit_discount` DECIMAL,
  `range_type` varchar(255),
  `limit_num` bigint(20),
  `taken_count` bigint(20),
  `start_time` DATETIME ,
  `end_time` DATETIME,
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
  `operate_time` DATETIME,
  `expire_time` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `coupon_range` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_id` bigint(20),
  `range_type` varchar(255),
  `range_id` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `coupon_use` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_id` bigint(20),
  `user_id` bigint(20),
  `order_id` bigint(20),
  `coupon_status` varchar(255),
  `get_time` DATETIME,
  `using_time` DATETIME ,
  `used_time` DATETIME,
  `expire_time` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `seckill_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20),
  `sku_id` bigint(20),
  `sku_name` varchar(255),
  `sku_default_img` varchar(255),
  `price`  DECIMAL,
  `cost_price` DECIMAL,
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
  `check_time` DATETIME,
  `status` varchar(255),
  `start_time` DATETIME,
  `num` bigint(20),
  `end_time` DATETIME,
  `stock_count` bigint(20),
  `sku_desc` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `card_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255),
  `sku_id` bigint(20),
  `cart_price` DECIMAL,
  `sku_num` bigint(20),
  `img_url`  varchar(255),
  `sku_name`  varchar(255),
  `is_checked` bigint(20),
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
  `update_time` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20),
  `sku_id` bigint(20),
  `sku_name` varchar(255),
  `img_url`  varchar(255),
  `order_price` DECIMAL,
  `sku_num`  int,
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
  `split_total_amount` DECIMAL,
  `split_activity_amount` DECIMAL,
  `split_coupon_amount` DECIMAL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_detail_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20),
  `order_detail_id` bigint(20),
  `activity_id` varchar(255),
  `activity_rule` bigint(20),
  `sku_id` bigint(20),
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_detail_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20),
  `order_detail_id` bigint(20),
  `coupon_id` bigint(20),
  `sku_id` bigint(20),
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `consignee` varchar(255),
  `consignee_tel` varchar(255),
  `total_amount` DECIMAL,
  `order_status` varchar(255),
   `user_id` bigint(20),
  `payment_way` varchar(255),
  `delivery_address` varchar(255),
  `order_comment` varchar(255),
  `out_trade_no` varchar(255),
  `trade_body` varchar(255),
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
   `expire_time` DATETIME,
    `process_status` varchar(255),
  `tracking_no` varchar(255),
  `parent_order_id`bigint(20),
  `img_url` varchar(255),
   `province_id` bigint(20),
  `activity_reduce_amount` DECIMAL,
  `coupon_amount` DECIMAL,
  `original_total_amount` DECIMAL,
   `refundable_time` DATETIME,
  `feight_fee` DECIMAL,
  `operate_time` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_status_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20),
  `order_status` varchar(255),
  `operate_time` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `payment_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `out_trade_no` varchar(255),
  `order_id` bigint(20),
  `payment_type` varchar(255),
  `trade_no`varchar(255),
  `total_amount` DECIMAL,
  `subject` varchar(255),
  `payment_status` varchar(255),
  `create_time` DATETIME NOT NULL DEFAULT NOW(),
  `callback_time` DATETIME,
  `callback_content` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255),
  `nick_name` varchar(255),
  `passwd` varchar(255),
  `name` varchar(255),
  `phone_num` varchar(255),
  `email` varchar(255),
  `head_img` varchar(255),
  `user_level` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_address` varchar(255),
  `user_id` bigint(20),
  `consignee` varchar(255),
  `phone_num` varchar(255),
  `is_default` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `base_attr_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attr_name` varchar(255),
  `category_id` bigint(20),
  `category_level` int,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `base_attr_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value_name` varchar(255),
  `attr_id` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `base_category1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `base_category2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  `category1_id` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `base_category3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  `category2_id` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `base_category_view` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category1_id` bigint(20),
  `category1_name` varchar(255),
  `category2_id`  bigint(20),
  `category2_name` varchar(255),
  `category3_id`  bigint(20),
  `category3_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `base_sale_attr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `base_trademark` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `logo_url` varchar(255),
  `tm_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sku_attr_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attr_id`  bigint(20),
  `value_id`  bigint(20),
  `sku_id`  bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sku_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20),
  `img_name` varchar(255),
   `spu_img_id` bigint(20),
  `img_url` varchar(255),
   `is_default` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sku_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20),
  `price` DECIMAL,
   `sku_name` varchar(255),
  `sku_desc` varchar(255),
   `weight` varchar(255),
   `tm_id` bigint(20),
  `category3_id`  bigint(20),
   `sku_default_img` varchar(255),
    `is_sale` int,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sku_sale_attr_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20),
  `spu_id` bigint(20),
  `sale_attr_value_id`  bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spu_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20),
  `img_name` varchar(255),
  `img_url`  varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spu_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_name` varchar(255),
  `description` varchar(255),
  `category3_id` bigint(20),
  `tm_id` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spu_poster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20),
  `img_name` varchar(255),
  `img_url` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spu_sale_attr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20),
  `base_sale_attr_id`  bigint(20),
  `sale_attr_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spu_sale_attr_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20),
  `base_sale_attr_id`  bigint(20),
  `sale_attr_value_name` varchar(255),
  `sale_attr_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

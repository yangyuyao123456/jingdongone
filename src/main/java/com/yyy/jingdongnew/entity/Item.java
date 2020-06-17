package com.yyy.jingdongnew.entity;

import lombok.Data;


/**
 * @ClassName Item
 * @Description 商品实体类
 * @Author yuyao.yang
 * @Date 2020/6/16 21:27
 */
@Data
public class Item {
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 产品id
     */
    private Long sku;
    /**
     * 产品标题
     */
    private String title;
    /**
     * 产品图片
     */
    private String pic;
    /**
     * 产品url
     */
    private String url;


}

package com.yyy.jingdongnew.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Item
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 21:27
 */
@Data
public class Item {
    private Integer id;
    private Long sku;
    private String title;
    private String pic;
    private String url;


}

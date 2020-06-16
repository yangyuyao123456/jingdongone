package com.yyy.jingdongnew.entity;

import lombok.Data;

/**
 * @ClassName JingDong
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 9:32
 */
@Data
public class JingDong {

    /**
     * 自增id
     */
    private  Integer id;
    /**
     * 产品id
     */
    private  String productId;
    /**
     * 产品标题
     */
    private  String productTitle;
    /**
     * 产品图片
     */
    private  String productImg;
    /**
     * 产品url
     */
    private  String productUrl;

}

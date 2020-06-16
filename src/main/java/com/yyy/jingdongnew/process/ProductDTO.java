package com.yyy.jingdongnew.process;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ProductJson
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 14:19
 */
@Data
public class ProductDTO implements Serializable {
    /**
     * 京东产品json对象
     */
    private  Product product;

}

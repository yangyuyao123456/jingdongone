package com.yyy.jingdongnew.service;

import com.yyy.jingdongnew.entity.Item;

import java.util.List;

/**
 * @ClassName ItemService
 * @Description service层
 * @Author yuyao.yang
 * @Date 2020/6/16 21:32
 */
public interface  ItemService {

    /**
     * 爬取的数据存储数据库
     * @param item
     */
    void save(Item item);
    /**
     * 根据商品id获取商品所有信息
     * @param sku
     * @return
     */
     List<Item> findAll(long sku);
}

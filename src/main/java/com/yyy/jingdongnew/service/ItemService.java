package com.yyy.jingdongnew.service;

import com.yyy.jingdongnew.entity.Item;

import java.util.List;

/**
 * @ClassName ItemService
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 21:32
 */
public interface  ItemService {

    void save(Item item);

     List<Item> findAll(long sku);
}

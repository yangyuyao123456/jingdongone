package com.yyy.jingdongnew.service.impl;

import com.yyy.jingdongnew.entity.Item;
import com.yyy.jingdongnew.mapper.JingDongMapper;
import com.yyy.jingdongnew.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 21:36
 */
@Service
public class ItemServiceImpl implements ItemService {


    @Resource
    private JingDongMapper jingDongMapper;
    @Override
    public void save(Item item) {
        this.jingDongMapper.save(item);
    }

    @Override
    public List<Item> findAll(long sku) {
        //声明查询条件
        List<Item> list = this.jingDongMapper.findAll(sku);

        return list;
    }

}

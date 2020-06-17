package com.yyy.jingdongnew.service.impl;

import com.yyy.jingdongnew.entity.Item;
import com.yyy.jingdongnew.mapper.JingDongMapper;
import com.yyy.jingdongnew.service.ItemService;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ItemServiceImpl
 * @Description service实现类
 * @Author yuyao.yang
 * @Date 2020/6/16 21:36
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private JingDongMapper jingDongMapper;

    /**
     * 爬取的数据存储数据库
     * @param item
     */

    @Override
    public void save(Item item) {
        this.jingDongMapper.save(item);
    }
    /**
     * 根据商品id获取商品所有信息
     * @param sku
     * @return
     */
    @Override
    public List<Item> findAll(long sku) {
        //声明查询条件
        List<Item> list = this.jingDongMapper.findAll(sku);
        return list;
    }

    public void spiderData(String url, Map<String, String> params) throws Exception {

    }

    }

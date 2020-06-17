package com.yyy.jingdongnew.mapper;


import com.yyy.jingdongnew.entity.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @ClassName Item
 * @Description 商品mapper层
 * @Author yuyao.yang
 * @Date 2020/6/16 21:27
 */
@Mapper
public interface JingDongMapper {
    /**
     * 爬取的数据存储数据库
     * @param item
     */

    @Insert("insert into jingdong(id,sku,title,pic,url) values(" +
            "#{id},#{sku},#{title},#{pic},#{url})")
    public void save(Item item);

    /**
     * 根据商品id获取商品所有信息
     * @param sku
     * @return
     */

    @Select("select * from jingdong where sku=#{sku}")

    public List<Item> findAll(@Param("sku")long sku);

}
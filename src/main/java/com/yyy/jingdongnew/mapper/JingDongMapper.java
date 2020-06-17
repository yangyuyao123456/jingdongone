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


    @Insert("call jingdongyyy(#{id},#{sku},#{title},#{pic},#{url})")
     void save(Item item);

    /**
     * 根据商品id获取商品所有信息
     * @param
     * @return
     */

    @Select("call jingdongquerurl(#{url})")

     List<String> findAll(@Param("url")String url);

}
package com.yyy.jingdongnew.mapper;


import com.yyy.jingdongnew.entity.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JingDongMapper {

    @Insert("insert into jingdong(id,sku,title,pic,url) values(" +
            "#{id},#{sku},#{title},#{pic},#{url})")
    public void save(Item item);

    @Select("select * from jingdong where sku=#{sku}")

    public List<Item> findAll(@Param("sku")long sku);

}
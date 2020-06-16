package com.yyy.jingdongnew.mapper;


import com.yyy.jingdongnew.entity.JingDong;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JingDongMapper {

    @Insert("insert into jingdong(id,product_id,product_title,product_img,product_url) values(" +
            "#{id},#{productId},#{productTitle},#{productImg},#{productUrl})")
    public void insertJingDong(JingDong jingDong);

}
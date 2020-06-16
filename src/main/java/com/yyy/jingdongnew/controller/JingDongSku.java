//package com.yyy.jingdongnew.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.yyy.jingdongnew.DTO.JsonObj;
//import com.yyy.jingdongnew.dealdata.GetJson;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @ClassName JingDongSku
// * @Description TODO
// * @Author yuyao.yang
// * @Date 2020/6/16 13:54
// */
//@RestController
//public class JingDongSku {
////    @Resource
////    JingDongMapper jingDongMapper;
//
//    public void downStockPrice(){
//        //url 生成
//        String url = "https://item.jd.com/68785273297.html" + System.currentTimeMillis();
//        //访问获得json数据
//        JSONObject stock = new GetJson().getHttpJson(url,1);
//        JsonObj jsonObj = new JsonObj();
//        jsonObj.setData(stock.toJSONString());
//        //将json数据存入数据库中
//
//
////        jingDongMapper.insertJingDong(jsonObj);
//    }
//
//
//
//}

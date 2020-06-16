//package com.yyy.jingdongnew.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.yyy.jingdongnew.process.ProductDTO;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.List;
//
///**
// * @ClassName Demo
// * @Description TODO
// * @Author yuyao.yang
// * @Date 2020/6/16 16:28
// */
//@Slf4j
//public class Demo {
//
//
//    public static void main(String[] args) {
//        //获得响应的ajax，json格式的String
//        String str = GetEntity.get();
//        log.info(str);
//        //字符串序列化成集合
//        ProductDTO list= JSON.parseObject(str,ProductDTO.class);
//log.info(list.toString());
////        for(Province item: list){
////            System.out.println(item.getCode());
////            System.out.println(item.getName());
////            System.out.println(item.getUrl());
////        }
//    }
//}

package com.yyy.jingdongnew.process;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName Product
 * @Description 产品内容
 * @Author yuyao.yang
 * @Date 2020/6/16 14:28
 */
@Data
public class Product implements Serializable {

        private  List<Modules> modules;
        private  ImageAndVideoJson imageAndVideoJson;
        private  BigDecimal ostime;
        private  Integer skuid;
        private  SkuMarkJson skuMarkJson;
        private  String name;
        private  String skuidkey;
        private  String href;
        private  String src;
        private  List<ImageList> imageList;
        private  List<Cat> cat;
        private  String forceAdUpdate;
        private  Integer brand;
        private  Integer pType;
        private  Boolean isClosePCShow;
        private  Integer pTag;
        private  Integer venderId;
        private  String shopId;
        private  Boolean shopSwitch;
        private  List<SpecialAttrs> specialAttrs;
        private  List<Recommend> recommend;
        private  String easyBuyUrl;
        private  String qualityLife;
        private  List<ColorSize> colorSize;
        private  Integer warestatus;
        private  String desc;
        private  String mainSkuId;
        private  String foot;
        private  Boolean twoColumn;
        private  Boolean ctCloth;
        private  Boolean isCloseLoop;
        private  Boolean isBookMvd4Baby;
        private  Boolean addComments;
        private  Boolean shangjiazizhi;










}

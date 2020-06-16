package com.yyy.jingdongnew.process;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SkuMarkJson
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 14:43
 */
@Data
public class SkuMarkJson implements Serializable {
    private Boolean isxg;
    private Boolean isJDexpress;
    private Boolean isrecyclebag;
    private Boolean isSds;
    private Boolean isSopJSOLTag;
    private Boolean isyy;
    private Boolean isPOPDistribution;
    private Boolean isSopUseSelfStock;
    private Boolean isGlobalPurchase;
    private Boolean NosendWMS;
    private Boolean isOripack;
    private Boolean ispt;
    private Boolean unused;
    private Boolean pg;
    private Boolean isSopWareService;
    private Boolean isTimeMark;
    private Boolean presale;



}

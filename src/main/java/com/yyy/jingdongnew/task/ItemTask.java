package com.yyy.jingdongnew.task;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyy.jingdongnew.entity.Item;
import com.yyy.jingdongnew.service.ItemService;
import com.yyy.jingdongnew.util.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @ClassName ItemTask
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 21:41
 */
@Component
public class ItemTask {

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private ItemService itemService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //  当下载任务完成后，间隔多长时间进行下一次的任务
    @Scheduled(fixedDelay =1*1000 )
    public void itemTask()  throws Exception{

        //  声明需要解析的初始地址
        String url = "https://www.jd.com/";

        //  遍历页面对搜索进行遍历结果
        for (int i = 1; i < 10; i=i+2) {
            String html = this.httpUtils.doGetHtml(url+i);
            //  解析页面，获取商品数据并存储
            if (html !=null){
                this.parse(html);
            }

        }
        System.out.println("数据抓取完成！！！");
    }

    /**
     * 解析页面，获取商品数据并存储
     * @param html
     */
    private void parse(String html) throws Exception {
        //  解析HTML获取Document
        Document doc = Jsoup.parse(html);
        //  获取spu
        Elements spuEles = doc.select("div#J_goodsList > ul > li");
        //  遍历获取spu数据
        for (Element spuEle : spuEles) {
//            //  获取spu
//            String attr = spuEle.attr("data-spu");
//            long spu = Long.parseLong(attr.equals("")?"0":attr);
            //  获取sku信息
            Elements skuEles = spuEle.select("li.ps-item");
            for (Element skuEle : skuEles) {
                //  获取sku
                long sku = Long.parseLong(skuEle.select("[data-sku]").attr("data-sku"));
                //  根据sku查询商品数据
                Item item = new Item();
                item.setSku(sku);
                List<Item> list = this.itemService.findAll(sku);
                if (list.size()>0){
                    //如果商品存在，就进行下一个循环，该商品不保存，因为已存在
                    continue;
                }
                //  设置商品的spu
//                item.setSpu(spu);

                //  获取商品的详情信息
                String itemUrl = "https://item.jd.com/"+sku+".html";
                item.setUrl(itemUrl);

                //  商品图片
                String picUrl = skuEle.select("img[data-sku]").first().attr("data-lazy-img");
                //	图片路径可能会为空的情况
                if(!StringUtils.isNotBlank(picUrl)){
                    picUrl =skuEle.select("img[data-sku]").first().attr("data-lazy-img-slave");
                }
                picUrl ="https:"+picUrl.replace("/n7/","/n1/");	//	替换图片格式
                String picName = this.httpUtils.doGetImage(picUrl);
                item.setPic(picName);

                //  商品价格
//                String priceJson = this.httpUtils.doGetHtml("https://p.3.cn/prices/mgets?skuIds=J_" + sku);
//                double price = MAPPER.readTree(priceJson).get(0).get("p").asDouble();
//                item.setPrice(price);

                //  商品标题
                String itemInfo = this.httpUtils.doGetHtml(item.getUrl());
                String title = Jsoup.parse(itemInfo).select("div.sku-name").text();
                item.setTitle(title);

                //  商品创建时间
//                item.setCreated(new Date());
                //  商品修改时间
//                item.setUpdated(item.getCreated());

                //  保存商品数据到数据库中
                this.itemService.save(item);

            }
        }
    }



}

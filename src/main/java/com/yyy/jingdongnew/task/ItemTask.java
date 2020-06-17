package com.yyy.jingdongnew.task;


import com.yyy.jingdongnew.entity.Item;
import com.yyy.jingdongnew.service.impl.ItemServiceImpl;
import com.yyy.jingdongnew.util.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;


/**
 * @ClassName ItemTask
 * @Description 数据爬取类
 * @Author yuyao.yang
 * @Date 2020/6/16 21:41
 */
@Component
public class ItemTask {

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private ItemServiceImpl itemService;

    //  当下载任务完成后，间隔多长时间进行下一次的任务
    @Scheduled(fixedDelay =1*1 )
    public void spiderData()  throws Exception{
        //  声明需要解析的初始地址
        String[] urisToGet = {
                "https://search.jd.com/Search?keyword=%E4%B8%8A%E8%A1%A3%E5%A5%B3&enc=utf-8&suggest=2.his.0.0&wq=&pvid=fb530f9426bf461a82ff98893bac0f7e",
                "https://search.jd.com/Search?keyword=%E7%BE%8E%E5%A6%86&enc=utf-8&suggest=2.his.0.0&wq=&pvid=cf67a9a7e5994841b3f875ed1f475a65",
                "https://search.jd.com/Search?keyword=%E6%B2%99%E6%BB%A9%E8%A3%99&enc=utf-8&suggest=6.his.0.0&wq=&pvid=be9309b1fe41437f91159ae6823b60cb"


        };
//        String url = "https://search.jd.com/Search?keyword=%E4%B8%8A%E8%A1%A3%E5%A5%B3&enc=utf-8&suggest=2.his.0.0&wq=&pvid=fb530f9426bf461a82ff98893bac0f7e";
        //  遍历页面对搜索进行遍历结果
        for (int i = 1; i < 10; i=i+2) {
            for (String s:urisToGet
                 ) {
                String html = this.httpUtils.doGetHtml(s+i);
                //  解析页面，获取商品数据并存储
                if (html !=null){
                    this.parse(html);
                }
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
            //  获取sku信息
            Elements skuEles = spuEle.select("li.ps-item");
            for (Element skuEle : skuEles) {
                //  获取sku
                long sku = Long.parseLong(skuEle.select("[data-sku]").attr("data-sku"));
                //  根据sku查询商品数据
                Item item = new Item();
                item.setSku(sku);
                List<Item> list =this.itemService.findAll(sku);
                if (list.size()>0){
                    //如果商品存在，就进行下一个循环，该商品不保存，因为已存在
                    continue;
                }

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

                //  商品标题
                String itemInfo = this.httpUtils.doGetHtml(item.getUrl());
                String title = Jsoup.parse(itemInfo).select("div.sku-name").text();
                item.setTitle(title);

                //  保存商品数据到数据库中
                this.itemService.save(item);

            }
        }
    }



}

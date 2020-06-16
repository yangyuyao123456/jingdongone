//package com.yyy.jingdongnew.controller;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.utils.HttpClientUtils;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import us.codecraft.xsoup.Xsoup;
//
//import java.io.IOException;
//
///**
// * @description:
// * @author: yuyao.yang
// **/
//@RestController
//@RequestMapping(value = "/jingdongcrawler")
//@Slf4j
//
//public class JingDongController {
////    @Resource
////    private ClassService classService;
//    public static String getRosponse() throws IOException {
//        //1.生成httpclient，相当于该打开一个浏览器
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String html = null;
//        try {
//            //2.创建get请求，相当于在浏览器地址栏输入 网址
//            HttpGet httpget = new HttpGet("https://www.jd.com/");
//
//            httpget.setHeader("Accept", "text/html, */*; q=0.01");
//            httpget.setHeader("Accept-Encoding", "gzip, deflate,sdch");
//            httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
//            httpget.setHeader("Connection", "keep-alive");
//            httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.124 Safari/537.36)");
//            //3.执行get请求，相当于在输入地址栏后敲回车键
//            CloseableHttpResponse response = httpClient.execute(httpget);
//
//            //4.判断响应状态为200，进行处理
//            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                //5.获取响应内容
//                HttpEntity httpEntity = response.getEntity();
//                html = EntityUtils.toString(httpEntity, "utf-8");
//
//            } else {
//                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
//                System.out.println("返回状态不是200");
//                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        }
//        finally {
//            //6.关闭
//            HttpClientUtils.closeQuietly(httpClient);
//        }
//        return html;
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        String html = getRosponse();
//        Document document = Jsoup.parse(html);
//        String title = Xsoup.compile("//title").evaluate(document).get();
//        Elements links = document.getElementsByTag("a");
//        for (Element link : links) {
//            String linkHref = link.attr("href");
//            String linkText = link.text();
//            System.out.println("===>>>"+linkHref);
//            System.out.println("===>>>"+linkText);
//        }
//        Elements pngs = document.select("img");
//        for (Element img:pngs
//             ) {
//            String linkHref = img.attr("src");
//            System.out.println("===>>>"+linkHref);
//        }
//
//        //扩展名为.png的图片
//        String data = Xsoup.select(html, "//title").getElements().text();
//        System.out.println("===>>>"+title);
//
//        System.out.println(data);
//    }
//}

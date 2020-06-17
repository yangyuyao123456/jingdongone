package com.yyy.jingdongnew.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName HttpUtils
 * @Description http链接工具类
 * @Author yuyao.yang
 * @Date 2020/6/16 21:25
 */
@Component
public class HttpUtils {
    //建立连接池
    private PoolingHttpClientConnectionManager cm;
    public HttpUtils() {
        //线程池，进行线程管理
        this.cm =new PoolingHttpClientConnectionManager();
        this.cm.setMaxTotal(800);
        this.cm.setDefaultMaxPerRoute(1000);

    }
    //根据请求地址下载页面数据
    public String doGetHtml(String url){
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        HttpGet httpGet=new HttpGet(url);
        httpGet.setConfig(this.getConfig());
        //设置请求Request Headers中的User-Agent


        String[] ualist = {
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv2.0.1) Gecko/20100101 Firefox/4.0.1",
                "Mozilla/5.0 (Windows NT 6.1; RV2.0.1) Gecko/20100101 Firefox/4.0.1",
                "Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36",
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)",
                "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3423.2 Safari/537.36",
               " Mozilla/5.0 (Windows NT 6.1; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:14.0) Gecko/20100101 Firefox/14.0.1",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36",
                " Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Geck) Chrome/53.0.2785.143 Safari/537.36"
        };
        for (String userAgent:ualist
             ) {
            httpGet.addHeader("User-Agent",userAgent);
        }

        CloseableHttpResponse response=null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200){
                if (response.getEntity()!=null){
                    String content = EntityUtils.toString(response.getEntity(), "utf8");
                    return content;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response !=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }


    //下载图片，返回名称
    public String doGetImage(String url){
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        HttpGet httpGet=new HttpGet(url);
        httpGet.setConfig(this.getConfig());
        CloseableHttpResponse response=null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200){
                if (response.getEntity()!=null){
                    //图片后缀
                    String extName = url.substring(url.lastIndexOf("."));
                    //重命名
                    String picName = UUID.randomUUID().toString()+extName;
                    return picName;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response !=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
    //设置请求信息
    private RequestConfig getConfig() {
        RequestConfig config=RequestConfig.custom()
                .setConnectTimeout(1000000000)  //创建连接的最长时间
                .setConnectionRequestTimeout(500000000) //获取连接的最长时间
                .setSocketTimeout(1000000000)  //数据传输的最长时间
                .build();
        return config;
    }


}

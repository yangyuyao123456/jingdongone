package com.yyy.jingdongnew.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName GetEntity
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 16:25
 */
public class GetEntity {

    public static void main(String[] args) {
    get();
    }


    public static String get(){
        //创建客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String entityr = "";
        //创建Get实例
        HttpGet httpGet = new HttpGet("https://item.jd.com/68785273297.html");

        //添加请求头的信息，模拟浏览器访问
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3573.0 Safari/537.36");

        try{
            //获得Response
            CloseableHttpResponse response = httpClient.execute(httpGet);

            if(response.getStatusLine().getStatusCode() == 200){
                //当响应状态码为200时，获得该网页源码并打印
                String entity = EntityUtils.toString(response.getEntity(),"utf-8");
                entityr = entity;
                String any ="[\\s\\S]*" ;//任何东西
                StringBuffer regex = new StringBuffer("");
                regex.append("(skuid.*)").append(any);
                regex.append("(href.*)").append(any);
                regex.append("(src.*)").append(any);
                regex.append("(imageList.*)").append(any);
                regex.append("(colorSize.*)").append(any);//目标字段，下同
                Pattern p = Pattern.compile(regex.toString());
                Matcher m = p.matcher(entityr);
                int countAll = m.groupCount();
                StringBuffer json = new StringBuffer("{");
                if(m.find())
                    for (int i=1;i<=countAll;i++){
                        json.append(m.group(i)) ;
                    }
                System.out.println("结果："+json.append("}").toString() );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return entityr;

    }

}

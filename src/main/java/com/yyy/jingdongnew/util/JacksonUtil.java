package com.yyy.jingdongnew.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @ClassName JacksonUtil
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 15:51
 */
public class JacksonUtil {


    /*
     * 001.json转换成对象
     * @param:传入对象，json字符串
     * @return:Object
     */
    public static Object jsonToObj(Object obj,String jsonStr) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return obj = mapper.readValue(jsonStr, obj.getClass());
    }
    /*
     * 002.对象转换成json
     * @param:传入对象
     * @return:json字符串
     */
    public static String objToJson(Object obj) throws JsonProcessingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}

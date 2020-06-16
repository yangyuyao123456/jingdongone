package com.yyy.jingdongnew.process;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ImageList
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 15:05
 */
@Data
public class ImageList implements Serializable {
    /**
     * 固定字符串数组
     */
    private List<String> imageList;


}

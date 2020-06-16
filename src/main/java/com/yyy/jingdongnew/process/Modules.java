package com.yyy.jingdongnew.process;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Modules
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 14:34
 */
@Data
public class Modules implements Serializable {
    /**
     * 固定字符串数组
     */
    private List<String> modules;

}

package com.yyy.jingdongnew.process;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Recommend
 * @Description TODO
 * @Author yuyao.yang
 * @Date 2020/6/16 15:19
 */
@Data
public class Recommend implements Serializable {

    private List<Integer> recommend;
}

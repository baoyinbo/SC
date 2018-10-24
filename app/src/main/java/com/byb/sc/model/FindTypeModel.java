package com.byb.sc.model;

import java.io.Serializable;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/24 下午3:13
 */

public class FindTypeModel implements Serializable {
    private String name;
    private Integer type;   //1 链接 ； 2 图片

    public FindTypeModel(String name, Integer type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

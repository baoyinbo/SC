package com.byb.sc.model;

import java.io.Serializable;

/**
 * 类描述：更多筛选条件model
 *
 * @auther: baoyinbo
 * @date: 2018/10/26 下午3:16
 */

public class FilterMenuModel implements Serializable {
    private int id;
    private String name;
    private boolean select;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}

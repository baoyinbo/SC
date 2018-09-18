package com.byb.sc.model;

import java.io.Serializable;

/**
 * 类描述：筛选条件
 *
 * @auther: baoyinbo
 * @date: 2018/9/18 上午10:04
 */

public class FilterSingleModel implements Serializable {
    private int id;
    private String name;
    private Integer highest;        //高
    private Integer lowest;         //低
    private boolean isSelect;       //是否选中

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

    public Integer getHighest() {
        return highest;
    }

    public void setHighest(Integer highest) {
        this.highest = highest;
    }

    public Integer getLowest() {
        return lowest;
    }

    public void setLowest(Integer lowest) {
        this.lowest = lowest;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}

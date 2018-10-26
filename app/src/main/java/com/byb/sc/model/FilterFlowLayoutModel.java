package com.byb.sc.model;

/**
 * 类描述：车辆筛选条件布局model
 *
 * @auther: baoyinbo
 * @date: 2018/10/26 上午9:47
 */

public class FilterFlowLayoutModel {
    private static int TYPE_PRICE = 0;      //价格
    private static int TYPE_MILEAGE = 1;    //里程

    private int type;   //类型
    private String name;   //显示的名称
    private int id;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

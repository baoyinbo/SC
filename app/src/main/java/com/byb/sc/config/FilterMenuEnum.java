package com.byb.sc.config;

/**
 * 类描述：筛选条件
 *
 * @auther: baoyinbo
 * @date: 2018/10/26 下午3:20
 */

public enum FilterMenuEnum {

    a("品牌",  0),
    b("价格", 1),
    c("车型", 2),
    d("变速箱", 3),
    e("车龄", 4),
    f("里程", 5),
    g("排量", 6),
    h("发动机", 7),
    i("排放标准", 8),
    j("颜色", 9),
    k("座位数", 10),
    l("国别", 11),
    m("燃料类型", 12);


    private String name;
    private int id;

    FilterMenuEnum(String name, int id) {
        this.name = name;
        this.id = id;
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

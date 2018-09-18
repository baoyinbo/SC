package com.byb.sc.config;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/18 上午9:52
 */

public enum FilterPriceEnum {

    a("不限", null, null, 0),
    b("1-5万", 10000, 50000, 1),
    c("5-10万", 50000, 100000, 2),
    d("10-15万", 100000, 150000, 3),
    e("15-20万", 150000, 200000, 4),
    f("20-30万", 200000, 300000, 5),
    g("30-50万", 300000, 500000, 6),
    m("50万以上", 500000, null, 7);

    private String name;
    private int id;
    private Integer lowest;
    private Integer highest;

    FilterPriceEnum(String name, Integer lowest, Integer highest, int id) {
        this.name = name;
        this.id = id;
        this.lowest = lowest;
        this.highest = highest;
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

    public Integer getLowest() {
        return lowest;
    }

    public void setLowest(Integer lowest) {
        this.lowest = lowest;
    }

    public Integer getHighest() {
        return highest;
    }

    public void setHighest(Integer highest) {
        this.highest = highest;
    }
}

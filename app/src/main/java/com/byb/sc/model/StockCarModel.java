package com.byb.sc.model;

import java.io.Serializable;

/**
 * 类描述：
 * 库存车辆model
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午4:16
 */

public class StockCarModel implements Serializable {
    private String carName;
    private String pic;
    private Long price;
    private Long mileage;
    private String date;        //上牌日期
    private String location;    //所在地


    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

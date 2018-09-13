package com.byb.sc.model;

import java.io.Serializable;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午7:34
 */

public class CompanyModel implements Serializable {
    private String companyName;     //公司名称
    private String owner;           //负责人
    private String phone;
    private String address;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

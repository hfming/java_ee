package com.hfm.pojo;

import java.io.Serializable;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-28 16:51
 * @Description 复杂数据类型
 * @date 2020/10/28
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(province != null && province.length() > 0){
            builder.append(province);
        }
        if(city != null && city.length() > 0){
            builder.append("/").append(city);
        }
        return builder.toString();
    }
}

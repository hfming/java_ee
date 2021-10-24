package com.hfm.dixml;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-01 20:13
 * @Description 有参构造函数方式注入属性
 * @date 2020/10/1
 */
public class DIBookByConstructor {
    /**
     * 创建属性
     */
    private Integer id;
    private String bname;

    /**
     * 有参构造函数方式注入属性
     *
     * @param id
     * @param bname
     */
    public DIBookByConstructor(Integer id, String bname) {
        this.id = id;
        this.bname = bname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", bname='").append(bname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

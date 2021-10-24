package com.hfm.dixml;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-27 16:01
 * @Description p 名称空间方式注入属性
 * @date 2020/9/27
 */
public class DIBookByP {
    /**
     * 创建属性
     */
    private Integer id;
    private String bname;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", bname='").append(bname).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * set 方法必须要有
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}

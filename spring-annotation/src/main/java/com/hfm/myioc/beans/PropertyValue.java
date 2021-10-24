package com.hfm.myioc.beans;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 10:04
 * @Description 用来封装 bean 标签下的属性
 * @date 2021/10/16
 */
public class PropertyValue {
    /**
     * 属性名
     */
    private String name;

    /**
     * 属性值
     */
    private String value;
    /**
     * 其他的 bean
     */
    private String ref;

    public PropertyValue(String name, String value, String ref) {
        this.name = name;
        this.value = value;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PropertyValue{");
        sb.append("name='").append(name).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append(", ref='").append(ref).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package com.hfm.web.action;

import com.hfm.pojo.Product;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;

import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-18 17:53
 * @Description
 * @date 2020/9/18
 */
public class ProductAction extends ActionSupport implements RequestAware, ParameterAware {
    private Map<String, Object> requestMap;
    private Map<String, String[]> parametersMap;

    public Map<String, Object> getRequestMap() {
        return requestMap;
    }

    public void setRequestMap(Map<String, Object> requestMap) {
        this.requestMap = requestMap;
    }

    public Map<String, String[]> getParametersMap() {
        return parametersMap;
    }

    public void setParametersMap(Map<String, String[]> parametersMap) {
        this.parametersMap = parametersMap;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.requestMap = map;
    }

    @Override
    public void setParameters(Map<String, String[]> map) {
        this.parametersMap = map;
    }
    /**
     * save 方法
     * @return
     */
    public String save() {
        String productName = parametersMap.get("productName")[0];
        String productDesc = parametersMap.get("productDesc")[0];
        String productPrice = parametersMap.get("productPrice")[0];

        Product product = new Product(null, productName, productDesc, Double.parseDouble(productPrice));
        // 存储到 request 域中
        requestMap.put("product", product);
        return "save";
    }

    /**
     * 测试标签
     * @return
     */
    public String testTag(){

        return SUCCESS;
    }
}

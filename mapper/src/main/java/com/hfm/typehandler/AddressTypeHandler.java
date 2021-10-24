package com.hfm.typehandler;

import com.hfm.pojo.Address;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-28 16:45
 * @Description 自定义 TypeHandler
 * @date 2020/10/28
 */
public class AddressTypeHandler extends BaseTypeHandler<Address> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Address parameter, JdbcType jdbcType) throws SQLException {
        // 调用 toString 方法获取拼好的字符串
//        ps.setString(i, parameter.toString());

        // 数据验证，判断是否为 null
        if (parameter == null) {
            return;
        }

        // 将各个属性数据取出
        String province = parameter.getProvince();
        String city = parameter.getCity();

        // 拼装成字符串，各个值之间使用 符号 隔开
        StringBuilder builder = new StringBuilder();
        if(province != null && province.length() > 0){
            builder.append(province);
        }
        if(city != null && city.length() > 0){
            builder.append("/").append(city);
        }
        String string = builder.toString();

        // 设置参数
        ps.setString(i,string);
    }

    /**
     * 转化成复杂数据类型的方法
     *
     * @param addressStr
     * @return
     */
    private Address convertToAddress(String addressStr) {
        // 数据验证，判断是否是空字符串
        if (addressStr == null || addressStr.length() == 0) {
            return null;
        }

        // 将数据取出
        String[] strings = addressStr.split("/");
        // 创建对象
        Address address = new Address();
        // 拼装数据
        if (strings.length > 0 && strings[0].length() > 0) {
            address.setProvince(strings[0]);
        }
        if (strings.length > 1 && strings[1].length() > 0) {
            address.setCity(strings[1]);
        }
        // 返回数据
        return address;
    }

    @Override
    public Address getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convertToAddress(rs.getString(columnName));
    }

    @Override
    public Address getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convertToAddress(rs.getString(columnIndex));
    }

    @Override
    public Address getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convertToAddress(cs.getString(columnIndex));
    }
}

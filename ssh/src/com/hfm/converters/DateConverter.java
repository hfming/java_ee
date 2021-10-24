package com.hfm.converters;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;

import javax.servlet.ServletContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
/**
 * 自定义类型转化器,继承 StrutsTypeConverter 类
 */
public class DateConverter extends StrutsTypeConverter {
	private DateFormat dateFormat;
	
	public DateFormat getDateFormat(){
		if(dateFormat == null){
			//获取当前 WEB 应用的初始化参数 pattern
			ServletContext servletContext = ServletActionContext.getServletContext();
			// 从初始化参数中获取转化格式
			String pattern = servletContext.getInitParameter("datePatteren");
			dateFormat = new SimpleDateFormat(pattern);
		}
		return dateFormat;
	}
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(toClass == Date.class){
			if(values != null && values.length > 0){
				String value = values[0];
				try {
					return getDateFormat().parse(value);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		//若没有转换成功, 则返回 values
		return values;
	}

	@Override
	public String convertToString(Map context, Object o) {
		// 判断是否属于 data 数据类型
		if(o instanceof Date){
			Date date = (Date) o;
			return getDateFormat().format(date);
		}
		//若转换失败返回 null
		return null;
	}
}

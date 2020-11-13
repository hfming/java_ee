package com.hfm.typehandler;

import com.hfm.pojo.StateEnum;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-28 17:15
 * @Description 自定义枚举类处理
 * @date 2020/10/28
 */
public class StateEnumTypeHandler extends EnumOrdinalTypeHandler<StateEnum> {
    public StateEnumTypeHandler(Class<StateEnum> type) {
        super(type);
    }
}

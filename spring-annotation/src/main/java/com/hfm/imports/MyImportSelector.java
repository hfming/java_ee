package com.hfm.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-14 20:08
 * @Description 自定义导入选择器
 * @date 2020/10/14
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回需要导入的类的数组
     * @param annotationMetadata 当前标注的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.hfm.domain.Person"};
    }
}

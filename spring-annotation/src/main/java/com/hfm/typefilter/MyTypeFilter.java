package com.hfm.typefilter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-14 10:34
 * @Description 自定义类型扫描器
 * @date 2020/10/14
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * MetadataReader 读取到当前扫描的类信息
     * MetadataReaderFactory 获取到其他任何类信息
     * @param metadataReader
     * @param metadataReaderFactory
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        // 获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 获取当前类的资源(路径)
        Resource resource = metadataReader.getResource();

        String superClassName = classMetadata.getSuperClassName();

        // 如果父类名为 Object 则进行扫描
        if (superClassName.equalsIgnoreCase("Object")) {
            return true;
        }

        return false;
    }
}

package com.hfm.mybatis.io;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-21 20:42
 * @Description 读取配置文件，将配置文件转发为流
 * @date 2020/10/21
 */
public class MyResources {
    /**
     * 根据输入的文件获取字节输入流
     *
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) throws IOException {
        return Resources.getResourceAsStream(filePath);
    }
}

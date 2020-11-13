package com.hfm.test;

import com.hfm.dao.UserMapper;
import com.hfm.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-27 20:05
 * @Description
 * @date 2020/10/27
 */
public class MbgTest {
    /**
     * 通过 java 代码方式执行 通用 mapper 逆向工程
     *
     * @throws InvalidConfigurationException
     * @throws IOException
     * @throws SQLException
     * @throws InterruptedException
     * @throws XMLParserException
     */
    @Test
    public void javaTest() throws InvalidConfigurationException, IOException, SQLException, InterruptedException, XMLParserException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(getResourceAsStream("mbg.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}

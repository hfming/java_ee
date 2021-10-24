package com.hfm.test;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-22 11:15
 * @Description
 * @date 2021/10/22
 */
public class MBGTest {
    @Test
    public void mbgTest() throws XMLParserException, IOException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();

        boolean overwrite = true;

        File configFile = new File("mbg.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);

        Configuration config = cp.parseConfiguration(configFile);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

        myBatisGenerator.generate(null);
    }

    /**
     * QBC风格的带条件查询
     */
    @Test
    public void test01(){
//        SqlSession openSession = build.openSession();
//        DeptMapper mapper = openSession.getMapper(DeptMapper.class);
//        DeptExample example = new DeptExample();
//        //所有的条件都在example中封装
//        Criteria criteria = example.createCriteria();
//        //select id, deptName, locAdd from tbl_dept WHERE
//        //( deptName like ? and id > ? )
//        criteria.andDeptnameLike("%部%");
//        criteria.andIdGreaterThan(2);
//        List<Dept> list = mapper.selectByExample(example);
//        for(Dept dept : list) {
//            System.out.println(dept);
//        }
    }
}

package com.hfm.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-29 22:03
 * @Description mp 逆向工程
 * @date 2020/10/29
 */
public class GeneratorTest {
    @Test
    public void generatorTest() {
        //1、此处默认有两个对应的实现类，不要导错包.import com.baomidou.mybatisplus.generator.config.GlobalConfig;
        GlobalConfig globalConfig = new GlobalConfig();
        //设置全局的配置
        globalConfig.setActiveRecord(true)  //是否支持AR模式
                .setAuthor("hfm")  //设置作者
                .setOutputDir("D:\\Code\\java_ee\\ssm\\src\\main\\java")  //设置生成路径
                .setFileOverride(true)  //设置文件覆盖
                .setIdType(IdType.AUTO) //设置主键生成策略
                .setServiceName("%sService")  //设置生成的serivce接口的名字。 默认的名字首字母为I。 %sService ：去掉I
                .setBaseResultMap(true)   //设置基本的结果集映射
                .setBaseColumnList(true);  //设置基本的列集合

        //2、设置数据源的配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://47.99.213.57:3306/ssm?characterEncoding=utf8&amp;useSSL=false")
                .setUsername("root")
                .setPassword("tiger2018")
                .setDbType(DbType.MYSQL); // 数据库类型

        // 3、进行策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//设置全局大写命名
//                .setDbColumnUnderline(true) // 使用下划线 3.0 默认开启不需要配置
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略
                .setTablePrefix("tbl_")//设置表名前缀
                .setInclude("tbl_emp","tbl_dept");//生成需要的表

        // 4、进行包名的策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.hfm") // 设置同一父路径
                .setMapper("mapper") // 设置 Mapper 接口所生成的包
                .setService("service") // 设置 service 层所在包
                .setController("controller") // 设置 controller 所在包
                .setEntity("domain") // 设置 实体类所在包
                .setXml("mapper");  //和mapper接口放一起

        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator
                .setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        //6、执行
        autoGenerator.execute();
    }
}

package com.powernode.web;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.powernode.web")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfig {
    @Bean
    public static DataSource dataSource(@Value("${jdbc.driver}") String driver,
                                        @Value("${jdbc.url}") String url,
                                        @Value("${jdbc.username}") String username,
                                        @Value("${jdbc.password}") String password) {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(driver);
        pooledDataSource.setUrl(url);
        pooledDataSource.setUsername(username);
        pooledDataSource.setPassword(password);
        return pooledDataSource;
    }

    @Bean
    public static DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer(@Value("com.powernode.web.mapper")
                                                                      String basePackage) {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(basePackage);
        return mapperScannerConfigurer;
    }

    @Bean
    public static SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource,
                                                              @Value("classpath:mybatis-config.xml") Resource configLocation,
                                                              @Value("com.powernode.web.domain") String aliasesPackage) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage(aliasesPackage);
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(configLocation);
        return sqlSessionFactoryBean;
    }
}


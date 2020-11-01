package com.zoro.multi.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 0:02
 * @desc
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = OracleDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "oracleSqlSessionFactory")
public class OracleDataSourceConfig {
    static final String PACKAGE = "com.zoro.multi.datasource.mapper.oracle";
    static final String MAPPER_LOCATION = "classpath:mapper/oracle/*.xml";

    @Bean
    @ConfigurationProperties(prefix = "oracle.datasource")
    public DbConntionInfo oracleConntionInfo(){
        return new DbConntionInfo() ;

    }

    @Bean(name = "oracleDataSource")
    public DataSource oracleDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(oracleConntionInfo().getDriverClassName());
        dataSource.setUrl(oracleConntionInfo().getUrl());
        dataSource.setUsername(oracleConntionInfo().getUserName());
        dataSource.setPassword(oracleConntionInfo().getPassword());
        return dataSource;
    }

    @Bean(name = "oracleTransactionManager")
    public DataSourceTransactionManager oracleTransactionManager() {
        return new DataSourceTransactionManager(oracleDataSource());
    }

    @Bean(name = "oracleSqlSessionFactory")
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource oracleDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(oracleDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(OracleDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}

package com.zoro.multi.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@MapperScan(basePackages = MysqlDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MysqlDataSourceConfig {
    static final String PACKAGE = "com.zoro.multi.datasource.mapper.mysql";
    static final String MAPPER_LOCATION = "classpath:mapper/mysql/*.xml";


    @Bean
    @ConfigurationProperties(prefix = "mysql.datasource")
    public DbConntionInfo mysqlConntionInfo(){
        return new DbConntionInfo() ;

    }

    @Bean(name = "mysqlDataSource")
    @Primary
    public DataSource mysqlDataSource() {
        String driverClassName = mysqlConntionInfo().getDriverClassName();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(mysqlConntionInfo().getDriverClassName());
        dataSource.setUrl(mysqlConntionInfo().getUrl());
        dataSource.setUsername(mysqlConntionInfo().getUserName());
        dataSource.setPassword(mysqlConntionInfo().getPassword());
        return dataSource;
    }

    @Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManager() {
        return new DataSourceTransactionManager(mysqlDataSource());
    }

    @Bean(name = "mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource mysqlDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mysqlDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MysqlDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}

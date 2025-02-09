package com.empapp.assign.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages ={"com.empapp"} )
@EnableTrasactionManagement

public class AppConfig {
        @Bean
        public DataSource dataSource(){
            DriverManagerDataSource dataSource=new DriverManagerDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/demo1234");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            return dataSource;
        }
        //jdbcTemplate
        @Bean
        public JdbcTemplate jdbcTemplate(DataSource dataSource){
            JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
            return jdbcTemplate;
        }
        @Bean
        public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
            DataSourceTransactionManager transactionManager=new DataSourceTransactionManager(dataSource);
            return transactionManager;
        }

    }

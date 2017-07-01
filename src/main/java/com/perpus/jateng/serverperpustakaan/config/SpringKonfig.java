/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpus.jateng.serverperpustakaan.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author danang
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.perpus.jateng.serverperpustakaan.repository")
@ComponentScan({"com.perpus.jateng.serverperpustakaan.controller", "com.perpus.jateng.serverperpustakaan.service"})
public class SpringKonfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setAutoCommit(false);
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/inlislite_v3?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword("1bismillah23");

        config.setMaximumPoolSize(5);
        //config.setConnectionTestQuery("SELECT 1");
        //config.setPoolName("springHikariCP");
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);        
        LocalContainerEntityManagerFactoryBean fb = new LocalContainerEntityManagerFactoryBean();
        fb.setDataSource(dataSource());
        fb.setJpaVendorAdapter(vendorAdapter);
        fb.setPackagesToScan("com.perpus.jateng.serverperpustakaan.pojo");
        fb.afterPropertiesSet();
        
        return fb.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager trx = new JpaTransactionManager();
        trx.setEntityManagerFactory(entityManagerFactory());
        return trx;
    }
}

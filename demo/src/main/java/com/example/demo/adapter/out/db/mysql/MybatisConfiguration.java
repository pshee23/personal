package com.example.demo.adapter.out.db.mysql;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(value ="com.example.demo.adapter.out.db.mysql.mapper")
public class MybatisConfiguration {
	private String typeAliasesPackage = "com.example.demo.adapter.out.db.mysql";
	private String mapperPath = "classpath:mybatis/*.xml";
	
	@Primary
	@Bean(name="tcmsDataSource")
	@ConfigurationProperties(prefix = "spring.tcms-datasource")
	public static DataSource dataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name="tcmsSqlSessionFactory")
	public SqlSessionFactory tcmsSqlSessionFactory(ApplicationContext applicationContext,
			@Qualifier("tcmsDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mapperPath));
		return sqlSessionFactoryBean.getObject();
	}

	@Primary
	@Bean(name="tcmsSessionTemplate")
	public SqlSessionTemplate tcmsSqlSessionTemplate(
			@Qualifier("tcmsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}

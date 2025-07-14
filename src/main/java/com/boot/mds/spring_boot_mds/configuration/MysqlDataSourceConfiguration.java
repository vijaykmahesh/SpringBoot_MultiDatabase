package com.boot.mds.spring_boot_mds.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MysqlDataSourceConfiguration {

	@ConfigurationProperties("spring.datasource.mysql")
	@Bean
	public DataSourceProperties mysqlDataSourceProperties() {

		return new DataSourceProperties();

	}

	@Bean
	public DataSource mysqldataSource() {

		return mysqlDataSourceProperties().initializeDataSourceBuilder().build();

	}

}

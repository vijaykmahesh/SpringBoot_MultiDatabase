package com.boot.mds.spring_boot_mds.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PostgresDataSourceConfiguration {

	@ConfigurationProperties("spring.datasource.pg")
	@Bean
	public DataSourceProperties postgresDataSourceProperties() {

		return new DataSourceProperties();

	}

	@Primary
	@Bean
	public DataSource postgresDataSource() {

		return postgresDataSourceProperties().initializeDataSourceBuilder().build();

	}

}

package com.boot.mds.spring_boot_mds.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackages = "com.boot.mds.spring_boot_mds.postgres.repository", entityManagerFactoryRef = "postgresEntityManagerFactory", transactionManagerRef = "postgresTransactionManager")
public class PostgresJPAConfiguration {

	@Bean(name = "postgresEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgresDataSource") DataSource dataSource) {

		return builder.dataSource(dataSource).packages("com.boot.mds.spring_boot_mds.orderentity").build();

	}

	@Bean(name = "postgresTransactionManager")
	public PlatformTransactionManager postgresTransactionManager(
			@Qualifier("postgresEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}

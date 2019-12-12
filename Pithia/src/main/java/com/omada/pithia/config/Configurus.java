package com.omada.pithia.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.omada.pithia.service"})
@PropertySource("database.properties")
public class Configurus {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyResolver(){
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String user_name;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.driver}")
	private String driver;

	@Bean
	public DataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(user_name);
		basicDataSource.setPassword(password);
		return basicDataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.omada.pithia.domain.xrhstes","com.omada.pithia.domain.mathimata");
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaProperties(hibernateProperties());
		factory.afterPropertiesSet();

		return factory.getNativeEntityManagerFactory();
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws IOException {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());
		transactionManager.setDataSource(dataSource());

		return transactionManager;
	}



	private Properties hibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.use_sql_comments", "true");
		properties.put("hibernate.hbm2ddl.auto", "validate");
		properties.put("hibernate.order_updates", "true");
		properties.put("org.hibernate.flushMode", "ALWAYS");
		properties.put("hibernate.max_fetch_depth", "3");
		properties.put("hibernate.default_batch_fetch_size", "10");
		properties.put("hibernate.jdbc.fetch_size", "50");

		return properties;
	}


}

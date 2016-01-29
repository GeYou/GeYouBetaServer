package com.thesis.geyou.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(name = "app", value = { "classpath:app.properties" })
public class HibernateConfig {

	@Autowired
	Environment env;

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		builder.scanPackages("com.thesis.geyou.entities").addProperties(getHibernateProperties());
		SessionFactory sessionFactory = builder.buildSessionFactory();
		return sessionFactory;
	}

	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "create");
		return props;
	}

	private String getEnvProp(String propertyName) {
		return env.getProperty(propertyName);
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(getEnvProp("jdbc.url"));
		dataSource.setDriverClassName(getEnvProp("jdbc.driver"));
		dataSource.setUsername(getEnvProp("jdbc.user"));
		dataSource.setPassword(getEnvProp("jdbc.pass"));
		return dataSource;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}

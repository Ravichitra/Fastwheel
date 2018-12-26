package com.fastwheel.fastwheelbackend;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration // beans
@EnableTransactionManagement
@ComponentScan("com.fastwheel")
public class dbconfig {

//1)where my database is-config ur datasource
	@Bean("mydatasource")
	DataSource getdatasource() {
		BasicDataSource basicDataSource = new BasicDataSource();// driverManagerDatasource
		basicDataSource.setDriverClassName("org.h2.Driver");
		basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/test2");
		basicDataSource.setUsername("sa");
		basicDataSource.setPassword("ravichitra");
		return basicDataSource;
	}

//language understood by my database
	@Bean("myproperties")
	Properties myDbProperties() {
		Properties Properties = new Properties();// hashmap
		Properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");// CRUD
		Properties.setProperty("hibernate.hbm2ddl.auto", "update");// creating ur data structure
		Properties.setProperty("hibernate.show_sql", "true");
		return Properties;
	}

//3)with the help of above config we will establish a connection
	
	@Bean("sf")

	LocalSessionFactoryBean createSessionFactory(DataSource mydatasource, Properties myproperties) {
		// orm to create queries
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(mydatasource);
		bean.setHibernateProperties(myproperties);
		bean.setPackagesToScan("com.fastwheel.fastwheelbackend.model");
		return bean;
	}

	@Autowired
	@Bean("mytrans")
	HibernateTransactionManager htm(SessionFactory sf) {
		HibernateTransactionManager ht = new HibernateTransactionManager();
		ht.setSessionFactory(sf);
		return ht;
	}
}

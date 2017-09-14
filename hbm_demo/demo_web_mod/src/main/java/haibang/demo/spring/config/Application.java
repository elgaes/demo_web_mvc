package haibang.demo.spring.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedXADataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


/**
 * This is Spring Boot main configuration class to wire in a number of required components
 * 		-Derby XA Embbeded Data Source - Provide access to embedded derby database name demo_db stored at root folder of this app
 *  	-Local Entity Manager factory - Produce Spring JPA entity manager factory wrapper which will automatic detect 
 *  									Hibernate JPA provider on classpath and configure Hibernate JPA for the app
 *  	-JPA Transaction Manager - Wire in a Transaction service to provide transaction management for the JPA.
 *  
 *  There are more application configuration setup in the Spring Application.properties directory /src/main/resource/config
 *  Spring will auto pickup configuration from this file and setup the rest of the Spring MVC framework include the Thymeleaf 
 *  web template engine which process web template for this app 
 *  
 *  This class also tell sprinng to enable transaction management infra as well as tell it auto scan app service components 
 *  and JPA entity packages
 *   
 * @author seagle
 *
 */
@SpringBootApplication(
		scanBasePackages = {"haibang.demo.spring.web",
							"haibang.demo.spring.service",
							"haibang.demo.spring.config"})
@EntityScan(basePackages= {"haibang.demo.jpa"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="haibang.demo.spring.dao")
public class Application
{
	public static void main(String[] args)
	{
		//Set directory for derby to create its database, default to working directory
		System.setProperty("derby.system.home",System.getProperty("user.dir"));
		SpringApplication.run(Application.class, args);
	}
	

	@Bean
	@ConfigurationProperties("demo.datasource")
	public DataSource dataSource() 
	{
	    return DataSourceBuilder.create().type(EmbeddedXADataSource.class).build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) 
	{
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();		
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
		//entityManagerFactoryBean.setPackagesToScan("haibang.demo.jpa");
		return entityManagerFactoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) 
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	


}

package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@PropertySource(value = "classpath:config/application.properties")
@Configuration
@ComponentScan(basePackages = {"service","dao"})
public class serviceConfig {
	
	@Value("${driver}")
	String driver;
	
	@Value("${url}")
	String url;
	
	@Value("${user}")
	String user;
	
	@Value("${password}")
	String password;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(url);
		data.setUsername(user);
		data.setPassword(password);
		return data;
	}
	
	// adaptador de Hibernate
		@Bean
		public HibernateJpaVendorAdapter adapter() {
			HibernateJpaVendorAdapter adp = new HibernateJpaVendorAdapter();
			adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
			return adp;
		}

		// factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
		@Bean
		public LocalContainerEntityManagerFactoryBean factory(DataSource dataSource, HibernateJpaVendorAdapter adapter) {
			LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
			factory.setPersistenceUnitName("formacionPU");
			factory.setDataSource(dataSource);
			factory.setPackagesToScan("model");
			Properties props=new Properties();
			props.put("hibernate.enable_lazy_load_no_trans", true);
			factory.setJpaProperties(props);
			factory.setJpaVendorAdapter(adapter);
			return factory;
		}

		// gestor de transacción
		@Bean
		public JpaTransactionManager txManager(LocalContainerEntityManagerFactoryBean factory) {
			JpaTransactionManager manager = new JpaTransactionManager();
			manager.setEntityManagerFactory(factory.getObject());
			return manager;
		}

}

package ankush.spring.hibernate.configurations;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
@ComponentScan(basePackages = {"ankush.spring.hibernate"})
public class HibernateConfiguration {
	
	
	@Bean
	@Autowired
	public HibernateTemplate getTemplate(DataSource dataSource) {
		HibernateTemplate template;
		Properties hibernateProperties=new Properties();
		String urlString="jdbc:mysql://localhost/spring_jdbc";
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect" );
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		hibernateProperties.setProperty("hibernate.connection.url",urlString);
		hibernateProperties.setProperty("hibernate.connection.username", "neha");
		hibernateProperties.setProperty("hibernate.connection.password", "1234");
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("ankush.spring.hibernate.entities");
		sessionBuilder.setProperties(hibernateProperties);
	//	localSessionFactoryBean.setDataSource(dataSource);
	//	localSessionFactoryBean.setHibernateProperties(hibernateProperties);
	//	localSessionFactoryBean.setAnnotatedPackages("ankush.spring.hibernate.entities");
		SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
		template=new HibernateTemplate(sessionFactory);
		template.setSessionFactory(sessionFactory);
		template.setCheckWriteOperations(false);
		return template;
	}
	
	@Bean
	public DataSource getDataSource() {
		String urlString="jdbc:mysql://localhost/spring_jdbc";
		Properties conProperties=new Properties();
		conProperties.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		DriverManagerDataSource dataSource=new DriverManagerDataSource(urlString,"neha","1234");
		dataSource.setConnectionProperties(conProperties);
		return dataSource;
	}
	
}

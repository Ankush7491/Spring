package ankush.spring.jdbc.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Configuration
@ComponentScan(basePackages = {"ankush.spring.jdbc"})
public class VehicleConfiguration {

	
	@Bean
	public JdbcTemplate getTemplate(DriverManagerDataSource dataSource) {
		
		return new JdbcTemplate(dataSource);
		
	}
	
	@Bean("jdbcDataSource")
	public DriverManagerDataSource getDataSource() {
	     Properties configProperties= new Properties();
	     configProperties.setProperty("driverClassName", "com.mysql.jdbc.Driver"); 
	     String urlString="jdbc:mysql://localhost/spring_jdbc";
			/*
			 * configProperties.setProperty("username", "neha");
			 * configProperties.setProperty("password", "1234");
			 * configProperties.setProperty("url", "spring_jdbc");
			 */
	     DriverManagerDataSource dataSource= new DriverManagerDataSource(urlString,"neha","1234");
	     dataSource.setConnectionProperties(configProperties);
	     return dataSource;
	      
	}
	
}

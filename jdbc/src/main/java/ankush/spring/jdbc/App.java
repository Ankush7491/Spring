package ankush.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import ankush.spring.jdbc.configuration.VehicleConfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(VehicleConfiguration.class);
        JdbcTemplate vehicleJdbcTemplate= context.getBean(JdbcTemplate.class);
//        DriverManagerDataSource dataSource=context.getBean(DriverManagerDataSource.class);
  //      System.out.println(dataSource.getUrl()+"  username"+dataSource.getUsername()+"  password"+dataSource.getPassword()+ " properties"+dataSource.getConnectionProperties());
        String queryString="insert into vehicle(id,make) values(2798,\"hyundai\")";
        vehicleJdbcTemplate.execute(queryString);
        
    }
}

package ankush.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import ankush.spring.jdbc.beans.Vehicle;
import ankush.spring.jdbc.configuration.VehicleConfiguration;
import ankush.spring.jdbc.dao.VehicleDao;
import ankush.spring.jdbc.daoimplementations.CommercialVehicle;

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
	/*
	 * String queryString="insert into vehicle(id,make) values(2798,\"hyundai\")";
	 * vehicleJdbcTemplate.execute(queryString);
	 */ 
        VehicleDao vehicleDao=context.getBean(CommercialVehicle.class);
		/*
		 * Vehicle vehicle= new Vehicle(); Double tempIDouble=Math.random();
		 * vehicle.setId(9800); vehicle.setMakeString("Merc");
		 * vehicleDao.insert(vehicle); vehicle.setMakeString("Tatas");
		 * vehicleDao.update(vehicle);
		 */
       System.out.println(vehicleDao.getVehicle(9800).toString());
       System.out.println(vehicleDao.getVehicles().toString());
    }
}

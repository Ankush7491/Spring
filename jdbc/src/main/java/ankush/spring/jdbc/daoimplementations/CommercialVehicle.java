package ankush.spring.jdbc.daoimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ankush.spring.jdbc.beans.Vehicle;
import ankush.spring.jdbc.dao.VehicleDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class CommercialVehicle implements VehicleDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insert(Vehicle vehicle) {
		// TODO Auto-generated method stub
		 String queryString="insert into vehicle(id,make) values(?,?)";		 
	        this.jdbcTemplate.update(queryString, String.valueOf(vehicle.getId()),vehicle.getMakeString());
		return 0;
	}

	public int update(Vehicle vehicle) {
		// TODO Auto-generated method stub
		int rows;
		 String queryString="insert into vehicle(id,make) values(?,?)";		 
	        rows=jdbcTemplate.update(queryString, String.valueOf(vehicle.getId()),vehicle.getMakeString());
		return rows;
	}

}

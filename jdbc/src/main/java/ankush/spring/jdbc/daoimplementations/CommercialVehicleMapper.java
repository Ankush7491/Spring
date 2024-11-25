package ankush.spring.jdbc.daoimplementations;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ankush.spring.jdbc.beans.Vehicle;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class CommercialVehicleMapper implements RowMapper<Vehicle> {
	
	
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
	// TODO Auto-generated method stub
		Vehicle vehicle=new Vehicle();
		vehicle.setId(rs.getInt(1));
		vehicle.setMakeString(rs.getString(2));
	return vehicle;
}

}

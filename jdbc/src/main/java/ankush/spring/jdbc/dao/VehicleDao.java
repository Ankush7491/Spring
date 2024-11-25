package ankush.spring.jdbc.dao;

import ankush.spring.jdbc.beans.Vehicle;

public interface VehicleDao {

	public int insert(Vehicle vehicle);
	public int update(Vehicle vehicle);
}

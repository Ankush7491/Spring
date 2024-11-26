package ankush.spring.jdbc.dao;

import java.util.List;

import ankush.spring.jdbc.beans.Vehicle;

public interface VehicleDao {

	public int insert(Vehicle vehicle);
	public int update(Vehicle vehicle);
	public int delete(Vehicle vehicle);
	public Vehicle getVehicle(int id);
	public List<Vehicle> getVehicles();
}

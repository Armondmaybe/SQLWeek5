package cars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cars.entity.Car;

public class CarDao {
	// This Creates a car
	public static void createCar(String name) throws SQLException{
		String sql = "INSERT INTO car (name) VALUES (?)";
		Connection connection = null;
		PreparedStatement  statement= null;
		
		try {
			connection =DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement .setString(1, name);
			
			statement.executeUpdate();
		}
		finally {
			if(statement!=null) {
				statement.close();

			}
			if(connection!=null) {
				connection.close();

			}
			connection.close();
		}
	}
	
	// This reads car Inventory 
	public static List<Car> fetchCars() throws SQLException{
		String sql = " SELECT* FROM car";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs= null;
		List<Car>cars = new ArrayList<>();
		
		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				int carId =rs.getInt("car_id");
				String name = rs.getString("name");
				Car car = new Car(carId,name);
				cars.add(car)
;				
			}
			return cars;
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(statement!=null) {
				statement.close();

			}
			if(connection!=null) {
				connection.close();

			}
			
		}
	}
	
	//This is modifying car inventory
	public void modifyCar(int id,String name)throws SQLException{
		String sql ="UPDATE car SET name = ? WHERE car_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, id);
			
			statement.executeUpdate();
		}
		finally {
			statement.close();
			connection.close();
		}
	}
	
	
	public void deleteCar(int carId)throws SQLException{
		String sql = "DELETE FROM car WHERE car_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, carId);
			
			statement.executeUpdate();
		}
		finally {
			statement.close();
			connection.close();
		}
	}

}

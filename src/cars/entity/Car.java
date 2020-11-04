package cars.entity;

public class Car {
	private int carId;
	private String name;
	
	public Car(int carId, String name) {
		this.carId = carId;
		this.name = name;
	}

	public int getCarId() {
		return carId;
	}

	

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", name=" + name + "]";
	}

}

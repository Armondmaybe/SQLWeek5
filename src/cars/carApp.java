package cars;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import cars.dao.CarDao;
import cars.entity.Car;

public class carApp {

	private Scanner scanner = new Scanner(System.in);
	private CarDao carDao = new CarDao();

	public static void main(String[] args) {
		new carApp().run();
		
		
	}
	
	private void run() {		
		while (true){			
			printInstructions();
			System.out.print("Enter a Selection: ");
			String choice = scanner.nextLine();
			
			if (choice.isBlank()) {
				break;
			}
			try {
				switch(choice) {
				case "1":
					createCar();
					break;
					
				case "2":
					modifyCar();
					break;
					
				case "3":
					listCars();
					break;
					
				case "4":
					deleteJeep();
					break;
					
					default:
						System.out.println("Invalid Option, Try Again");
				}
			}
				catch(SQLException e) {
					System.out.println("You got an error "+ e.getMessage());
				}
		}
		
			

		
	}
	
	private void deleteJeep() throws SQLException {
		listCars();
		System.out.println("Enter The Car ID to modify");
		int id =Integer.parseInt(scanner.nextLine());	
		carDao.deleteCar(id);
	}

	private void modifyCar() throws SQLException {
		listCars();
		System.out.println("Enter The Car ID to modify");
		int id =Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Car Name: ");
		String name = scanner.nextLine();
		carDao.modifyCar(id, name);
		listCars();
	}

	private void listCars() throws SQLException {
		
		List<Car>cars = CarDao.fetchCars();
		cars.stream().forEach(System.out::println);
	}

	

	private void createCar() throws SQLException {
		System.out.println("Enter the name of the Car: ");
		String name = scanner.nextLine();
		CarDao.createCar(name);
	}

	private void printInstructions() {
		System.out.println("1)Create Car: ");
		System.out.println("2)Modify Car");
		System.out.println("3)List all Cars");
		System.out.println("4)Delete a Car");



	}

}

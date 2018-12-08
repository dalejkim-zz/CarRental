package app;

import java.util.Calendar;
import java.util.HashMap;

public class RentalSystem {
	private String UUID, location;
	Customers customers = new Customers();
	RentalLocation rl = new RentalLocation(location);
	double dailyPrice;
	Orders orders;
	
	public RentalSystem(String UUID, String location) {
		this.UUID = UUID;
		this.location = location;
	}
	
	public double transaction(Car car, Calendar startDate, int days) {
		Calendar dueDate = startDate;
		dueDate.add(Calendar.DAY_OF_MONTH, days);
		orders.addOrders(UUID, startDate, dueDate, car);
		dailyPrice = car.getDailyPrice() * days;
		rl.removeCar(car);
		return dailyPrice;
	}
	
	public void extendRental(String UUID, int days) {
		orders.extendRental(UUID, days);
	}
	
	public void createCustomer(String UUID, String email, String firstName, String lastName, String driversLicense) {
		User user = new User(UUID, email, firstName, lastName, driversLicense);
		customers.addInfo(UUID, user);
	}
	
	public HashMap<Car, Integer> retrieveAvailableCars() {
		return rl.getAvailableCars();
	}
	
	public String getUUID() {
		return UUID;
	}
}
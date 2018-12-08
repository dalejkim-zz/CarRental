package app;

import java.util.HashMap;

public class RentalLocation {
	private String location;
	private HashMap<Car, Integer> availableCars = new HashMap<Car, Integer>();
	
	public RentalLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public HashMap<Car, Integer> getAvailableCars() {
		return availableCars;
	}

	public void setAvailableCars(HashMap<Car, Integer> availableCars) {
		this.availableCars = availableCars;
	}
	
	public void addCar(Car car) {
		Integer count = availableCars.get(car);
		if(count != null) {
			availableCars.put(car, count++);
		} else {
			availableCars.put(car, 1);
		}
	}
	
	public void removeCar(Car car) {
		Integer count = availableCars.get(car);
		if(count == 1) {
			availableCars.remove(car);
		} else {
			availableCars.put(car, count--);
		}
	}
}
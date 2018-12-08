package app;

import java.util.HashMap;

public class Customers {
	private HashMap<String, User> customerList = new HashMap<String, User>();
	
	public User getInfo(String UUID) {
		return customerList.get(UUID);
	}
	
	public void addInfo(String UUID, User user) {
		customerList.put(UUID, user);
	}
}
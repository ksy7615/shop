package shop;

import java.util.ArrayList;

public class User {
	private String id, password, name;
	
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public User clone() {
		return new User(this.id, this.password, this.name);
	}
	
}

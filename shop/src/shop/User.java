package shop;

public class User {
	private String id, password, name;
	private Cart basket;
	
	public User() {
		
	}
	
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
		
		basket = new Cart();
	}

	public String getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public String getName() {
		return this.name;
	}
	
	public Cart getCart() {
		return basket.clone();
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User clone() {
		return new User(this.id, this.password, this.name);
	}
	
}

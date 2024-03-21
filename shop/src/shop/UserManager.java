package shop;

import java.util.ArrayList;

public class UserManager {
	
	private ArrayList<User> userList;
	
	public UserManager() {
		userList = new ArrayList<>();
	}
	
	// 기능 CRUD
	// C 회원가입
	public User createUser(String id, String password, String name) {
		User user = new User(id, password, name);
		userList.add(user);
		return user.clone();
	}
	
}

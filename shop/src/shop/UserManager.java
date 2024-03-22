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
		if (existedId(id)) {
			User user = new User(id, password, name);
			userList.add(user);
			return user.clone();
		}
		return new User();
	}
	
	public User getUser(int index) {
		User user = userList.get(index);
		return user.clone();
	}
	
	// 아이디로 조회
	public User getUserById(String id) {
		for (User user : userList) {
			if (user.getId().equals(id))
				return user;
		}
		return new User();
	}

	public boolean existedId(String id) {
		User user = getUserById(id);
		
		if (user.getId() == null) {
			return true;
		}
		return false;
	}

	// 업데이트 > 비밀번호 재설정
	public void updateUserPassword(User user, String password) {
		String id = user.getId();
		User target = getUserById(id);
		target.setPassword(password);
	}

	// D 회원탈퇴
	public boolean deleteUser(User user) {
		String userId = user.getId();
		User target = getUserById(userId);

		return userList.remove(target);
	}
	
	public int getUserSize() {
		return this.userList.size();
	}
}

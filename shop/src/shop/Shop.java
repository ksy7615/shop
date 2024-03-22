package shop;

import java.util.Scanner;

public class Shop {
	private UserManager userManager = new UserManager();
	private ItemManager itemManager = new ItemManager();

	private Scanner scanner = new Scanner(System.in);

	private String shopTitle;
	private boolean isRun;

	private int log;

	public Shop(String shopTitle) {
		this.shopTitle = shopTitle;
		this.isRun = true;
		this.log = -1;
	}

	private void printMenu() {
		System.out.printf("----%s----\n", this.shopTitle);
		System.out.println("[1. 유저]");
		System.out.println("[2. 관리자]");
		System.out.println("------------");
	}

	private void printUserSubMenu() {
		System.out.println("------------");
		System.out.println("1) 회원가입");
		System.out.println("2) 회원탈퇴");
		System.out.println("3) 로그인");
		System.out.println("4) 로그아웃");
		System.out.println("5) 쇼핑하기");
		System.out.println("6) 내 장바구니");
		System.out.println("------------");
	}

	private void runUserSubMenu(int select) {
		if (select == 1)
			join();
		else if (select == 2)
			leave();
		else if (select == 3)
			login();
		else if(select == 4)
			logout();
		else if(select == 5)
			shopping();
		else if (select == 6) {
			printMyCartMenu();
			runMypage(option());
		}
	}

	private void join() {
		String id = inputString("id");
		String password = inputString("password");
		String name = inputString("name");

		User user = userManager.createUser(id, password, name);
		printWelcomeMessage(user, id);
	}

	// >>> 아이디 겹칠 때 메시지 오류
	private void printWelcomeMessage(User user, String id) {
		String message = !user.equals(userManager.getUserById(id)) ? String.format("%s님 환영합니다", user.getName())
				: "회원가입 실패";
		System.out.println(message);
	}

	// 로그인 돼있어야하고 >> 나중에 추가하기
	private void leave() {
		String id = inputString("id 재확인");
		User user = userManager.getUserById(id);

		if (user != null) {
			String password = inputString("password 재확인");
			if (user.getPassword().equals(password)) {
				userManager.deleteUser(user);
				System.out.println("회원탈퇴 완료");
			}
		} else {
			System.out.println("회원정보 확인 요망");
			return;
		}
	}

	private void login() {
		String id = inputString("id");
		String password = inputString("password");

		for (int i = 0; i < userManager.getUserSize(); i++) {
			User user = userManager.getUserById(id);
			
			if (!user.getId().equals(id) || !user.getPassword().equals(password)) {
				System.err.println("회원정보 확인 요망");
				return;
			}
			log = i;
		}
		if(log != -1)
			System.out.println("로그인 완료");
	}
	
	private void logout() {
		log = -1;
		System.out.println("로그아웃 완료");
	}
	
	private void shopping() {
		itemManager.printItemAll();
		int index = inputNumber("구매할 품목")-1;
		
		if(index < 0 || index >= itemManager.getItemSize())
			return;

		int count = inputNumber("담을 수량");
		for(int i=0; i<itemManager.getItemSize(); i++) {
			Item item = itemManager.getItem(i);
			
			if(item.getItemCount() < count) {
				System.err.println("품절");
				return;
			}
			item.setItemCount(item.getItemCount()-count);
			
			userManager.getUser(log).getCart().addCart();
			System.out.println("장바구니 담기 완료");
		}
	}

	private void printMyCartMenu() {
		System.out.println("------------");
		System.out.println("1) 항목삭제");
		System.out.println("2) 수량수정");
		System.out.println("3) 결제하기");
		System.out.println("------------");
	}
	
	private void deleteOfBasket() {
		userManager.getUser(log).getCart().printMyCart();
		int index = inputNumber("삭제할 품목") - 1;
		
		if(index < 0 || index >= userManager.getUser(log).getCart().cartSize())
			return;
		
		Item item = itemManager.getItem(index);
		
		userManager.getUser(log).getCart().deleteCart(item);
	}

	private void runMypage(int select) {
		if(select == 1)
			deleteOfBasket();
//		else if(select == 2)
//			modifyOfBasket();
//		else if(select == 3)
//			purchase();
	}

	private void printAdminSubMenu() {
		System.out.println("------------");
		System.out.println("1) 아이템");
		System.out.println("2) 매출조회");
		System.out.println("------------");
	}

	private void runAdminSubMenu(int select) {
		if (select == 1) {
			printItemMenu();
			runItemSubMenu(option());
		}
//		else if(select == 2)
//			viewSales();
	}

	private void printItemMenu() {
		System.out.println("------------");
		System.out.println("1) 등록");
		System.out.println("2) 삭제");
		System.out.println("3) 가격수정");
		System.out.println("4) 수량수정");
		System.out.println("------------");
	}
	
	private void enrollItem() {
		String itemName = inputString("품목명");
		int price = inputNumber("가격");
		int itemCount = inputNumber("수량");
		
		Item item = itemManager.createItem(itemName, price, itemCount);
		System.out.printf("%s(code:%d) 등록 완료\n", itemName, item.getItemCode());
	}
	
	private void deleteItem() {
		itemManager.printItemAll();
		int index = inputNumber("삭제할 품목")-1;
		
		Item item = itemManager.getItem(index);
		itemManager.deleteItem(item);
		System.out.println("아이템 삭제 완료");
		
		// + 아이템 삭제하면 회원의 장바구니에 있는 해당 아이템도 삭제
	}

	private void runItemSubMenu(int select) {
		if(select == 1)
			enrollItem();
		else if(select == 2)
			deleteItem();
//		else if(select == 3)
//			modifyItemPrice();
//		else if(select == 4)
//			modifyItemCount();
	}

	private void runMenu(int select) {
		if (select == 1) {
			printUserSubMenu();
			runUserSubMenu(option());
		} else if (select == 2) {
			printAdminSubMenu();
			runAdminSubMenu(option());
		}
	}

	// 검수용 >>>
	private void printStatus() {
		int userSize = userManager.getUserSize();
		int itemSize = itemManager.getItemSize();

		String status = String.format("User : %d\nItem : %d", userSize, itemSize);

		System.out.println(status);
	}

	public void run() {
		while (isRun) {
			printStatus();
			printMenu();
			runMenu(option());
		}
	}

	private int option() {
		return inputNumber("선택");
	}

	private int inputNumber(String message) {
		int number = -1;
		try {
			System.out.print(message + " : ");
			String input = scanner.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		return number;
	}

	private String inputString(String message) {
		System.out.print(message + " : ");
		return scanner.next();
	}

}

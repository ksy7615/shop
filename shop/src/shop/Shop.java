package shop;

import java.util.Scanner;

public class Shop {
	private UserManager userManager = new UserManager();
	private ItemManager itemManager = new ItemManager();
	
	private Scanner scanner = new Scanner(System.in);
	
	private String shopTitle;
	private boolean isRun;
	
	
	public Shop(String shopTitle) {
		this.shopTitle = shopTitle;
		this.isRun = true;
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
		if(select == 1)
			join();
//		else if(select == 2)
//			leave();
//		else if(select == 3)
//			login();
//		else if(select == 4)
//			logout();
//		else if(select == 5)
//			shopping();
		else if(select == 6) {
			printMyCartMenu();
			runMypage(option());
		}
	}
	
	private void join() {
		
	}
	
	private void printMyCartMenu() {
		System.out.println("------------");
		System.out.println("1) 항목삭제");
		System.out.println("2) 수량수정");
		System.out.println("3) 결제하기");
		System.out.println("------------");
	}
	
	private void runMypage(int select) {
//		if(select == 1)
//			deleteOfBasket();
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
		if(select == 1) {
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
	
	private void runItemSubMenu(int select) {
//		if(select == 1)
//			enrollItem();
//		else if(select == 2)
//			deleteItem();
//		else if(select == 3)
//			modifyItemPrice();
//		else if(select == 4)
//			modifyItemCount();
	}
	
	private void runMenu(int select) {
		if(select == 1) {
			printUserSubMenu();
			runUserSubMenu(option());
		}
		else if(select == 2) {
			printAdminSubMenu();
			runAdminSubMenu(option());
		}
	}
	
	public void run() {
		while(isRun) {
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

}

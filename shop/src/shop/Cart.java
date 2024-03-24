package shop;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Item> list;

	public Cart() {
		list = new ArrayList<>();
	}

	// CRUD

	// C
	public Item addCart(Item item, int count) {
		if(item.getItemCount() >= count) {
			Item itemInCart = item.clone();
			itemInCart.setItemCount(count);
			list.add(itemInCart);
			return itemInCart;
		} else {
			return new Item();
		}
	}
	
	public Item getItemInCart () {
		for(Item item : list) {
			return item.clone();
		}
		return new Item();
	}
	
	public Item findItemInCartByCode(int code) {
		for(Item item : list) {
			if(item.getItemCode() == code) {
				return item;
			}
		}
		return new Item();
	}
	
	public void printMyCart() {
		for(int i=0; i<list.size(); i++) {
			Item item = list.get(i);
			System.out.println("MY BASKET");
			System.out.printf("%d) %s", i+1, item.getItemName());
		}
	}
	
	// 수량 수정
	public void updateCart(Item item, int count) {
		int code = item.getItemCode();
		Item target = findItemInCartByCode(code);
		target.setItemCount(count);
	}
	
	// 삭제
	public void deleteCart(Item item) {
		int code = item.getItemCode();
		Item target = findItemInCartByCode(code);
		list.remove(target);
	}
	
	public int cartSize() {
		return this.list.size();
	}

}

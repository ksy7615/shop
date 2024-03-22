package shop;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Item> list;

	public Cart() {
		list = new ArrayList<>();
	}

	// CRUD

	// C
	public Item addCart() {
		for (Item item : list) {
			if (item.getItemCode() != 0) {
				list.add(item);
				return item.clone();
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

}

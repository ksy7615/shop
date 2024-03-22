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

}

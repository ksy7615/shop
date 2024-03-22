package shop;

import java.util.ArrayList;
import java.util.Random;

public class ItemManager {
	private ArrayList<Item> itemList = new ArrayList<>();

	public ItemManager() {
	}

	// 아이템 생성
	public Item createItem(String itemName, int price) {
		int itemCode = createItemCode();
		Item item = new Item(itemName, price, itemCode);
		itemList.add(item);
		return item.clone();
	}

	private int createItemCode() {
		Random random = new Random();
		int itemCode = 0;

		while (true) {
			boolean isDupl = false;
			itemCode = random.nextInt(9000) + 1000;

			Item item = findItemByItemCode(itemCode);
			if (item.getItemCode() == 0)
				break;
		}
		return itemCode;
	}
	
	public Item findItemByItemCode(int itemCode) {
		for (Item item : itemList) {
			if (item.getItemCode() == itemCode) {
				return item.clone();
			}
		}
		return new Item();
	}

}

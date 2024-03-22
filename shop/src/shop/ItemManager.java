package shop;

import java.util.ArrayList;
import java.util.Random;

public class ItemManager {
	private ArrayList<Item> itemList = new ArrayList<>();

	public ItemManager() {
	}

	// 아이템 생성
	public Item createItem(String itemName, int price, int itemCount) {
		int itemCode = createItemCode();
		if (isValidItemCode(itemCode)) {
			Item item = new Item(itemName, price, itemCode, itemCount);
			itemList.add(item);
			return item.clone();
		}
		return new Item();
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
	
	// R
	public Item getItem(int index) {
		Item item = itemList.get(index);
		return item;
	}
	
	public Item findItemByItemCode(int itemCode) {
		for (Item item : itemList) {
			if (item.getItemCode() == itemCode) {
				return item.clone();
			}
		}
		return new Item();
	}

	public Item findItemByName(String itemName) {
		for (Item item : itemList) {
			if (item.getItemName().equals(itemName)) {
				return item.clone();
			}
		}
		return new Item();
	}

	public boolean isValidItemCode(int itemCode) {
		return itemCode != 0;
	}
	
	public void printItemAll() {
		for(int i=0; i<itemList.size(); i++) {
			Item item = itemList.get(i);
			System.out.printf("%d) %s", i+1, item.getItemName());
		}
	}
	
	// 가격 변동 업데이트
	public void updateItemPrice(Item item, int price) {
		int code = item.getItemCode();
		Item target = findItemByItemCode(code);
		target.setPrice(price);
	}
	
	// 아이템 수량 업데이트
	public void updateItemCount(Item item, int itemCount) {
		int code = item.getItemCode();
		Item target = findItemByItemCode(code);
		target.setItemCount(itemCount);
	}
	
	// D
	public void deleteItem(Item item) {
		int code = item.getItemCode();
		Item target = findItemByItemCode(code);
		itemList.remove(target);
	}
	
	public int getItemSize() {
		return this.itemList.size();
	}

}

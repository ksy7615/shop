package shop;

public class Item {
	private String itemName;
	private int price;
	private int itemCode;
	
	public Item() {
		
	}
	
	public Item(String itemName, int price, int itemCode) {
		this.itemName = itemName;
		this.price = price;
		this.itemCode = itemCode;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getItemCode() {
		return this.itemCode;
	}
	
	public Item clone() {
		return new Item(this.itemName, this.price, this.itemCode);
	}
	
}

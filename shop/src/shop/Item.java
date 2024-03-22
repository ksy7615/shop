package shop;

public class Item {
	private String itemName;
	private int price;
	private int itemCode;
	private int itemCount;
	
	public Item() {
		
	}
	
	public Item(String itemName, int price, int itemCode, int itemCount) {
		this.itemName = itemName;
		this.price = price;
		this.itemCode = itemCode;
		this.itemCount = itemCount;
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
	
	public int getItemCount() {
		return this.itemCount;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	public Item clone() {
		return new Item(this.itemName, this.price, this.itemCode, this.itemCount);
	}
	
}

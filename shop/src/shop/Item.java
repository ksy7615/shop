package shop;

public class Item {
	private String itemName;
	private int itemCount;
	
	public Item() {
		
	}
	
	public Item(String itemName, int itemCount) {
		this.itemName = itemName;
		this.itemCount = itemCount;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public int getItemCount() {
		return this.itemCount;
	}
	
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	public Item clone() {
		return new Item(this.itemName, this.itemCount);
	}
	
}

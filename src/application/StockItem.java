package application;

public class StockItem {

	private double rentalPrice;
	private String title;
	private int itemID;
	
	public StockItem(double rentalPrice, String title, int itemID)
	{
		this.rentalPrice = rentalPrice;
		this.title = title;
		this.itemID = itemID;
	}

	public double getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
}

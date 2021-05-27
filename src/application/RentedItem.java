package application;
import java.util.*;
public class RentedItem {

	private int customerID; 
	private StockItem item; 
	private Date dueDate;
	
	
	
	

	
	public RentedItem(int customerID, StockItem item, Date dueDate) {
		super();
		this.customerID = customerID;
		this.item = item;
		this.dueDate = dueDate;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public StockItem getItem() {
		return item;
	}
	public void setItem(StockItem item) {
		this.item = item;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	

}

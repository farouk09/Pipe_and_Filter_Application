package application;


public class Client {

	private double accountBalance;
	private String name;
	private int customerID;
	
	public Client(double accountBalance, String name, int customerID)
	{
		this.accountBalance = accountBalance;
		this.name = name;
		this.customerID = customerID;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
}

package application;


public class Film extends StockItem {
	private String acteur;
	
	public Film(double rentalPrice, String title, int itemID, String acteur)
	{
		super(rentalPrice, title, itemID);
		this.acteur = acteur;
	}
	
	public String getActeur() {
		return acteur;
	}

	public void setActeur(String acteur) {
		this.acteur = acteur;
	}
}

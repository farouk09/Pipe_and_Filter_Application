package application;

public class Jeux extends StockItem {

	private String plateforme;
	
	public Jeux(double rentalPrice, String title, int itemID, String plateforme)
	{
		super(rentalPrice, plateforme, itemID);
		this.plateforme = plateforme;
	}

	public String getPlateforme() {
		return plateforme;
	}

	public void setPlateforme(String plateforme) {
		this.plateforme = plateforme;
	}
	
}

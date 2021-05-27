package application;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;


public class TransactionProcessor extends Filter {
	
	
	private Map<String , Client> clients = new HashMap<String , Client >();
	private Map<String , StockItem> stockItems = new HashMap<String , StockItem >();
	private List<RentedItem> rentedItems = new ArrayList<RentedItem>();
	private int idClients;
	private int idItems;
	
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
	private String filmString;
    
    public TransactionProcessor(Map<String, Client> clients, Map<String, StockItem> stockItems,
			List<RentedItem> rentedItems, int idClients, int idItems, Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this.clients = clients;
		this.stockItems = stockItems;
		this.rentedItems = rentedItems;
		this.idClients = idClients;
		this.idItems = idItems;
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}

    public String getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}
	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub
		
		
		
		String request;
		do {
		request = _dataINPipe.dataOUT();
		
		switch(request) {
			case "1":
			filmString = "";
				String acteur = _dataINPipe.dataOUT();
				ArrayList<Film> films = NdByActor(acteur);
				for(Film film : films) {
					
			       filmString += "Titre : "+ film.getTitle() + "\n" ;	
			     
				
				}
				
				if (films.isEmpty()) {
					_dataOUTPipe.dataIN("Aucun film disponible pour cet acteur");
				} 
				
				else {
					_dataOUTPipe.dataIN(filmString);
				}
				
				
				break;
				
			case "2":
			
				String titre = _dataINPipe.dataOUT();
				if ( FindByTitle(titre))
				{
					_dataOUTPipe.dataIN("Article disponible pour la location");
				}
			
				else _dataOUTPipe.dataIN("Article non disponible pour la location ");

				break;
				
			case "3":
				
				String client = _dataINPipe.dataOUT();
				filmString = "";
				List <RentedItem> films_loués = RentedFilms(client);
				for(RentedItem film : films_loués) {
					
					
				       filmString += "Titre : "+ film.getItem().getTitle()+" Date : "+film.getDueDate().toString() + "\n" ;	}
				if (films_loués.isEmpty()) {
					_dataOUTPipe.dataIN("Aucun film loué par ce client");
				} else {
					_dataOUTPipe.dataIN(filmString);
				}
				break;
				
				
				
			case "4":
					
				String client2 = _dataINPipe.dataOUT();

				String sld = Double.toString(Solde(client2));
			
				
				
				
				List<RentedItem> overdueItems = OverdueItems() ;
				filmString = " solde du client : "+sld+"\n" + " --------------------------- \n" + "Les articles en retard : \n";

				for(RentedItem item : overdueItems) {
					
			       filmString += "Titre : "+ item.getItem().getTitle()+" Date : "+item.getDueDate().toString() + "\n" ;	
				
				}
				if (overdueItems.isEmpty()) {
					_dataOUTPipe.dataIN(filmString + " Aucun article en retard");
				} else {
					_dataOUTPipe.dataIN(filmString);
				}
				
				break;
				
				
	
				
			case "6":
				
				String client3 = _dataINPipe.dataOUT();
				String article = _dataINPipe.dataOUT();
				String dt = _dataINPipe.dataOUT();

				
				if (CheckOut(article, client3,dt))
					_dataOUTPipe.dataIN("Item rented successfully.");
				else
					_dataOUTPipe.dataIN("Operation failed.");
				
				
				break;
				
			
				
				
			case "7":
				
				

				String client4 = _dataINPipe.dataOUT();
				String article2 = _dataINPipe.dataOUT();

				
				if (CheckIn(article2, client4))
					_dataOUTPipe.dataIN("Item returned successfully.");
				else
					_dataOUTPipe.dataIN("Operation failed.");
				break;
				
				
				
			case "8":
		
				String client6 = _dataINPipe.dataOUT();
				String penality = _dataINPipe.dataOUT();
				
				double penality2 = Float.parseFloat(penality);
				
				
				if (AddPenality(client6, penality2))
					_dataOUTPipe.dataIN("Solde client débité ");
				else
					_dataOUTPipe.dataIN("Solde client insuffisant ");
				break;
				
			
				
					
			case "9":
		
				String client5 = _dataINPipe.dataOUT();
				String sld2 = _dataINPipe.dataOUT();
				Double solde = Double.parseDouble(sld2);
				AddCustomer(client5,solde);
				
				_dataOUTPipe.dataIN("Client ajouté avec succès");
				break;
				
			case "10":
				//add item
					String rentalPrice_s = _dataINPipe.dataOUT();
			
					double rentalPrice = Float.parseFloat(rentalPrice_s);
					String title = _dataINPipe.dataOUT();
					String game_s = _dataINPipe.dataOUT();
					Boolean isGame = Boolean.parseBoolean(game_s);
					String plateforme = _dataINPipe.dataOUT();
					String acteur2 = _dataINPipe.dataOUT();
					
					AddStockItem(rentalPrice, title, isGame, plateforme, acteur2);
					_dataOUTPipe.dataIN("Article ajouté avec succès");
				
				
				
				break;
		
				}}while(request!="0");
	}
	
	
	
	
	
	

	
	
	
	
	public List<RentedItem> RentedFilms(String acteur) {
		// TODO Auto-generated method stub
		ArrayList<RentedItem> Rfilms = new ArrayList<RentedItem>(); 
		Client client = clients.get(acteur);
		for (RentedItem RItem : rentedItems) {
			int id = RItem.getCustomerID();
			
			
			
			if (id==client.getCustomerID() && RItem.getItem() instanceof Film) {
				Rfilms.add(RItem);
			}
		}
		return Rfilms;
	}


	
	public void AddCustomer(String name, double accountBalance)
	{
		clients.put(name, new Client(accountBalance, name, idClients));
		idClients += 1;
	}
	
	public void AddStockItem(double rentalPrice, String title, boolean isGame, String plateforme, String acteur)
	{
		if (isGame) {
			stockItems.put(title, new Jeux(rentalPrice, title, idItems, plateforme));
		}
		else {
			stockItems.put(title, new Film(rentalPrice, title, idItems, acteur));
		}
		idItems += 1;
	}
	
	
	public boolean CheckOut(String art, String clnt , String dt) {
		for (RentedItem item : this.rentedItems) {
			if (item.getItem().getTitle().equals(art))
				return false;
		}
		StockItem item = this.stockItems.get(art);
		Client client = this.clients.get(clnt);
		if (item != null && client != null && item.getRentalPrice() <= client.getAccountBalance()) {
			client.setAccountBalance(client.getAccountBalance() - item.getRentalPrice());
			
					
			Date date1 = null;
			try {
				date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dt);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			rentedItems.add(new RentedItem(client.getCustomerID(), item, date1));
			return true;
		}
		return false;
	}

	public boolean CheckIn(String art, String clnt) {
		for (RentedItem element : rentedItems) {
			if ((element.getCustomerID() == clients.get(clnt).getCustomerID() )
					&& (element.getItem().getTitle().equals(art))) {
				rentedItems.remove(element);
				return true;
			}
		}
		return false;
	}

	
	public boolean FindByTitle(String title) {
		if (this.stockItems.containsKey(title)) {
			for (RentedItem item : this.rentedItems) {
				if (item.getItem().getTitle().equals(title))
					return false;
			}
			return true;
		} else
			return false;
	}
	
	
	
	public boolean AddPenality(String name, double penality) {
		
		Client client = this.clients.get(name);
		
			if (client.getAccountBalance() >= penality) {
				client.setAccountBalance(client.getAccountBalance() - penality);
				return true;
			}
			else {
				return false;
			}
		
	}
	
	public ArrayList<Film> NdByActor(String acteur)
	{
		ArrayList<Film> films = new ArrayList<Film>(); 
		for (String title : stockItems.keySet()) {
			StockItem item = stockItems.get(title);
			

			
			if ((item instanceof Film) && (((Film)item).getActeur().equals(acteur))) {
				
				films.add((Film)item);
			}
		}
		return films;
	}
	

	
	public double Solde(String name)
	{
		Client client = clients.get(name);
		if (client!=null) return client.getAccountBalance();
		return -1;
	}
	
	public ArrayList<RentedItem> OverdueItems()
	{
		
		Client client = new Client(150, "nassim", 1);
		Film itemm = new Film(150, "title", 1, "acteur");
		try {
		@SuppressWarnings("deprecation")
		Date dd = new Date("14/07/2020");
		this.rentedItems.add(new RentedItem(150, itemm, dd));}
		catch(Exception e) {}
		
		Date dt = new Date();
		ArrayList<RentedItem> rtItems = new ArrayList<RentedItem>();
		for (RentedItem rt : rentedItems) {
			if (rt.getDueDate().before(dt)) {
				rtItems.add(rt);
			}
		}
		return rtItems;
	}

}

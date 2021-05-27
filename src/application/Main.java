package application;
	
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
		
	
	public static void main(String[] args) {
		Map<String , Client> clients = new HashMap<String , Client >();
		Map<String , StockItem> stockItems = new HashMap<String , StockItem >();
		List<RentedItem> rentedItems = new ArrayList<RentedItem>();
		int idClients=0;
		int idItems=0;
		
		
		
		clients.put("madjid", new Client(2000, "madjid", idClients));
		idClients ++ ;
		
		clients.put("farouk", new Client(3000, "farouk", idClients));
		idClients ++ ;
		
		clients.put("sami", new Client(7000, "sami", idClients));
		idClients ++ ;
		
		clients.put("ikram", new Client(2000, "ikram", idClients));
		idClients ++ ;
		
		clients.put("ahlem", new Client(2000, "ahlem", idClients));
		idClients ++ ;
		
		clients.put("linda", new Client(6000, "linda", idClients));
		idClients ++ ;
		
		

		
		stockItems.put("destin", new Film(20, "destin", idItems, "ninho"));
		idItems ++ ;
		
		stockItems.put("mils1", new Film(15, "mils1", idItems, "ninho"));
		idItems ++ ;
		
		stockItems.put("mils2", new Film(16, "mils2", idItems, "ninho"));
		idItems ++ ;
		
		stockItems.put("mils3", new Film(17, "mils3", idItems, "ninho"));
		idItems ++ ;
		
		stockItems.put("detail", new Film(15, "detail", idItems, "kobalad"));
		idItems ++ ;

		stockItems.put("LDS", new Film(18, "LDS", idItems, "maes"));
		idItems ++ ;

		stockItems.put("ultra", new Film(25, "ultra", idItems, "booba"));
		idItems ++ ;
		
		stockItems.put("trone", new Film(30, "trone", idItems, "booba"));
		idItems ++ ;
		
		stockItems.put("lunatic", new Film(29, "lunatic", idItems, "booba"));
		idItems ++ ;

		stockItems.put("dracarys", new Film(20, "dracarys", idItems, "benab"));
		idItems ++ ;

		stockItems.put("vintage", new Film(22, "vintage", idItems, "soolking"));
		idItems ++ ;

		stockItems.put("fifa", new Jeux(60, "fifa", idItems, "xbox"));
		idItems ++ ;
		
		stockItems.put("pes", new Jeux(50, "pes", idItems, "xbox"));
		idItems ++ ;
		
		stockItems.put("rumble", new Jeux(20, "rumble", idItems, "play2"));
		idItems ++ ;

		
		Pipe p1 = new BlockingQueue();
		Pipe p2 = new BlockingQueue();
		Pipe p3 = new BlockingQueue();
		
			 
		Gui gui = new Gui();
		gui.setP1(p3) ;
		gui.setP2(p1);
		
		QueryProcessor qp = new QueryProcessor(p1 , p2);
		TransactionProcessor tp = new TransactionProcessor(clients , stockItems , rentedItems , idClients , idItems , p2 , p3);
		 
		
		new Thread() {
			
			public void run() {
				
				Application.launch(Gui.class , args);
			}
		}.start();

		
		
		Thread th2 = new Thread( qp );
	    Thread th3 = new Thread( tp );

		
		
		th2.start();  
		th3.start();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}

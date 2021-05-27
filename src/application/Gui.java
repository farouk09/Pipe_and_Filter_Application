package application;

import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Gui extends Application  {
	
    private static Pipe _dataINPipe;
    private static Pipe _dataOUTPipe;
    
    
    
    public void setP1(Pipe p) {
    	_dataINPipe = p ;
    }
    
    public void setP2(Pipe p) {
    	_dataOUTPipe = p ;
    }
    
    public void start(Stage stage) throws Exception{
    	
    	
		try {
			FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			Parent root = (Parent) fxmloader.load();
			
			Scene scene = new Scene(root,680,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			SampleController control = fxmloader.<SampleController>getController() ;
			
			control.setP1(_dataINPipe);
			control.setP2(_dataOUTPipe);
			
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
    
 
	
					
		
		
		
	}



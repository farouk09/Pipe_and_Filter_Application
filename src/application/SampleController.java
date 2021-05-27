package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SampleController extends Filter {
	
	
    public void setP1(Pipe p) {
    	_dataINPipe = p ;
    }
    
    public void setP2(Pipe p) {
    	_dataOUTPipe = p ;
    }
    
	
	
	@FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn7;

    @FXML
    void requete1(ActionEvent event) {
    	try {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("requete.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	
		requeteController control = fxmlLoader.<requeteController>getController() ;

    	control.setP1(_dataINPipe);
    	control.setP2(_dataOUTPipe);
    	
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    	}catch(Exception e ) {
    		System.out.println("cannot load ");
    	}


    }

    @FXML
    void requete2(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("requete2.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete2Controller control = fxmlLoader.<requete2Controller>getController() ;

        	control.setP1(_dataINPipe);
        	control.setP2(_dataOUTPipe);
        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete3(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("requete3.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete3Controller control = fxmlLoader.<requete3Controller>getController() ;

        	control.setP1(_dataINPipe);
        	control.setP2(_dataOUTPipe);
        	
        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete4(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("requete4.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete4Controller control = fxmlLoader.<requete4Controller>getController() ;

        	control.setP1(_dataINPipe);
        	control.setP2(_dataOUTPipe);
        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete5(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("requete5.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete5Controller control = fxmlLoader.<requete5Controller>getController() ;

        	control.setP1(_dataINPipe);
        	control.setP2(_dataOUTPipe);
        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete6(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("requete6.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete6Controller control = fxmlLoader.<requete6Controller>getController() ;

        	control.setP1(_dataINPipe);
        	control.setP2(_dataOUTPipe);
        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete7(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("requete7.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete7Controller control = fxmlLoader.<requete7Controller>getController() ;

        	control.setP1(_dataINPipe);
        	control.setP2(_dataOUTPipe);
        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

    @FXML
    void requete8(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("requete8.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	
			requete8Controller control = fxmlLoader.<requete8Controller>getController() ;

        	control.setP1(_dataINPipe);
        	control.setP2(_dataOUTPipe);
        	
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
        	}catch(Exception e ) {
        		System.out.println("cannot load ");
        	}


    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		
	}
	
}

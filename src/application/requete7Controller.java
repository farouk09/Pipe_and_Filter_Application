package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class requete7Controller extends Filter {
	
	
    public void setP1(Pipe p) {
    	_dataINPipe = p ;
    }
    
    public void setP2(Pipe p) {
    	_dataOUTPipe = p ;
    }
	
	
	@FXML
    private TextField textfield1;

    @FXML
    private Button lancer;

    @FXML
    private TextField textfield2;

    @FXML
    private RadioButton bool;
    
    @FXML
    private TextArea affichage;

    @FXML
    private TextField textfield3;

    @FXML
    private TextField textfield4;

    @FXML
    void requete(ActionEvent event) {
    	String s;
    	if (bool.isSelected()==true) {
    		s="false";
    	}
    	else {
    		s="true";
    	}
    	_dataOUTPipe.dataIN("10-"+textfield2.getText()+"-"+textfield1.getText()+"-"+s+"-"+textfield3.getText()+"-"+textfield4.getText());
    	affichage.setText(_dataINPipe.dataOUT());
    	
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

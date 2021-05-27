package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class requete6Controller extends Filter {
	
	
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
    private TextArea affichage;


    @FXML
    private TextField textfield2;

    @FXML
    void requete(ActionEvent event) {

    	_dataOUTPipe.dataIN("8-"+textfield1.getText()+"-"+textfield2.getText());
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

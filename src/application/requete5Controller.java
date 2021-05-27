package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;


public class requete5Controller extends Filter {
	
	
    public void setP1(Pipe p) {
    	_dataINPipe = p ;
    }
    
    public void setP2(Pipe p) {
    	_dataOUTPipe = p ;
    }
	
    @FXML
    private DatePicker datepicker;
    
    @FXML
    private TextField textfield1;

    @FXML
    private Button lancer;

    @FXML
    private TextField textfield2;

    @FXML
    private TextArea affichage;

    @FXML
    private TextArea affichage2;

    @FXML
    private Button lancer2;

    @FXML
    void requete(ActionEvent event) {
    	String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	_dataOUTPipe.dataIN("6-"+textfield1.getText()+"-"+textfield2.getText()+"-"+date);
    	affichage.setText(_dataINPipe.dataOUT());
    }

    @FXML
    void requete2(ActionEvent event) {
    	_dataOUTPipe.dataIN("7-"+textfield1.getText()+"-"+textfield2.getText());
    	affichage2.setText(_dataINPipe.dataOUT());

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

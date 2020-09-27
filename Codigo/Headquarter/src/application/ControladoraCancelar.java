/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import model.Bank;

public class ControladoraCancelar {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Attributes
	
    @FXML
    private Button cancelButton;

    @FXML
    private TextArea cancelText;
    
    private String id;
    
    //------------------------------------------------------------------------------------
    
    public void setBank(Bank bank) {
    	this.bank = bank;
    }
	
	//------------------------------------------------------------------------------------
    
    //Cancel method

    @FXML
    public void cancel(ActionEvent event) {
    	if(cancelText.getText().isEmpty()==false) {
    		bank.removeActiveClient(id, cancelText.getText());
    		bank.saveAction();
    	}
    	else {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Alerta");
        	alert.setHeaderText("Campo vac�o");
        	alert.setContentText("Por favor escriba su causa de cancelaci�n");

        	alert.showAndWait();
    	}
    }

	public void getId(String id) {
		this.id = id;
	}
	
	//------------------------------------------------------------------------------------

}

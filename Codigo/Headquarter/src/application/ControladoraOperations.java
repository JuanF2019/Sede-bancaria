/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControladoraOperations {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	ControladoraRetirar controladoraRetirar = new ControladoraRetirar();
	
	ControladoraConsignar controladoraConsignar = new ControladoraConsignar();
	
	ControladoraCancelar controladoraCancelar = new ControladoraCancelar();
	
	ControladoraPagar controladoraPagar = new ControladoraPagar();
	
	ControladoraDeshacer controladoraDeshacer = new ControladoraDeshacer();
	
	//------------------------------------------------------------------------------------
	
	//Attributes

    @FXML
    private Button searchButton;

    @FXML
    private TextField idText;

    @FXML
    private Label nameLabel;

    @FXML
    private ChoiceBox<?> cards;

    @FXML
    private RadioButton takeChoice;

    @FXML
    private ToggleGroup operaciones;

    @FXML
    private RadioButton recordChoice;

    @FXML
    private RadioButton cancelChoice;

    @FXML
    private RadioButton payChoice;

    @FXML
    private RadioButton breakChoice;

    @FXML
    private Pane secundaryPane;

    @FXML
    private BorderPane panelSecundario;
	
	//------------------------------------------------------------------------------------
    
    //Cancel method
	
    @FXML
    public void cancelar(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cancelar.fxml"));
		
		fxmlLoader.setController(controladoraCancelar);    
		
		Parent addContactPane = fxmlLoader.load();
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Give money method

    @FXML
    public void consignar(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Consignar.fxml"));
		
		fxmlLoader.setController(controladoraConsignar);    
		
		Parent addContactPane = fxmlLoader.load();
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Remove an action method

    @FXML
    public void deshacer(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Deshacer.fxml"));
		
		fxmlLoader.setController(controladoraDeshacer);    
		
		Parent addContactPane = fxmlLoader.load();
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Pay method

    @FXML
    public void pago(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pagar.fxml"));
		
		fxmlLoader.setController(controladoraPagar);    
		
		Parent addContactPane = fxmlLoader.load();
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Take money method

    @FXML
    public void retirar(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Retirar.fxml"));
		
		fxmlLoader.setController(controladoraRetirar);    
		
		Parent addContactPane = fxmlLoader.load();
    	
		panelSecundario.getChildren().clear();
		
		panelSecundario.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Search method

    @FXML
    public void search(ActionEvent event) {

    }
    
    //------------------------------------------------------------------------------------

}

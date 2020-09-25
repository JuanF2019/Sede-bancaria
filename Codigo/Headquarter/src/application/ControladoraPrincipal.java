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
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Bank;

public class ControladoraPrincipal {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	private Bank bank;
	
	ControladoraAdd controladoraAdd = new ControladoraAdd();
	
	ControladoraAssign controladoraAssign = new ControladoraAssign();
	
	ControladoraInformation controladoraInformation = new ControladoraInformation();
	
	ControladoraOperations controladoraOperations = new ControladoraOperations();
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the ControladoraPrincipal class
	
	@FXML
	private Pane panel;
	
	@FXML
    private BorderPane principalPane;

    @FXML
    private TableView<?> lineTable;

    @FXML
    private TableColumn<?, ?> line1;

    @FXML
    private TableColumn<?, ?> line2;
    
    //------------------------------------------------------------------------------------
    
    //Add method
    
    @FXML
    public void add(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddClient.fxml"));
		
		fxmlLoader.setController(controladoraAdd);    
		
		Parent addContactPane = fxmlLoader.load();
		
		controladoraAdd.setBank(bank);
    	
		principalPane.getChildren().clear();
		
		principalPane.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Assign method

    @FXML
    public void assign(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AsignClient.fxml"));
		
		fxmlLoader.setController(controladoraAssign);    
		
		Parent addContactPane = fxmlLoader.load();
		
		controladoraAssign.setBank(bank);
    	
		principalPane.getChildren().clear();
		
		principalPane.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //GeneralInformation method

    @FXML
    public void generalInformation(ActionEvent event) throws IOException {
    	
    	ControladoraGeneral controladoraGeneral = new ControladoraGeneral();
    	
        Stage stage = (Stage) panel.getScene().getWindow(); 
        
        stage.close();
        
        // ******************************************
    	
    	Stage primaryStage = new Stage();
    	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GeneralInformation.fxml"));

		fxmlLoader.setController(controladoraGeneral);
		
		Parent root = fxmlLoader.load();
		
		controladoraGeneral.setBank(bank);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Sede bancaria");
		
		primaryStage.show();

    }
    
    //------------------------------------------------------------------------------------
    
    //Information method

    @FXML
    public void information(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InformationClient.fxml"));
		
		fxmlLoader.setController(controladoraInformation);    
		
		Parent addContactPane = fxmlLoader.load();
		
		controladoraInformation.setBank(bank);
    	
		principalPane.getChildren().clear();
		
		principalPane.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    //Operations method

    @FXML
    void operations(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OperationsClient.fxml"));
		
		fxmlLoader.setController(controladoraOperations);  
		
		Parent addContactPane = fxmlLoader.load();

		controladoraOperations.setBank(bank);
    	
		principalPane.getChildren().clear();
		
		principalPane.setCenter(addContactPane);

    }
    
    //------------------------------------------------------------------------------------
    
    @FXML
    void initialize() {
		Bank bank = new Bank("Bancolombia");
    }

	public void setBank(Bank bank) {
		this.bank = bank;
	}
    
    //------------------------------------------------------------------------------------

}

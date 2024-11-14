/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class RegistroClienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private ComboBox cmbTipoCliente;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.inicializarComboTipo();
        
    } 
    
    private void inicializarComboTipo(){
        ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Cliente basico",
        "Cliente premium"
    );
       this.cmbTipoCliente.getItems().clear();
       this.cmbTipoCliente.getItems().addAll(options);
    }
    
}

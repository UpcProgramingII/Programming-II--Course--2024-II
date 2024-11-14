/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class PrincipalController implements Initializable {

    
    /**
     * Initializes the controller class.
     */
    
    @FXML private StackPane panel;
    
    @FXML
    private void clcikBtnClientes() throws IOException{
        
        this.panel.getChildren().clear();
        StackPane panelClientes = new StackPane(App.loadFXML("RegistroCliente"));
        this.panel.getChildren().add(panelClientes);
        
    }
    
    @FXML
    private void clickBtnCuentas() throws IOException{
        this.panel.getChildren().clear();
        AnchorPane panelCuentas = new AnchorPane(App.loadFXML("RegistroCuentas"));
        this.panel.getChildren().add(panelCuentas);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

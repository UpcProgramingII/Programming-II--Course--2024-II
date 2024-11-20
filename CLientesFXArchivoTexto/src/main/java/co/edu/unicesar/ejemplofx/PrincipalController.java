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
import javafx.geometry.Pos;
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
        
        this.cargarPanel("RegistroCliente");
        
        
    }
    
    @FXML
    private void clickBtnCuentas() throws IOException{
        this.cargarPanel("RegistroCuentas");
        
    }
    
    @FXML
    private void clickBtnListaCliente() throws IOException{
        this.cargarPanel("ListaCliente");
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    private void cargarPanel(String fxmlName) throws IOException{
        this.panel.getChildren().clear();
        AnchorPane panelCuentas = new AnchorPane(App.loadFXML(fxmlName));
        this.panel.getChildren().add(panelCuentas);
    }
    
}

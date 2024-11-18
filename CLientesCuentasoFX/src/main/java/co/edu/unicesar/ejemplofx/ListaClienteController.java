/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofx;

import co.edu.unicesar.ejemplofx.dto.ClienteDtoTable;
import co.edu.unicesar.ejemplofx.modelo.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class ListaClienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox<String> cmbTipoCliente;
    
    @FXML
    private TableView<ClienteDtoTable> tablaCliente;
    
    @FXML
    private TableColumn<ClienteDtoTable,String> id, nombre, apellido, tipo, transacciones;
    
    private ObservableList<ClienteDtoTable> data;
    
    @FXML
    private void onClickFiltro(){
        this.cargarTabla(this.cmbTipoCliente.getSelectionModel().getSelectedItem().toString());
    }
    
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.inicializarCmbTipo();
        
        this.id.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.apellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.tipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        this.transacciones.setCellValueFactory(new PropertyValueFactory("transaccion"));
        
        this.data = FXCollections.observableArrayList();
        this.cargarTabla(null);
        
    }  
    
    
    private void inicializarCmbTipo(){
        ObservableList<String> options=FXCollections.observableArrayList("Cliente basico","Cliente premium");
        this.cmbTipoCliente.getItems().setAll(options);
    }
    
    private void cargarTabla(String tipo){
        this.data.clear();
        for(Cliente c: App.logicaCliente.getCLientes()){
            ClienteDtoTable dto = new ClienteDtoTable(c);
            if(tipo==null){
                this.data.add(dto);
            }else{
                if(tipo.equals(dto.getTipo())){
                    this.data.add(dto);
                }
            }
        }
        
        this.tablaCliente.setItems(this.data);
    }
    
    
    
}

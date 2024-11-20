/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofx;

import co.edu.unicesar.ejemplofx.logica.LogicaCliente;
import co.edu.unicesar.ejemplofx.modelo.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class RegistroClienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox cmbTipoCliente;
    @FXML
    private TextField txtId, txtNombre, txtApellido;
    @FXML
    private Spinner<Integer> txtTransacciones;

    private LogicaCliente logica = new LogicaCliente();

    @FXML
    private void btnClickGuardar() {

        String id = this.txtId.getText();
        String nombre = this.txtNombre.getText();
        String apellido = this.txtApellido.getText();
        String tipo = this.cmbTipoCliente.getSelectionModel().getSelectedItem().toString();
        Integer noTransacciones = this.txtTransacciones.getValue();

        Cliente cliente = this.logica.crearCliente(id, nombre, apellido, tipo, noTransacciones);
        try {
            this.logica.addCliente(cliente);
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setHeaderText("Cliente registrado con exito");
            alerta.setTitle("Registro Exitoso");
            alerta.show();

        } catch (Exception ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(ex.getMessage());
            alerta.setTitle("Error en el registro");
            alerta.show();
        }

        //System.out.println(App.logicaCliente.getCLientes().size());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.inicializarComboTipo();
        this.setValueSpinnerTransaccion();
    }

    private void inicializarComboTipo() {
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Cliente basico",
                        "Cliente premium"
                );
        this.cmbTipoCliente.getItems().clear();
        this.cmbTipoCliente.getItems().addAll(options);
    }

    private void setValueSpinnerTransaccion() {
        SpinnerValueFactory valueFactoryDuracion = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
        this.txtTransacciones.setValueFactory(valueFactoryDuracion);
    }

}

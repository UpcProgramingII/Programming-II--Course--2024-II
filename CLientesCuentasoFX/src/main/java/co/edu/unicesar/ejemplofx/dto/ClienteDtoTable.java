/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.dto;

import co.edu.unicesar.ejemplofx.modelo.Cliente;
import co.edu.unicesar.ejemplofx.modelo.ClienteBasico;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jairo F
 */
public class ClienteDtoTable {
    
    private SimpleStringProperty id;
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellido;
    private SimpleStringProperty tipo;
    private SimpleStringProperty transaccion;

    public ClienteDtoTable(Cliente cliente) {
        this.id = new SimpleStringProperty(cliente.getId());
        this.nombre = new SimpleStringProperty(cliente.getNombre());
        this.apellido = new SimpleStringProperty(cliente.getApellido());
        
        if(cliente instanceof ClienteBasico){
            int n = ((ClienteBasico)cliente).getNO_MAX_TRANSACCIONES();
            this.transaccion = new SimpleStringProperty(String.valueOf(n));
            this.tipo = new SimpleStringProperty("Cliente basico");
        }
        else{
            this.transaccion = new SimpleStringProperty("");
            this.tipo = new SimpleStringProperty("Cliente premium");
        }
        
    }

    public String getId() {
        return id.getValue();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getApellido() {
        return apellido.get();
    }

    public String getTipo() {
        return tipo.get();
    }

    public String getTransaccion() {
        return transaccion.get();
    }
    
    
    
    
    
}

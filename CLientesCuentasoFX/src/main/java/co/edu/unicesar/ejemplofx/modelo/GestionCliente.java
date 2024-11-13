/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.modelo;

import co.edu.unicesar.ejemplofx.persistencia.IArchivoCliente;
import co.edu.unicesar.ejemplofx.persistencia.MapaCliente;
import java.util.List;


/**
 *
 * @author Jairo F
 */
public class GestionCliente {
    private IArchivoCliente clientes;

    public GestionCliente() {
        this.clientes = new MapaCliente();
    }
    
    public void registrarCliente(Cliente c){
        this.clientes.registrarCliente(c);
    }
    
    public Cliente consultarCliente(String id) {
        
        return this.clientes.consultarCliente(id);
    }
    
    public List<Cliente> listarClientes() {
        return this.clientes.listarClientes();
    }
}

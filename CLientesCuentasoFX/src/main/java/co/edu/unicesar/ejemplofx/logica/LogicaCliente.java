/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.logica;

import co.edu.unicesar.ejemplofx.modelo.*;
import co.edu.unicesar.ejemplofx.persistencia.IArchivoCliente;
import co.edu.unicesar.ejemplofx.persistencia.MapaCliente;
import java.util.List;


/**
 *
 * @author Jairo F
 */
public class LogicaCliente {
    
    private IArchivoCliente clientes;

    public LogicaCliente() {
        this.clientes = new MapaCliente();
    }
    
    public void addCliente(Cliente cliente){
    
        this.clientes.registrarCliente(cliente);
        System.out.println(clientes.listarClientes().size());
    }
    
    public List<Cliente> getCLientes(){
        
        return this.clientes.listarClientes();
        
    }
    
    public Cliente crearCliente(String id, String nombre, String apellido, String tipo, Integer n){
        Cliente cliente;
        if(tipo.equals("Cliente basico")){
            cliente = new ClienteBasico(n, nombre, apellido, id);
        }else{
            cliente = new ClientePremium(nombre, apellido, id);
        }
        
        return cliente;
    }
    
    
    
}

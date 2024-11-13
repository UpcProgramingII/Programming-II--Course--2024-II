/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.persistencia;

import java.util.ArrayList;
import java.util.List;
import co.edu.unicesar.ejemplofx.modelo.Cliente;

/**
 *
 * @author Jairo F
 */
public class ListaCliente implements IArchivoCliente {
    
    private List<Cliente> lista;

    public ListaCliente() {
        this.lista = new ArrayList();
    }
    
    @Override
    public void registrarCliente(Cliente c) {
            this.lista.add(c);
    }

    @Override
    public Cliente consultarCliente(String id) {
        
        Cliente encontrado = null;
        for(Cliente c: this.lista){
            if(c.getId().equalsIgnoreCase(id)){
                encontrado = c;
                break;
            }
        }
        return encontrado;
        
    }

    @Override
    public List<Cliente> listarClientes() {
    
         List<Cliente> listaCliente = new ArrayList(this.lista);        
         return listaCliente;
         
    }
    
}

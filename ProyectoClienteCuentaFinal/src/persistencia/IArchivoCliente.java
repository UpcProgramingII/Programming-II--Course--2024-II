/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Jairo F
 */
public interface IArchivoCliente {
    
    void registrarCliente(Cliente c);
    Cliente consultarCliente(String id);
    List<Cliente> listarClientes();
    
}

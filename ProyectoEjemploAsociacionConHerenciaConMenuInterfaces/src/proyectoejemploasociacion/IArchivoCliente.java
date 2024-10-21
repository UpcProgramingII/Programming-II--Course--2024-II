/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoejemploasociacion;

import java.util.List;

/**
 *
 * @author Jairo F
 */
public interface IArchivoCliente {
    
    void registrarCliente(Cliente c);
    Cliente consultarCliente(String id);
    List<Cliente> listarClientes();
    
}

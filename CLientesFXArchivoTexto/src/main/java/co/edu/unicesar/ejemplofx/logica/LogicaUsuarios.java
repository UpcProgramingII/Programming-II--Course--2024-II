/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.logica;

import co.edu.unicesar.ejemplofx.modelo.Usuario;
import co.edu.unicesar.ejemplofx.persistencia.UsersCollections;

/**
 *
 * @author Jairo F
 */
public class LogicaUsuarios {
    private UsersCollections usuarios;

    public LogicaUsuarios() {
        this.usuarios = new UsersCollections();
    }
    
    public Usuario buscarUsuario(String username){
        return this.usuarios.getUsuario(username);
    }
    
}

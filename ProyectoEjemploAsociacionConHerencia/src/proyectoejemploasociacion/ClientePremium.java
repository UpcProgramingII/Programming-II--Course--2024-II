/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoejemploasociacion;

import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class ClientePremium extends Cliente {

    public ClientePremium() {
    }

    public ClientePremium(String nombre, String apellido, String id) {
        super(nombre, apellido, id);
    }
     
    
    @Override
    public void retirarDeCuenta(double monto, Cuenta c){
        c.retirar(monto);
    }
    
    @Override
    public void consignarACuenta(double monto, Cuenta c){
        c.consignar(monto);
    }
    
   

    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoejemploasociacion;

import java.time.LocalDate;

/**
 *
 * @author Jairo F
 */
public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Cuenta miCuenta = new Cuenta(100, 5000, LocalDate.now());
        Cliente yo = new Cliente("Jairo", "Seoanes", "XXX", miCuenta);
        System.out.println(yo);
        
    }
    
}

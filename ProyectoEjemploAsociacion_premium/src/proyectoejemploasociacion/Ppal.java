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
        
        Cuenta miCuenta = new Cuenta("CC001",100, 5000, LocalDate.now());
//        Cliente yo = new Cliente("Jairo", "Seoanes", "XXX", miCuenta);
//        System.out.println(yo);
//        
//        System.out.println("-------------------------------");
//        
        Cuenta nuevaCuenta = new Cuenta("CC002",0, 10000, LocalDate.now());
//        System.out.println(yo);
//        System.out.println("Registro de movimientos: ");
//        yo.setCuenta(nuevaCuenta);
//        yo.imprimirSaldoCuenta();
//        yo.getCuenta().consignar(2000);
//        yo.imprimirSaldoCuenta();
//        yo.retirarDeMiCuenta(500);
//        yo.imprimirSaldoCuenta();
//        System.out.println(yo);
        
        
        System.out.println("Cliente Premium: ");
        ClientePremium premium = new ClientePremium("abc", "Lule", "Ardila");
        premium.registrarCuenta(miCuenta);
        premium.registrarCuenta(nuevaCuenta);
        System.out.println(premium);
        premium.imprimirNoCuentasRegistradas();
        
        Cuenta buscada = premium.consultarCuenta("CC004");
        if(buscada != null){
            System.out.println("Datos cuenta consultada: ");
            System.out.println(buscada);
        }
        else{
            System.out.println("La cuenta no esta registrada");
        }
        
        
    }
    
}

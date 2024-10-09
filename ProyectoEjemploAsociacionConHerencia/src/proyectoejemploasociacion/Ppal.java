/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoejemploasociacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        Cuenta cuentaA = new Cuenta("CC001",100, 5000, LocalDate.now());
        CuentaRestringida cuentaB = new CuentaRestringida(500, "CC002",0, 10000, LocalDate.now());
        
        Cliente basico = new ClienteBasico("Luis", "Diaz", "12345");
        Cliente premium = new ClientePremium("Jairo", "Seoanes", "456");
        
        basico.consignarACuenta(0, cuentaA);
        
        
        List<Cliente> clienteList = new ArrayList();
        clienteList.add(premium);
        clienteList.add(basico);
        
        imprimirClientes(clienteList);
        imprimirCuenta(cuentaA);
        
        
    }
    
    public Cuenta buscarCuenta(Cliente cliente, String id){
        return cliente.consultarCuenta(id);
    }
    
    public void registrarCuenta(Cliente cliente, Cuenta cuenta){
        cliente.registrarCuenta(cuenta);
    }
    
    public static void imprimirClientes(List<Cliente> lista){
        for(Cliente c: lista){
            System.out.println(c);
        }
    }
    
    public static void imprimirCuenta(Cuenta cuenta){
        if(cuenta==null){
            System.out.println("La cuenta no existe o es null");
        }else{
            System.out.println("Datos cuenta: ");
            System.out.println("------------------------------");
            System.out.println(cuenta);
            System.out.println("Movimientos: ");
            System.out.println("------------------------------");
            for(Movimiento m: cuenta.getMovimientos()){
                System.out.println(m);
            }
            System.out.println("------------------------------");
            System.out.println("Total movimientos: " + cuenta.getNoMovimientos());
        }
    }
    
}

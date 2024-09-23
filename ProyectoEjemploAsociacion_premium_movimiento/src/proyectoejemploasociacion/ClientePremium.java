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
public class ClientePremium {
    
    private String id;
    private String nombre;
    private String apellido;
    
    //relacion de 1 a varios con cuente
    private ArrayList<Cuenta> misCuentas;

    public ClientePremium() {
        this.misCuentas = new ArrayList();
    }

    public ClientePremium(String id, String apellido, String nombre) {
        this.id = id;
        this.apellido = apellido;
        this.nombre =nombre;
        this.misCuentas = new ArrayList();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the misCuentas
     */
    public ArrayList<Cuenta> getMisCuentas() {
        return misCuentas;
    }

    /**
     * @param misCuentas the misCuentas to set
     */
    public void setMisCuentas(ArrayList<Cuenta> misCuentas) {
        this.misCuentas = misCuentas;
    }
    
    
    
    public void registrarCuenta(Cuenta c){
        this.misCuentas.add(c);
    }

    @Override
    public String toString() {
        return "ClientePremium{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", misCuentas=" + misCuentas + '}';
    }
    
    
    public void imprimirNoCuentasRegistradas(){
        System.out.println("No de cuentas registradas: " + this.misCuentas.size());
    }
    
    public Cuenta consultarCuenta(String id){
        
        Cuenta buscada = null;
        for(Cuenta c : this.misCuentas){
            if(c.getId().equalsIgnoreCase(id)){
                buscada =  c;
                break;
            }
        }
        return buscada;
        
    }
    
     public void retirarDeMiCuenta(double monto, Cuenta c){
        c.retirar(monto);
    }
    
    public void consignarAMiCuenta(double monto, Cuenta c){
        c.consignar(monto);
    }
    
    public void imprimirHistoricoCuenta(Cuenta c){
        c.imprimirMovimientos();
    }
    
}

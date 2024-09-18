/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoejemploasociacion;

/**
 *
 * @author Jairo F
 */
public class Cliente {
    
    private String nombre;
    private String apellido;
    private String id;
    
    // atributo resultado de la relacion de asociacio cliente->cuenta
    private Cuenta cuenta;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String id, Cuenta cuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", cuenta=" + cuenta + '}';
    }
    
    
    public void retirarDeMiCuenta(double monto){
        this.cuenta.retirar(monto);
    }
    
    
    public void imprimirSaldoCuenta(){
        System.out.println("saldo actual: " + this.cuenta.getSaldo());
    }
    
    
    
}

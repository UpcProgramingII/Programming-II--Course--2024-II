/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoejemploasociacion;

/**
 *
 * @author Jairo F
 */
public class ClienteBasico extends Cliente {
    private int NO_MAX_TRANSACCIONES=5;
    private int noTransaccionesRealizadas;
   
    public ClienteBasico() {
        this.noTransaccionesRealizadas=0;
    }

    public ClienteBasico(String nombre, String apellido, String id) {
        super(nombre, apellido, id);
        this.noTransaccionesRealizadas=0;
    }

    public ClienteBasico(int noTransacciones, String nombre, String apellido, String id) {
        super(nombre, apellido, id);
        this.noTransaccionesRealizadas=noTransacciones;
    }
    
    public int getNO_MAX_TRANSACCIONES() {
        return NO_MAX_TRANSACCIONES;
    }

    public void setNO_MAX_TRANSACCIONES(int NO_MAX_TRANSACCIONES) {
        this.NO_MAX_TRANSACCIONES = NO_MAX_TRANSACCIONES;
    }

    public int getNoTransaccionesRealizadas() {
        return noTransaccionesRealizadas;
    }

    public void setNoTransaccionesRealizadas(int noTransaccionesRealizadas) {
        this.noTransaccionesRealizadas = noTransaccionesRealizadas;
    }
    
    private boolean permitirTransaccion(){
        return this.noTransaccionesRealizadas<this.NO_MAX_TRANSACCIONES-1;
    }
    
    private void registrarTransaccion(){
        this.noTransaccionesRealizadas++;
    }
    
    @Override
    public void retirarDeCuenta(double monto, Cuenta c) {
        if(this.permitirTransaccion()){
            c.retirar(monto);
            this.registrarTransaccion();
        }
    }

    @Override
    public void consignarACuenta(double monto, Cuenta c) {
        if(this.permitirTransaccion()){
            c.consignar(monto);
            this.registrarTransaccion();
        }
    }

    @Override
    public String toString() {
        return "ClienteBasico{"+super.toString() + ", NO_MAX_TRANSACCIONES=" + NO_MAX_TRANSACCIONES + ", noTransaccionesRealizadas=" + noTransaccionesRealizadas + '}';
    }
    
    
    
    
    
}

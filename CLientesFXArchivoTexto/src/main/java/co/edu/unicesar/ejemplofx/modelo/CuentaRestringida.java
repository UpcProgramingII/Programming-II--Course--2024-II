/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.modelo;

import java.time.LocalDate;

/**
 *
 * @author Jairo F
 */
public class CuentaRestringida extends Cuenta {
    
    private double limiteMaximoValorTransaccion;

    public CuentaRestringida() {
        
    }

    public CuentaRestringida(double limiteMaximoValorTransaccion, String id, double saldo, double limite, LocalDate fechaApertura) {
        super(id, saldo, limite, fechaApertura);
        this.limiteMaximoValorTransaccion = limiteMaximoValorTransaccion;
    }

    public double getLimiteMaximoValorTransaccion() {
        return limiteMaximoValorTransaccion;
    }

    public void setLimiteMaximoValorTransaccion(double limiteMaximoValorTransaccion) {
        this.limiteMaximoValorTransaccion = limiteMaximoValorTransaccion;
    }

    @Override
    public String toString() {
        return "CuentaRestringida{"+ super.toString() + "limiteMaximoValorTransaccion=" + limiteMaximoValorTransaccion + '}';
    }

    @Override
    public void retirar(double monto) {
        if(this.validarMontoOperacion(monto))
            super.retirar(monto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consignar(double monto) {
       if(this.validarMontoOperacion(monto))
        super.consignar(monto); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean validarMontoOperacion(double monto){
    
        return this.limiteMaximoValorTransaccion<=monto;
        
    }
    
    
    
    
}

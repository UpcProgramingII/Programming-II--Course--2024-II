/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class Cuenta implements Serializable {

    private String id;
    private double saldo;
    private double limite;
    private LocalDate fechaApertura;
    private List<Movimiento> movimientos;

    public Cuenta() {
        this.movimientos = new ArrayList();
        this.fechaApertura = LocalDate.now();
    }

    public Cuenta(String id, double saldo, double limite, LocalDate fechaApertura) {
        this.movimientos = new ArrayList();
        this.saldo = saldo;
        this.limite = limite;
        this.fechaApertura = fechaApertura;
        this.id = id;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", saldo=" + saldo + ", limite=" + limite + ", fechaApertura=" + fechaApertura + '}';
    }

    public void consignar(double monto) {
       this.saldo += monto;
       this.crearMovimiento(monto, this.saldo, "Ingreso");
    }

    public void retirar(double monto) {
       
        this.saldo -= monto;
        this.crearMovimiento(monto, this.saldo, "Egreso");
        
    }
    
    public void crearMovimiento(double monto, double saldoFinal, String tipo){
        double saldoInicial;
        if(tipo.equalsIgnoreCase("ingreso")){
            saldoInicial = saldoFinal - monto;
        }else{
            saldoInicial = saldoFinal + monto;
        }
        Movimiento m = new Movimiento(saldoInicial, monto, this.saldo, tipo);
        this.movimientos.add(m);
        
    }
    
    public int getNoMovimientos(){
        return this.movimientos.size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

}

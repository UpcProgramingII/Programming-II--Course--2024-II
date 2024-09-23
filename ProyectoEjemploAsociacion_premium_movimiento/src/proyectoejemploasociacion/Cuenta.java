/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoejemploasociacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class Cuenta {

    private String id;
    private double saldo;
    private double limite;
    private LocalDate fechaApertura;
    private List<Movimiento> movimientos;

    public Cuenta() {
        this.movimientos = new ArrayList();
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
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void imprimirMovimientos(){
        System.out.println("Historico de mocimientos de cuenta: ");
        System.out.println("----------------------------------------");
        for(Movimiento m: this.movimientos){
            System.out.println(m);
        }
        System.out.println("----------------------------------------");
        System.out.println("Total movimientos: " + this.movimientos.size());
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoejemploasociacion;

import java.time.LocalDate;

/**
 *
 * @author Jairo F
 */
public class Cuenta {
    
    private String id;
    private double saldo;
    private double limite;
    private LocalDate fechaApertura;

    public Cuenta() {
    }

    public Cuenta(String id, double saldo, double limite, LocalDate fechaApertura) {
        this.saldo = saldo;
        this.limite = limite;
        this.fechaApertura = fechaApertura;
        this.id = id;
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

   
    
    
    
    public void consignar(double monto){
        this.saldo+=monto;
    }
    
    public void retirar(double monto){
        this.saldo-=monto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}

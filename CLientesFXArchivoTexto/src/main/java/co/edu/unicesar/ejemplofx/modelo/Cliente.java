/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.modelo;

import co.edu.unicesar.ejemplofx.excepciones.EstadoDeCuentaIncorrectoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public abstract class Cliente {

    private String nombre;
    private String apellido;
    private String id;
    private ArrayList<Cuenta> cuentas;

    public Cliente() {
        this.cuentas = new ArrayList();
    }

    public Cliente(String nombre, String apellido, String id) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
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

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void registrarCuenta(Cuenta c) throws EstadoDeCuentaIncorrectoException {
            
        if(c.getSaldo()<0)
            throw new IllegalStateException("Cuenta con saldo negativo");
        
        if(c.getLimite()<0)
            throw new EstadoDeCuentaIncorrectoException("Cuenta con limite negativo");
        
        if(c instanceof CuentaRestringida){
            if(((CuentaRestringida)c).getLimiteMaximoValorTransaccion()<0)
                throw new EstadoDeCuentaIncorrectoException("Cuenta con limite maximo negativo");
        }
        
        this.cuentas.add(c);
    }

    public Cuenta consultarCuenta(String id) {

        Cuenta encontrada = null;
        for (Cuenta c : this.cuentas) {
            if (c.getId().equalsIgnoreCase(id)) {
                encontrada = c;
                break;
            }
        }
        return encontrada;

    }

    public List<Movimiento> getHistoricoCuenta(Cuenta c) {
        return c.getMovimientos();
    }
    
    public int getNoCuentasRegistradas() {
        return this.cuentas.size();
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + '}';
    }

    public abstract void retirarDeCuenta(double monto, Cuenta c);
    
    public abstract void consignarACuenta(double monto, Cuenta c);
    
    public String getFormatFile(){
        
        return this.id+";"+this.nombre+";"+this.apellido;
    }
}

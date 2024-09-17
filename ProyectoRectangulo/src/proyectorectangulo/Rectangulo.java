/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectorectangulo;

/**
 *
 * @author Jairo F
 */
public class Rectangulo {
    
    // atributos de instancia
    private double base;
    private double altura;
    
    // atributo de clase
    public static int BORDE = 5;
    
    // metodo constructor por default
    
    public Rectangulo(){
        this.altura = 10;
        this.base=5;
    }
    
    // definicion constructor sobrecargado con base y altura
    public Rectangulo(double altura, double base){
            
        this.altura = altura;
        this.base = base;
    }
    
    //  contructor sobrecargado con altura
    
    public Rectangulo(double altura){
        this.base = 30;
        this.altura = altura;
        
    }
    
    // getter y setter de la base
    public double getBase(){
        return this.base;
    }
    
    // setter base
    
    public void setBase(double base){
        this.base = base;
    }
    
    public double getAltura(){
        return this.altura;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    // metodo miembro calcularArea
    
    public double calcularArea(){
        
        return this.base * this.altura;
        
    }
    
    
    public double sumarArea(Rectangulo r){
        return this.sumarArea(r.calcularArea());
    }
    
    
    public double sumarArea(double base, double altura){
        
        Rectangulo aux = new Rectangulo(base, altura);
        return this.sumarArea(aux);
        
    }
    
    public double sumarArea (double area){
        return this.calcularArea() + area;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectorectangulo;

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
        Rectangulo.BORDE = 10;
        Rectangulo r1 = new Rectangulo();
        imprimirRectangulo(r1);
        
        Rectangulo r2 = new Rectangulo();
        r2.setBase(100);
        r2.setAltura(400);
        imprimirRectangulo(r2);
        
        Rectangulo r3 = new Rectangulo(50, 20);
        imprimirRectangulo(r3);
        
        Rectangulo r4 = new Rectangulo(40);
        imprimirRectangulo(r4);
        
        System.out.println("Area r1 + area r3 = " + r1.sumarArea(r3));
        
    }
    
    public static void imprimirRectangulo(Rectangulo r){
        System.out.println("Base = " + r.getBase());
        System.out.println("Altura  = " + r.getAltura());
        System.out.println("Borde  = " + Rectangulo.BORDE);
        System.out.println("Area  = " + r.calcularArea());
        System.out.println("------------------------------------");
    }
    
}

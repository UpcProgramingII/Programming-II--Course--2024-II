/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.persistencia;

import co.edu.unicesar.ejemplofx.modelo.Cliente;
import co.edu.unicesar.ejemplofx.modelo.ClienteBasico;
import co.edu.unicesar.ejemplofx.modelo.ClientePremium;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jairo F
 */
public class ArchivoTextoCliente implements IArchivoCliente {

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoTextoCliente() {
        this("Clientes.dat");
    }

    public ArchivoTextoCliente(String name) {
        this.archivo = new File(name);
    }

    @Override
    public void registrarCliente(Cliente c) throws RuntimeException {

        PrintWriter pw = null;
        try {

            this.aEscritura = new FileWriter(this.archivo, true);
            pw = new PrintWriter(this.aEscritura);
            pw.println(c.getFormatFile());

        } catch (IOException ex) {
            throw new RuntimeException("Error al abrir archivo para escritura");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    @Override
    public Cliente consultarCliente(String id) {
        return null;
    }
    
    private Cliente crearCliente(String linea){
        
        Cliente cliente;
        String datos[] = linea.split(";");
        if(datos[3].equals("Cliente premium")){
            cliente = new ClientePremium(datos[1], datos[2], datos[0]);
        }else{
           int nt = Integer.valueOf(datos[4]);
           cliente = new ClienteBasico(nt, datos[1], datos[2], datos[0]); 
        }
        
        
        return cliente;
    }

    @Override
    public List<Cliente> listarClientes() {

        List<Cliente> clientesLeidos = new ArrayList();
        try {
            
            this.aLectura = new Scanner(this.archivo);
            while(this.aLectura.hasNext())
            {
                String linea = this.aLectura.nextLine();
                Cliente cliente = this.crearCliente(linea);
                clientesLeidos.add(cliente);
            }
            return clientesLeidos;
            
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Error al abrir archivo para lectura");
        }
        finally{
            if(this.aLectura!=null){
                this.aLectura.close();
            }
        }

    }

}

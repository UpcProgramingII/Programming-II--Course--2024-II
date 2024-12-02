/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofx.persistencia;

import co.edu.unicesar.ejemplofx.modelo.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jairo F
 */
public class ArchivoObjetoCliente implements IArchivoCliente {

    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEcritura;

    public ArchivoObjetoCliente(String name) {
        this.archivo = new File(name);
    }

    public ArchivoObjetoCliente() {
        this("Clientes.obj");
    }

    private void guardar(IArchivoCliente data) {
        ObjectOutputStream oos=null;
        try {
            this.aEcritura = new FileOutputStream(this.archivo);
            oos = new ObjectOutputStream(this.aEcritura);
            oos.writeObject(data);
            
        } catch (FileNotFoundException ex) {
           throw new RuntimeException("Error el archivo no existe"); 
        }catch (IOException ex) {
            throw new RuntimeException("Error al abrir archivo de escritura");
        }
        finally{
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException ex) { }
            }
        }
        
    }

    private IArchivoCliente leer() {
        IArchivoCliente data;

        if (!this.archivo.exists()) {
            data = new ListaCliente();
            return data;
        }

        ObjectInputStream ois = null;
        try {
            this.aLectura = new FileInputStream(this.archivo);
            ois = new ObjectInputStream(this.aLectura);
            data = (IArchivoCliente) ois.readObject();
            return data;

        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Error al abrir archivo");
        } catch (IOException ex) {
            throw new RuntimeException("Error al leer archivo");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Archivo con formato incorrecto");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) { }
            }
        }

    }

    @Override
    public void registrarCliente(Cliente c) {
        
        IArchivoCliente data = this.leer();
        data.registrarCliente(c);
        this.guardar(data);

    }

    @Override
    public Cliente consultarCliente(String id) {
        IArchivoCliente data = this.leer();
        return data.consultarCliente(id);
    }

    @Override
    public List<Cliente> listarClientes() {
       
        IArchivoCliente data = this.leer();
        return new ArrayList(data.listarClientes());
        
    }

}

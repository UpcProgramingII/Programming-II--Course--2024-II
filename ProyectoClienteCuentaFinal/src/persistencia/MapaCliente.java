/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Cliente;

/**
 *
 * @author Jairo F
 */
public class MapaCliente implements IArchivoCliente {
    private Map<String, Cliente> mapa;

    public MapaCliente() {
        this.mapa = new HashMap();
    }
    
    @Override
    public void registrarCliente(Cliente c) {
        this.mapa.put(c.getId(), c);
    }

    @Override
    public Cliente consultarCliente(String id) {
        Cliente c = this.mapa.get(id);
        return c;
    }

    @Override
    public List<Cliente> listarClientes() {
         List<Cliente> lista = new ArrayList();
         for(String key: this.mapa.keySet()){
             Cliente c = this.mapa.get(key);
             lista.add(c);
         }
         return lista;
    }
    
}

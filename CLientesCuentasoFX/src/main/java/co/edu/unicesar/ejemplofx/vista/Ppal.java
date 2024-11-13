/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.unicesar.ejemplofx.vista;

import co.edu.unicesar.ejemplofx.excepciones.EstadoDeCuentaIncorrectoException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import co.edu.unicesar.ejemplofx.modelo.Cliente;
import co.edu.unicesar.ejemplofx.modelo.ClienteBasico;
import co.edu.unicesar.ejemplofx.modelo.ClientePremium;
import co.edu.unicesar.ejemplofx.modelo.Cuenta;
import co.edu.unicesar.ejemplofx.modelo.CuentaRestringida;
import co.edu.unicesar.ejemplofx.modelo.GestionCliente;
import co.edu.unicesar.ejemplofx.modelo.Movimiento;

/**
 *
 * @author Jairo F
 */
public class Ppal {

    /**
     * @param args the command line arguments
     */
    static Scanner scanner = new Scanner(System.in);
    static GestionCliente clientes = new GestionCliente();

//    public static void main(String[] args) {
//        // TODO code application logic here
//        menu();
//
//    }

    public static void menu() {

        int opc;

        do {
            System.out.println(" ## MENU DE BANCO ##");
            System.out.println("1. Registrar cliente premium");
            System.out.println("2. Registrar cliente basico");
            System.out.println("3. Registrar cuenta basica");
            System.out.println("4. Registrar cuenta restringida");
            System.out.println("5. Consignar");
            System.out.println("6. Retirar");
            System.out.println("7. Consultar cuenta");
            System.out.println("8. Consultar cliente");
            System.out.println("9. Lista de clientes");
            System.out.println("10. Salir\n");

            System.out.print("Seleccione: ");
            opc = scanner.nextInt();
            String id, nombre, apellido;
            Cliente cliente = null;
            switch (opc) {
                case 1:
                    System.out.println(" ## REGISTRO CLIENTE PREMIUM ##");
                    System.out.print("id: ");
                    id = scanner.next();
                    System.out.print("Nombre: ");
                    nombre = scanner.next();
                    System.out.print("Apellido:");
                    apellido = scanner.next();
                    Cliente premium = new ClientePremium(nombre, apellido, id);
                    registrarCliente(premium);
                    break;
                case 2:
                    System.out.println(" ## REGISTRO CLIENTE BASICO ##");
                    System.out.print("id: ");
                    id = scanner.next();
                    System.out.print("Nombre: ");
                    nombre = scanner.next();
                    System.out.print("Apellido:");
                    apellido = scanner.next();
                    System.out.print("Transacciones permitidas:");
                    int noTransacciones = scanner.nextInt();
                    Cliente basico = new ClienteBasico(noTransacciones, nombre, apellido, id);
                    registrarCliente(basico);
                    break;
                case 3:
                    System.out.println(" ## REGISTRO CUENTA BASICA ##");
                    System.out.println("Id cliente: ");
                    id = scanner.next();
                    cliente = buscarCliente(id);
                    if (cliente != null) {
                        Cuenta cuenta = new Cuenta();
                        boolean error = true;
                        do {
                            try {
                                System.out.println("id Cuenta: ");
                                cuenta.setId(scanner.next());
                                System.out.println("saldo inicial: ");
                                cuenta.setSaldo(scanner.nextDouble());
                                System.out.println("limite cuenta: ");
                                cuenta.setLimite(scanner.nextDouble());

                                cliente.registrarCuenta(cuenta);
                                error = false;
                            } catch (IllegalStateException ex) {
                                System.out.println("Error: " + ex.getMessage());
                            } catch (InputMismatchException ex) {
                                System.out.println("Error de lectura: se requiere valor numerico");
                                scanner.nextLine();
                            } catch (EstadoDeCuentaIncorrectoException ex) {
                                System.out.println("Error: " + ex.getMessage());
                            }
                        } while (error);
                    } else {
                        System.out.println("El cliente no esta registrado");
                    }
                    break;
                case 4:
                    System.out.println(" ## REGISTRO CUENTA RESTRINGIDA ##");
                    System.out.println("Id cliente: ");
                    id = scanner.next();
                    cliente = buscarCliente(id);
                    if (cliente != null) {
                        CuentaRestringida cuenta = new CuentaRestringida();
                        try {
                            System.out.println("id Cuenta: ");
                            cuenta.setId(scanner.next());
                            System.out.println("saldo inicial: ");
                            cuenta.setSaldo(scanner.nextDouble());
                            System.out.println("limite cuenta: ");
                            cuenta.setLimite(scanner.nextDouble());
                            System.out.println("limite por transaccion: ");
                            cuenta.setLimiteMaximoValorTransaccion(scanner.nextDouble());

                            cliente.registrarCuenta(cuenta);
                        } catch (EstadoDeCuentaIncorrectoException ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                    } else {
                        System.out.println("El cliente no esta registrado");
                    }

                    break;
                case 5:
                    System.out.println(" ## CONSIGNAR ##");
                    System.out.println("Id cliente: ");
                    id = scanner.next();
                    cliente = buscarCliente(id);
                    if (cliente != null) {

                        System.out.print("id Cuenta: ");
                        Cuenta cuenta = cliente.consultarCuenta(scanner.next());
                        if (cuenta != null) {
                            System.out.print("monto a consignar: ");
                            cliente.consignarACuenta(scanner.nextDouble(), cuenta);
                        } else {
                            System.out.println("La cuenta no existe");
                        }

                    } else {
                        System.out.println("El cliente no esta registrado");
                    }
                    break;
                case 6:
                    System.out.println(" ## RETIRAR ##");
                    System.out.println("Id cliente: ");
                    id = scanner.next();
                    cliente = buscarCliente(id);
                    if (cliente != null) {

                        System.out.print("id Cuenta: ");
                        Cuenta cuenta = cliente.consultarCuenta(scanner.next());
                        if (cuenta != null) {
                            System.out.print("monto a retirar: ");
                            cliente.retirarDeCuenta(scanner.nextDouble(), cuenta);
                        } else {
                            System.out.println("La cuenta no existe");
                        }

                    } else {
                        System.out.println("El cliente no esta registrado");
                    }
                    break;
                case 7:
                    System.out.println(" ## CONSULTAR CUENTA ##");
                    System.out.println("Id cliente: ");
                    id = scanner.next();
                    cliente = buscarCliente(id);
                    if (cliente != null) {

                        System.out.print("id Cuenta: ");
                        Cuenta cuenta = cliente.consultarCuenta(scanner.next());
                        if (cuenta != null) {
                            imprimirCuenta(cuenta);
                        } else {
                            System.out.println("La cuenta no existe");
                        }

                    } else {
                        System.out.println("El cliente no esta registrado");
                    }
                    break;
                case 8:
                    System.out.println(" ## CONSULTAR CLIENTE ##");
                    System.out.println("Id cliente: ");
                    id = scanner.next();
                    cliente = buscarCliente(id);
                    if (cliente != null) {
                        System.out.println("Datos de cliente:");
                        System.out.println("--------------------------");
                        System.out.println(cliente);
                    } else {
                        System.out.println("El cliente no esta registrado");
                    }
                    break;
                case 9:
                    System.out.println(" ## LISTADO DE CLIENTES ##");
                    imprimirClientes(clientes.listarClientes());
                    System.out.println("-----------------");
                    System.out.println("Total registrados: " + clientes.listarClientes().size());
                    break;
                case 10:
                    System.out.println("!! Cierre de la aplicacion ¡¡");
                    break;
                default:
                    System.out.println("!! Opcion no disponible ¡¡");
            }

        } while (opc != 10);

    }

    public static void registrarCliente(Cliente cliente) {
        clientes.registrarCliente(cliente);
    }

    public static void imprimirClientes(List<Cliente> lista) {
        for (Cliente c : lista) {
            System.out.println(c);
        }
    }

    public static Cliente buscarCliente(String id) {
        return clientes.consultarCliente(id);
    }

    public static void imprimirCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            System.out.println("La cuenta no existe o es null");
        } else {
            System.out.println("Datos cuenta: ");
            System.out.println("------------------------------");
            System.out.println(cuenta);
            System.out.println("Movimientos: ");
            System.out.println("------------------------------");
            for (Movimiento m : cuenta.getMovimientos()) {
                System.out.println(m);
            }
            System.out.println("------------------------------");
            System.out.println("Total movimientos: " + cuenta.getNoMovimientos());
        }
    }

}

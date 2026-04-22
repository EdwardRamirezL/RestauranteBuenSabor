/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carta carta = new Carta();
        Mesa mesa = new Mesa();
        int opcionMenu = 0;
        boolean menuActivo = true;
        int intentosInvalidos = 0;

        FacturaImpresor.imprimirEncabezado();

        while (menuActivo) {
            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Ver pedido actual");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opcion: ");
            opcionMenu = sc.nextInt();

            if (opcionMenu == 1) {
// mostrar carta
                FacturaImpresor.mostrarCarta(carta);
                System.out.println();
            } else if (opcionMenu == 2) {
// agregar producto
                System.out.println("--- AGREGAR PRODUCTO ---");
                System.out.print("Numero de producto (1-" + carta.getTotalProductos() + "): ");
                int numeroProducto = sc.nextInt();
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();
                if (numeroProducto > 0 && numeroProducto <= carta.getTotalProductos()) {
                    if (cantidad > 0) {
                        if (!mesa.isActiva()) {
// mesa no activa - pedir numero de mesa
                            System.out.print("Ingrese numero de mesa: ");
                            int numeroMesaIngresado = sc.nextInt();
                            mesa.activar(numeroMesaIngresado > 0 ? numeroMesaIngresado : 1);
                        }// fin if !isActiva
                        Producto producto = carta.getProducto(numeroProducto - 1);
                        mesa.getPedido().agregarItem(producto, cantidad);
                        System.out.println("Producto agregado al pedido.");
                        System.out.println("  -> " + producto.getNombre() + " x" + cantidad);
                    } else {
                        if (cantidad == 0) {
// cantidad es cero
                            System.out.println("La cantidad no puede ser cero.");
                        } else {
// cantidad negativa
                            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
                        }
                    }// fin if cantidad>0
                } else {
                    if (numeroProducto <= 0) {
                        System.out.println("El numero debe ser mayor a cero.");
                    } else {
                        System.out.println("Producto no existe. La carta tiene " + carta.getTotalProductos() + " productos.");
                    }
                }// fin if numeroProducto>0
                System.out.println();
            } else if (opcionMenu == 3) {
// ver pedido actual
                System.out.println();
                if (mesa.getPedido().tieneProductos()) {
                    FacturaImpresor.mostrarPedido(mesa.getPedido());
                } else {
                    System.out.println("No hay productos en el pedido actual.");
                    System.out.println("Use la opcion 2 para agregar productos.");
                }// fin if tieneProductos
                System.out.println();
            } else if (opcionMenu == 4) {
// generar factura
                System.out.println();
                if (mesa.getPedido().tieneProductos()) {
                    Factura factura = Factura.crear(mesa.getPedido());
                    FacturaImpresor.imprimirFacturaCompleta(factura);
                    mesa.getPedido().limpiar();
                    System.out.println();
                } else {
                    System.out.println("No se puede generar factura.");
                    System.out.println("No hay productos en el pedido.");
                    System.out.println("Use la opcion 2 para agregar productos primero.");
                }// fin if tieneProductos
            } else if (opcionMenu == 5) {
// nueva mesa - reiniciar pedido
                System.out.println();
                mesa.reiniciar();
                intentosInvalidos = 0;
                System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                System.out.println();
            } else if (opcionMenu == 0) {
// salir
                menuActivo = false;
                System.out.println("Hasta luego!");
            } else {
// opcion no reconocida
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
                intentosInvalidos = intentosInvalidos + 1;
                if (intentosInvalidos > 3) {
                    System.out.println("Demasiados intentos invalidos.");
                    intentosInvalidos = 0;
                }// fin if intentosInvalidos>3
            }// fin if-else opcionMenu
        }// fin while
        sc.close();
    }// fin main
}

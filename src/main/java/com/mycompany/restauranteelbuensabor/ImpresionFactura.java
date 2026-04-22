/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class ImpresionFactura {

    public static void mostrarCarta() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");
        int indice = 0;
        while (indice < Datos.nombres.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), Datos.nombres[indice], Datos.precios[indice]);
            indice++;
        }// fin while
        System.out.println("========================================");
    }

    public static void mostrarPedido() {
        double subtotal = 0;
        int indice = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (indice < Datos.nombres.length) {
            if (Datos.cantidades[indice] > 0) {
// imprime producto con cantidad y subtotal parcial
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombres[indice], Datos.cantidades[indice], (Datos.precios[indice] * Datos.cantidades[indice]));
// suma al subtotal
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
            }
            indice++;
        }// fin while
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

    public static void imprimirFacturaCompleta() {
        double subtotal = 0;
        double montoIva = 0;
        double totalFactura = 0;
        double propina = 0;
        int contadorTiposProducto = 0;
        double subtotalConDescuento = 0;
// calcula subtotal otra vez
        int indice = 0;
        while (indice < Datos.nombres.length) {
            if (Datos.cantidades[indice] > 0) {
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
                contadorTiposProducto = contadorTiposProducto + 1;
            }
            indice++;
        }// fin while
        if (contadorTiposProducto > 3) {
            subtotalConDescuento = subtotal - (subtotal * 0.05);
        } else {
            subtotalConDescuento = subtotal;
        }
        if (subtotalConDescuento > 50000) {
            montoIva = subtotalConDescuento * 0.19;
            totalFactura = subtotalConDescuento + montoIva;
            propina = totalFactura * 0.10;
            totalFactura = totalFactura + propina;
        } else {
            montoIva = subtotalConDescuento * 0.19;
            totalFactura = subtotalConDescuento + montoIva;
            propina = 0;
        }// fin if-else
        String separador = "========================================";
        System.out.println(separador);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(separador);
        System.out.printf("FACTURA No. %03d%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
// imprime cada item del pedido
        int indiceItems = 0;
        while (indiceItems < Datos.nombres.length) {
            if (Datos.cantidades[indiceItems] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombres[indiceItems], Datos.cantidades[indiceItems], (Datos.precios[indiceItems] * Datos.cantidades[indiceItems]));
            }
            indiceItems++;
        }// fin while
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalConDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", montoIva);
        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }// fin if propina
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", totalFactura);
        System.out.println(separador);
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println(separador);
// actualiza estado e incrementa factura - tres responsabilidades en un metodo
        Datos.numeroFactura = Datos.numeroFactura + 1;
        Datos.estadoMesa = 0;
        Datos.total = totalFactura;
    }

    public static void imprimirFacturaResumen() {
        double subtotal = 0;
        double montoIva = 0;
        double totalFactura = 0;
        double propina = 0;
        int contadorTiposProducto = 0;
        double subtotalConDescuento = 0;
// calcula subtotal otra vez igual que en imprimirFacturaCompleta
        int indice = 0;
        while (indice < Datos.nombres.length) {
            if (Datos.cantidades[indice] > 0) {
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
                contadorTiposProducto = contadorTiposProducto + 1;
            }
            indice++;
        }// fin while
        if (contadorTiposProducto > 3) {
            subtotalConDescuento = subtotal - (subtotal * 0.05);
        } else {
            subtotalConDescuento = subtotal;
        }
        if (subtotalConDescuento > 50000) {
            montoIva = subtotalConDescuento * 0.19;
            totalFactura = subtotalConDescuento + montoIva;
            propina = totalFactura * 0.10;
            totalFactura = totalFactura + propina;
        } else {
            montoIva = subtotalConDescuento * 0.19;
            totalFactura = subtotalConDescuento + montoIva;
            propina = 0;
        }// fin if-else
        String separador = "========================================";
        System.out.println(separador);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(separador);
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalConDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", montoIva);
        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }// fin if propina
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", totalFactura);
        System.out.println(separador);
    }
}

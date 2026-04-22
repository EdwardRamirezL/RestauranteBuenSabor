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

    private static final String NOMBRE_RESTAURANTE = "El Buen Sabor";
    private static final String DIRECCION = "Calle 15 #8-32, Valledupar";
    private static final String CIUDAD = "Valledupar";
    private static final String NIT = "900.123.456-7";
    private static final String SEPARADOR_DOBLE = "========================================";
    private static final String SEPARADOR_SIMPLE = "----------------------------------------";

    private static void imprimirEncabezado() {
        System.out.println(SEPARADOR_DOBLE);
        System.out.println("    RESTAURANTE " + NOMBRE_RESTAURANTE);
        System.out.println("    " + DIRECCION);
        System.out.println("    NIT: " + NIT);
        System.out.println(SEPARADOR_DOBLE);
    }

    private static void imprimirLineasTotales(double subtotalConDescuento, double montoIva, double propina, double totalFactura) {
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalConDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", montoIva);
        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", totalFactura);
        System.out.println(SEPARADOR_DOBLE);
    }

    public static void mostrarCarta() {
        System.out.println(SEPARADOR_DOBLE);
        System.out.println("    RESTAURANTE " + NOMBRE_RESTAURANTE);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEPARADOR_DOBLE);
        int indice = 0;
        while (indice < Datos.nombres.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), Datos.nombres[indice], Datos.precios[indice]);
            indice++;
        }
        System.out.println(SEPARADOR_DOBLE);
    }

    public static void mostrarPedido() {
        double subtotal = 0;
        int indice = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (indice < Datos.nombres.length) {
            if (Datos.cantidades[indice] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombres[indice], Datos.cantidades[indice], (Datos.precios[indice] * Datos.cantidades[indice]));
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
            }
            indice++;
        }
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

    public static void imprimirFacturaCompleta() {
        double subtotal = CalculadorFactura.calcularSubtotal();
        double subtotalConDescuento = CalculadorFactura.aplicarDescuento(subtotal);
        double montoIva = CalculadorFactura.calcularIVA(subtotalConDescuento);
        double totalConIva = subtotalConDescuento + montoIva;
        double propina = CalculadorFactura.calcularPropina(totalConIva);
        double totalFactura = totalConIva + propina;

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", Datos.numeroFactura);
        System.out.println(SEPARADOR_SIMPLE);
        int indiceItems = 0;
        while (indiceItems < Datos.nombres.length) {
            if (Datos.cantidades[indiceItems] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombres[indiceItems], Datos.cantidades[indiceItems], (Datos.precios[indiceItems] * Datos.cantidades[indiceItems]));
            }
            indiceItems++;
        }
        imprimirLineasTotales(subtotalConDescuento, montoIva, propina, totalFactura);
        System.out.println("Gracias por su visita!");
        System.out.println(NOMBRE_RESTAURANTE + " - " + CIUDAD);
        System.out.println(SEPARADOR_DOBLE);
// actualiza estado e incrementa factura
        Datos.numeroFactura = Datos.numeroFactura + 1;
        Datos.estadoMesa = 0;
        Datos.total = totalFactura;
    }

    public static void imprimirFacturaResumen() {
        double subtotal = CalculadorFactura.calcularSubtotal();
        double subtotalConDescuento = CalculadorFactura.aplicarDescuento(subtotal);
        double montoIva = CalculadorFactura.calcularIVA(subtotalConDescuento);
        double totalConIva = subtotalConDescuento + montoIva;
        double propina = CalculadorFactura.calcularPropina(totalConIva);
        double totalFactura = totalConIva + propina;

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.numeroFactura);
        System.out.println(SEPARADOR_SIMPLE);
        imprimirLineasTotales(subtotalConDescuento, montoIva, propina, totalFactura);
    }
}

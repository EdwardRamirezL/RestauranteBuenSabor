/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class FacturaImpresor {

    private static final String NOMBRE_RESTAURANTE = "El Buen Sabor";
    private static final String DIRECCION = "Calle 15 #8-32, Valledupar";
    private static final String CIUDAD = "Valledupar";
    private static final String NIT = "900.123.456-7";
    private static final String SEPARADOR_DOBLE = "========================================";
    private static final String SEPARADOR_SIMPLE = "----------------------------------------";

    public static void imprimirEncabezado() {
        System.out.println(SEPARADOR_DOBLE);
        System.out.println("    RESTAURANTE " + NOMBRE_RESTAURANTE);
        System.out.println("    " + DIRECCION);
        System.out.println("    NIT: " + NIT);
        System.out.println(SEPARADOR_DOBLE);
    }

    private static void imprimirLineasTotales(Factura factura) {
        double subtotalConDescuento = factura.calcularSubtotal() - factura.calcularDescuento();
        double montoIva = factura.calcularIVA();
        double propina = factura.calcularPropina();
        double totalFactura = factura.calcularTotal();
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

    public static void mostrarCarta(Carta carta) {
        System.out.println(SEPARADOR_DOBLE);
        System.out.println("    RESTAURANTE " + NOMBRE_RESTAURANTE);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEPARADOR_DOBLE);
        int indice = 0;
        while (indice < carta.getTotalProductos()) {
            Producto producto = carta.getProducto(indice);
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), producto.getNombre(), producto.getPrecio());
            indice++;
        }
        System.out.println(SEPARADOR_DOBLE);
    }

    public static void mostrarPedido(Pedido pedido) {
        double subtotal = 0;
        int indice = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (indice < pedido.getItems().size()) {
            ItemPedido item = pedido.getItems().get(indice);
            System.out.printf("%-20s x%-6d $%,.0f%n", item.getProducto().getNombre(), item.getCantidad(), item.calcularSubtotal());
            subtotal = subtotal + item.calcularSubtotal();
            indice++;
        }
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

    public static void imprimirFacturaCompleta(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println(SEPARADOR_SIMPLE);
        int indice = 0;
        while (indice < factura.getPedido().getItems().size()) {
            ItemPedido item = factura.getPedido().getItems().get(indice);
            System.out.printf("%-20s x%-6d $%,.0f%n", item.getProducto().getNombre(), item.getCantidad(), item.calcularSubtotal());
            indice++;
        }
        imprimirLineasTotales(factura);
        System.out.println("Gracias por su visita!");
        System.out.println(NOMBRE_RESTAURANTE + " - " + CIUDAD);
        System.out.println(SEPARADOR_DOBLE);
    }

    public static void imprimirFacturaResumen(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", factura.getNumero());
        System.out.println(SEPARADOR_SIMPLE);
        imprimirLineasTotales(factura);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class CalculadorFactura {

    private static final double TASA_IVA = 0.19;
    private static final double TASA_PROPINA = 0.10;
    private static final double TASA_DESCUENTO = 0.05;
    private static final double UMBRAL_PROPINA = 50000;
    private static final int MIN_ITEMS_DESCUENTO = 3;

    public static double calcularSubtotal() {
        double subtotal = 0;
        int indice = 0;
        while (indice < Datos.nombres.length) {
            if (Datos.cantidades[indice] > 0) {
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
            }
            indice++;
        }
        return subtotal;
    }

    public static double aplicarDescuento(double subtotal) {
        int contadorTiposProducto = 0;
        int indice = 0;
        while (indice < Datos.cantidades.length) {
            if (Datos.cantidades[indice] > 0) {
                contadorTiposProducto = contadorTiposProducto + 1;
            }
            indice++;
        }
        if (contadorTiposProducto > MIN_ITEMS_DESCUENTO) {
            return subtotal - (subtotal * TASA_DESCUENTO);
        }
        return subtotal;
    }

    public static double calcularIVA(double base) {
        return base * TASA_IVA;
    }

    public static double calcularPropina(double base) {
        if (base > UMBRAL_PROPINA) {
            return base * TASA_PROPINA;
        }
        return 0;
    }

    public static double calcularTotal() {
        double subtotal = calcularSubtotal();
        double subtotalConDescuento = aplicarDescuento(subtotal);
        double montoIva = calcularIVA(subtotalConDescuento);
        double totalConIva = subtotalConDescuento + montoIva;
        double propina = calcularPropina(totalConIva);
        double totalFinal = totalConIva + propina;
        Datos.estadoMesa = 1;
        Datos.total = totalFinal;
        return totalFinal;
    }

    public static double calcularConParametros(double precio, double cantidad, double porcentajeDescuento, double porcentajeIva, double porcentajePropina, int numeroItems, boolean aplicarPropina) {
        double resultado = 0;
        double montoIva = 0;
        double propina = 0;
        double ivaCalculado = 0;
// calcula subtotal con cantidad
        resultado = precio * cantidad;
        if (porcentajeDescuento > 0) {
// aplica descuento
            resultado = resultado - (resultado * porcentajeDescuento);
        }
// calcula iva
        montoIva = resultado * porcentajeIva;
        ivaCalculado = montoIva;
        resultado = resultado + ivaCalculado;
        if (aplicarPropina) {
// aplica propina si corresponde
            propina = resultado * porcentajePropina;
            resultado = resultado + propina;
        }
        if (numeroItems > MIN_ITEMS_DESCUENTO) {
            resultado = resultado - (resultado * 0.01);
        }
        return resultado;
    }
}

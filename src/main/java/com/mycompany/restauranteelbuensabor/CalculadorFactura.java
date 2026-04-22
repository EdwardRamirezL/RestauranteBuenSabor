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

    public static double calcularTotalFactura() {
        double subtotal = 0;
        double montoIva = 0;
        double totalConImpuestos = 0;
        double subtotalConDescuento = 0;
        int contadorTiposProducto = 0;
        int indice = 0;
        while (indice < Datos.nombres.length) {
            if (Datos.cantidades[indice] > 0) {
// multiplica precio por cantidad
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
                contadorTiposProducto = contadorTiposProducto + 1;
            }
            indice++;
        }// fin while
        if (contadorTiposProducto > 3) {
            if (subtotal > 0) {
                subtotalConDescuento = subtotal - (subtotal * 0.05);
                if (subtotalConDescuento > 50000) {
                    montoIva = subtotalConDescuento * 0.19;
// suma iva al subtotal con descuento
                    totalConImpuestos = subtotalConDescuento + montoIva;
                    totalConImpuestos = totalConImpuestos + (totalConImpuestos * 0.10);
                } else {
// suma iva al subtotal
                    montoIva = subtotalConDescuento * 0.19;
                    totalConImpuestos = subtotalConDescuento + montoIva;
                }
            }// fin if subtotal>0
// version anterior - no borrar
// subtotal = subtotal * 1.19;
// if(subtotal > 40000) subtotal = subtotal + (subtotal*0.10);
// return subtotal;
        } else {
            if (subtotal > 50000) {
                montoIva = subtotal * 0.19;
// suma iva al subtotal
                totalConImpuestos = subtotal + montoIva;
                totalConImpuestos = totalConImpuestos + (totalConImpuestos * 0.10);
            } else {
                montoIva = subtotal * 0.19;
                totalConImpuestos = subtotal + montoIva;
            }
        }// fin if-else contadorTiposProducto
        Datos.estadoMesa = 1;
        Datos.total = totalConImpuestos;
        return totalConImpuestos;
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
        if (numeroItems > 3) {
            resultado = resultado - (resultado * 0.01);
        }
        return resultado;
    }
}

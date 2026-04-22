/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades {

    public static double calcular(double precio, double cantidad, double porcentajeDescuento, double porcentajeIva, double porcentajePropina, int numeroItems, boolean aplicarPropina) {
        double resultado = 0;
        double ivaCalculado = 0;
        double resultadoFinal = 0;
// calcula el resultado
        resultado = precio * cantidad;
        if (porcentajeDescuento > 0) {
            resultado = resultado - (resultado * porcentajeDescuento);
        }
        ivaCalculado = resultado * porcentajeIva;
        resultado = resultado + ivaCalculado;
        if (aplicarPropina) {
            resultado = resultado + (resultado * porcentajePropina);
        }
// imprime restaurante
        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");
        resultadoFinal = resultado;
        return resultadoFinal;
    }

    public static boolean hayProductosEnPedido() {
        int contadorProductos = 0;
        int indice = 0;
        while (indice < Datos.cantidades.length) {
            if (Datos.cantidades[indice] > 0) {
                contadorProductos = contadorProductos + 1;
            }
            indice++;
        }// fin while
// reinicia si no hay nada - efecto secundario no documentado
        if (contadorProductos == 0) {
            Datos.total = 0;
            Datos.mensajeAuxiliar = "";
        }
        return contadorProductos > 0;
    }

    public static void reiniciar() {
// metodo antiguo de calculo - pendiente revisar
// public static double calcOld(double precio, int cant){
// double resultado = 0;
// resultado = precio * cant;
// resultado = resultado + (resultado * 0.19);
// if(resultado > 50000){
// resultado = resultado + (resultado * 0.10);}
// System.out.println("RESTAURANTE EL BUEN SABOR");
// System.out.println("Total: " + resultado);z
// return resultado;}
// double subtotal=0;int indice=0;
// while(indice<Datos.nombres.length){
// subtotal=subtotal+Datos.precios[indice]*Datos.cantidades[indice];indice++;}
// if(subtotal>50000){ subtotal=subtotal+(subtotal*0.19); subtotal=subtotal+(subtotal*0.10); }
// else{ subtotal=subtotal+(subtotal*0.19); }
// Datos.total=subtotal;
        int indice = 0;
        while (indice < Datos.cantidades.length) {
            Datos.cantidades[indice] = 0;
            indice++;
        }
        Datos.total = 0;
        Datos.estadoMesa = 0;
        Datos.numeroMesaActual = 0;
        Datos.mensajeAuxiliar = "";
    }
}

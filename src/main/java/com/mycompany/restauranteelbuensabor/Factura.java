package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Factura {

    private static final double TASA_IVA = 0.19;
    private static final double TASA_PROPINA = 0.10;
    private static final double TASA_DESCUENTO = 0.05;
    private static final double UMBRAL_PROPINA = 50000;
    private static final int MIN_ITEMS_DESCUENTO = 3;

    private static int proximoNumero = 1;

    private final Pedido pedido;
    private final int numero;

    private Factura(Pedido pedido, int numero) {
        this.pedido = pedido;
        this.numero = numero;
    }

    public static Factura crear(Pedido pedido) {
        return new Factura(pedido, proximoNumero++);
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }

    public double calcularDescuento() {
        if (pedido.contarItemsDiferentes() > MIN_ITEMS_DESCUENTO) {
            return calcularSubtotal() * TASA_DESCUENTO;
        }
        return 0;
    }

    public double calcularIVA() {
        // El IVA se calcula sobre el subtotal ya descontado, segun normativa DIAN
        return (calcularSubtotal() - calcularDescuento()) * TASA_IVA;
    }

    public double calcularPropina() {
        // La propina aplica sobre el total con IVA incluido, no sobre el subtotal
        double totalConIva = calcularSubtotal() - calcularDescuento() + calcularIVA();
        if (totalConIva > UMBRAL_PROPINA) {
            return totalConIva * TASA_PROPINA;
        }
        return 0;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento() + calcularIVA() + calcularPropina();
    }
}

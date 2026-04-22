package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Mesa {

    private int numero;
    private boolean activa;
    private final Pedido pedido = new Pedido();

    public int getNumero() {
        return numero;
    }

    public boolean isActiva() {
        return activa;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void activar(int numero) {
        this.numero = numero;
        this.activa = true;
    }

    public void reiniciar() {
        this.numero = 0;
        this.activa = false;
        this.pedido.limpiar();
    }
}

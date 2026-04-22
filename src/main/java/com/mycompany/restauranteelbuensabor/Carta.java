package com.mycompany.restauranteelbuensabor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfre
 */
public class Carta {

    private final List<Producto> productos = new ArrayList<>();

    public Carta() {
        productos.add(new Producto("Bandeja Paisa", 32000));
        productos.add(new Producto("Sancocho de Gallina", 28000));
        productos.add(new Producto("Arepa con Huevo", 8000));
        productos.add(new Producto("Jugo Natural", 7000));
        productos.add(new Producto("Gaseosa", 4500));
        productos.add(new Producto("Cerveza Poker", 6000));
        productos.add(new Producto("Agua Panela", 3500));
        productos.add(new Producto("Arroz con Pollo", 25000));
    }

    public Producto getProducto(int indice) {
        return productos.get(indice);
    }

    public int getTotalProductos() {
        return productos.size();
    }

    public List<Producto> getProductos() {
        return productos;
    }
}

package menu.strategy.impl;

import domain.Juguete;
import domain.impl.Carrito;
import menu.strategy.Accion;
import menu.Menu;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class AccionMostrarCarritoConMasPuertas implements Accion {

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        Set<Carrito> carritos = juguetes.stream()
                .filter(juguete -> juguete instanceof Carrito)
                .map(juguete -> (Carrito) juguete)
                .collect(Collectors.toSet());

        if (!carritos.isEmpty()) {
            Carrito carritoConMasPuertas = carritos.stream()
                    .max(Comparator.comparing(Carrito::getNumeroPuertas))
                    .get();

            System.out.println("Carrito con más puertas:\n" + carritoConMasPuertas);
        } else {
            System.out.println("No se encontraron carritos en la colección.");
        }
        return juguetes;
    }

    @Override
    public Integer getOpcion() {
        return 6;
    }
}

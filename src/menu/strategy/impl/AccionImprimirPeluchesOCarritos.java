package menu.strategy.impl;

import domain.Juguete;
import domain.impl.Carrito;
import domain.impl.Peluche;
import menu.strategy.Accion;
import menu.Menu;

import java.util.Set;
import java.util.stream.Collectors;

public class AccionImprimirPeluchesOCarritos implements Accion {

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        System.out.println("¿Desea imprimir Peluches o Carritos? (P/C)");
        String eleccion = Menu.getInstance().scanner.nextLine();
        
        if (eleccion.equalsIgnoreCase("P")) {
            Menu.mostrarElementos(juguetes.stream()
                .filter(juguete -> juguete instanceof Peluche)
                .collect(Collectors.toSet())
            );
        } else if (eleccion.equalsIgnoreCase("C")) {
            Menu.mostrarElementos(juguetes.stream()
                .filter(juguete -> juguete instanceof Carrito)
                .collect(Collectors.toSet())
            );
        } else {
            System.out.println("Elección no válida. Regresando al menú principal.");
        }
        return juguetes;
    }

    @Override
    public Integer getOpcion() {
        return 5;
    }
}

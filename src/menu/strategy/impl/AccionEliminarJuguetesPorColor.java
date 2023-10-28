package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;
import menu.Menu;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AccionEliminarJuguetesPorColor implements Accion {

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        Set<String> coloresDistintos = juguetes.stream()
                .map(Juguete::getColor)
                .collect(Collectors.toSet());

        System.out.println("Colores disponibles:");
        coloresDistintos.forEach(System.out::println);

        System.out.print("Elija un color para eliminar los juguetes: ");
        String colorAEliminar = Menu.getInstance().scanner.nextLine();

        Set<Juguete> juguetesFiltrados = juguetes.stream()
                .filter(juguete -> !juguete.getColor().equalsIgnoreCase(colorAEliminar))
                .collect(Collectors.toSet());

        if (juguetes.size() > juguetesFiltrados.size()) {
            juguetes = reasignarIdsSecuenciales(juguetesFiltrados);
            System.out.println("Elementos eliminados satisfactoriamente.");
        } else {
            System.out.println("No se encontraron elementos con el color seleccionado.");
        }
        return juguetes;
    }

    private Set<Juguete> reasignarIdsSecuenciales(Set<Juguete> juguetes) {
        int id = 1;
        for (Juguete juguete : juguetes) {
            juguete.setId(id);
            id++;
        }
        return juguetes;
    }

    @Override
    public Integer getOpcion() {
        return 8;
    }
}

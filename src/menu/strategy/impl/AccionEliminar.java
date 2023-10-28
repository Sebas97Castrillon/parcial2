package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AccionEliminar implements Accion {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        System.out.println("¿Qué juguete desea eliminar?");
        AccionMostrar.mostrarElementos(juguetes);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        Set<Juguete> juguetesCopia = new HashSet<>(juguetes);
        juguetesCopia.remove(opcion-1);
        reorganizarElementos(opcion, juguetesCopia);
        return juguetesCopia;
    }

    private void reorganizarElementos(int opcion, Set<Juguete> juguetesCopia) {
        Set<Juguete> juguetesActualizados = new HashSet<>();
    
        int newId = 1;
        for (Juguete juguete : juguetesCopia) {
            juguete.setId(newId++);
            juguetesActualizados.add(juguete);
        }
    
        juguetesCopia.clear();
        juguetesCopia.addAll(juguetesActualizados);
    }

    @Override
    public Integer getOpcion() {
        return 3;
    }
}

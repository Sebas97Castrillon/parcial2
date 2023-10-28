package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class AccionClonar implements Accion {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        System.out.println("¿Qué juguete quieres clonar?");
        AccionMostrar.mostrarElementos(juguetes);
        int opcion = scanner.nextInt();
        scanner.nextLine();

        Optional<Juguete> jugueteACopiarOpt = juguetes.stream()
                .skip(opcion - 1)
                .findFirst();

        if (jugueteACopiarOpt.isPresent()) {
            Juguete jugueteACopiar = jugueteACopiarOpt.get();
            System.out.println("¿Cuántas veces lo quieres clonar?");
            int numeroDeVeces = scanner.nextInt();
            scanner.nextLine();

            Set<Juguete> juguetesCopia = new HashSet<>(juguetes);

            for (int i = 0; i < numeroDeVeces; i++) {
                Juguete jugueteClonado = jugueteACopiar.clone();
                jugueteClonado.setId(juguetesCopia.size() + 1);
                juguetesCopia.add(jugueteClonado);
            }

            return juguetesCopia;
        } else {
            System.out.println("Juguete no encontrado. No se realizó la clonación.");
            return juguetes;
        }
    }

    @Override
    public Integer getOpcion() {
        return 2;
    }
}

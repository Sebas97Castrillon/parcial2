package menu.strategy.impl;

import domain.Juguete;
import menu.factory.impl.CreadorCarrito;
import menu.factory.impl.CreadorPeluche;
import menu.strategy.Accion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AccionCrear implements Accion {

    private final Scanner scanner = new Scanner(System.in);
    private final CreadorPeluche creadorPeluche = new CreadorPeluche();
    private final CreadorCarrito creadorCarrito = new CreadorCarrito();

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        System.out.println("1.Carrito \n" + "2.Peluche");
        int opcion = scanner.nextInt();
        Set<Juguete> juguetesCopia = new HashSet<>(juguetes); // Crear una copia del conjunto existente
        Juguete jugueteCreado = crearJuguete(opcion);
        jugueteCreado.setId(generarId(juguetesCopia));
        juguetesCopia.add(jugueteCreado);
        return juguetesCopia;
    }

    private long generarId(Set<Juguete> juguetes) {
        return juguetes.size() + 1;
    }

    private Juguete crearJuguete(int opcion) {
        if(opcion == 1) {
            return creadorCarrito.crear();
        }
        if(opcion == 2) {
            return creadorPeluche.crear();
        }
        throw new RuntimeException("Opcion no valida");
    }

    @Override
    public Integer getOpcion() {
        return 1;
    }
}

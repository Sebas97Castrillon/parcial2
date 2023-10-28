package menu.factory.impl;

import domain.Juguete;
import domain.impl.Carrito;
import menu.factory.CreadorJuguete;

import java.util.Scanner;

public class CreadorCarrito implements CreadorJuguete {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Juguete crear() {
        System.out.println("Ingrese el número de puertas:");
        short numeroPuertas = scanner.nextShort();
        scanner.nextLine();
        System.out.println("Ingrese la marca:");
        String marca = scanner.nextLine();
        System.out.println("Ingrese el color:");
        String color = scanner.nextLine();
        return Carrito.builder()
                .color(color)
                .marca(marca)
                .numeroPuertas(numeroPuertas)
                .build();
    }
}

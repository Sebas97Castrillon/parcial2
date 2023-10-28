package menu.factory.impl;

import domain.Juguete;
import domain.impl.Peluche;
import menu.factory.CreadorJuguete;

import java.util.Scanner;

public class CreadorPeluche implements CreadorJuguete {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Juguete crear() {
        System.out.println("Ingrese el relleno:");
        String relleno = scanner.nextLine();
        System.out.println("Ingrese el material exterior:");
        String materialExterior = scanner.nextLine();
        System.out.println("Ingrese el color:");
        String color = scanner.nextLine();
        return Peluche.builder()
                .materialExterior(materialExterior)
                .color(color)
                .relleno(relleno)
                .build();
    }
}

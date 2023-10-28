package menu;

import domain.Juguete;
import domain.impl.Carrito;
import domain.impl.Peluche;
import menu.strategy.AccionHandler;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Menu {

    private static final Menu instance = new Menu();
    private Set<Juguete> juguetes = new HashSet<>();
    public final Scanner scanner = new Scanner(System.in);

    private final AccionHandler accionHandler = new AccionHandler();

    private Menu() {
    }

    public void mostrarMenu() {
        inicializarLista();
        int opcion = 0;
        do {
            System.out.println("Bienvenido al Menu");
            System.out.println("1. Crear\n" + "2. Clonar\n" + "3. Eliminar\n" + "4. Mostrar todos\n"
                    + "5. Imprimir Peluches o Carritos\n" + //
                            "" + "6. Mostrar carrito con mayor número de puertas\n" + //
                                    "" +  "7. Convertir Set de juguetes a un Map\n" + //
                                            "" + "8. Eliminar juguetes por color\n" + //
                                                    "" + "9. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion >= 5) {
                continue;
            }
            if (opcion == 5) {
                System.out.println("¿Desea imprimir Peluches o Carritos? (P/C)");
                String eleccion = scanner.nextLine();
                if (eleccion.equalsIgnoreCase("P")) {
                    mostrarPeluchesOrdenadosDescendentemente();
                } else if (eleccion.equalsIgnoreCase("C")) {
                    mostrarCarritosOrdenadosDescendentemente();
                } else {
                    System.out.println("Elección no válida. Regresando al menú principal.");
                }
            }
            if (opcion == 6) {
                encontrarCarritoConMasPuertas();
            }
            if (opcion == 7) {
                convertirSetAJugueteMap();
            }
            if (opcion == 8) {
                eliminarJuguetesPorColor();
            }
            juguetes = new HashSet<>(accionHandler.getStrategy().get(opcion).aplicar(juguetes));

        } while (opcion != 8);
        System.out.println("Gracias por utilizar este Menú");
    }

    public void eliminarJuguetesPorColor() {
        Set<String> coloresDistintos = juguetes.stream()
                .map(Juguete::getColor)
                .collect(Collectors.toSet());
    
        System.out.println("Colores disponibles:");
        coloresDistintos.forEach(System.out::println);
    
        System.out.print("Elija un color para eliminar los juguetes: ");
        String colorAEliminar = scanner.nextLine();
    
        Set<Juguete> juguetesFiltrados = juguetes.stream()
                .filter(juguete -> !juguete.getColor().equalsIgnoreCase(colorAEliminar))
                .collect(Collectors.toSet());
    
        if (juguetes.size() > juguetesFiltrados.size()) {
            juguetes = reasignarIdsSecuenciales(juguetesFiltrados);
            System.out.println("Elementos eliminados satisfactoriamente.");
        } else {
            System.out.println("No se encontraron elementos con el color seleccionado.");
        }
    }

    private Set<Juguete> reasignarIdsSecuenciales(Set<Juguete> juguetes) {
        int id = 1;
        for (Juguete juguete : juguetes) {
            juguete.setId(id);
            id++;
        }
        return juguetes;
    }
    
    

    public void convertirSetAJugueteMap() {
    Map<Long, Juguete> jugueteMap = juguetes.stream()
        .collect(Collectors.toMap(Juguete::getId, Function.identity()));

    jugueteMap.forEach((id, juguete) -> {
        System.out.printf("Key->%s Value->%s%n", id, juguete.toString());
    });
}


    public void encontrarCarritoConMasPuertas() {
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
}


    public void mostrarPeluchesOrdenadosDescendentemente() {
        Set<Juguete> peluches = juguetes.stream()
                .filter(juguete -> juguete instanceof Peluche)
                .sorted((p1, p2) -> Long.compare(p2.getId(), p1.getId())) // Orden descendente por ID
                .collect(Collectors.toSet());

        mostrarElementos(peluches);
    }

    public void mostrarCarritosOrdenadosDescendentemente() {
        Set<Juguete> carritos = juguetes.stream()
                .filter(juguete -> juguete instanceof Carrito)
                .sorted((c1, c2) -> Long.compare(c2.getId(), c1.getId())) // Orden descendente por ID
                .collect(Collectors.toSet());

        mostrarElementos(carritos);
    }

    public static void mostrarElementos(Set<Juguete> juguetes) {
        int i = 1;
        for (Juguete juguete : juguetes) {
            System.out.println(i + "." + juguete.toString());
            i++;
        }
    }

    public static Menu getInstance() {
        return instance;
    }

    private void inicializarLista() {
        juguetes.add(Carrito.builder().id(1).color("Negro").numeroPuertas((short) 4).marca("Renault").build());
        juguetes.add(Peluche.builder().id(2).color("Negro").relleno("Algodon").materialExterior("Cuero").build());
    }

}

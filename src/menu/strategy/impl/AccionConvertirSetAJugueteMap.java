package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;
import menu.Menu;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AccionConvertirSetAJugueteMap implements Accion {

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        Map<Long, Juguete> jugueteMap = juguetes.stream()
                .collect(Collectors.toMap(Juguete::getId, juguete -> juguete));

        jugueteMap.forEach((id, juguete) -> {
            System.out.printf("Key->%s Value->%s%n", id, juguete.toString());
        }
        );
        return juguetes;
    }

    @Override
    public Integer getOpcion() {
        return 7;
    }
}

package menu.strategy;

import domain.Juguete;

import java.util.Set;

public interface Accion {

    Set<Juguete> aplicar(Set<Juguete> juguetes);

    Integer getOpcion();
}

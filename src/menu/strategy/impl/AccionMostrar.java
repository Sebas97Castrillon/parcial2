package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;

import java.util.Set;

public class AccionMostrar implements Accion {

    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        mostrarElementos(juguetes);
        return juguetes;
    }

    public static void mostrarElementos(Set<Juguete> juguetes) {
        int i = 1;
        for (Juguete juguete : juguetes) {
            System.out.println(i + "." + juguete.toString());
            i++;
        }
    }
    
    

    @Override
    public Integer getOpcion() {
        return 4;
    }
}

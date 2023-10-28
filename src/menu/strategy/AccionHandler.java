package menu.strategy;

import menu.strategy.impl.AccionClonar;
import menu.strategy.impl.AccionConvertirSetAJugueteMap;
import menu.strategy.impl.AccionCrear;
import menu.strategy.impl.AccionEliminar;
import menu.strategy.impl.AccionEliminarJuguetesPorColor;
import menu.strategy.impl.AccionImprimirPeluchesOCarritos;
import menu.strategy.impl.AccionMostrar;
import menu.strategy.impl.AccionMostrarCarritoConMasPuertas;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AccionHandler {

    private List<Accion> acciones = List.of(
            new AccionMostrar(),
            new AccionClonar(),
            new AccionCrear(),
            new AccionEliminar(),
            new AccionConvertirSetAJugueteMap(),
            new AccionEliminarJuguetesPorColor(),
            new AccionImprimirPeluchesOCarritos(),
            new AccionMostrarCarritoConMasPuertas()     
    );
    private Map<Integer, Accion> strategy;

    public AccionHandler() {
        this.strategy = acciones.stream()
                .collect(Collectors.toMap(Accion::getOpcion, Function.identity()));
    }

    public Map<Integer, Accion> getStrategy() {
        return strategy;
    }
}

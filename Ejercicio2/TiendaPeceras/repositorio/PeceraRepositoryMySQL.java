package repositorio;

import java.util.ArrayList;
import java.util.List;
import modelo.Pecera;

/** Implementación concreta con MySQL (simulada con System.out). */
public class PeceraRepositoryMySQL implements PeceraRepository {
    private final List<Pecera> inventario = new ArrayList<>();

    @Override
    public void guardar(Pecera pecera) {
        inventario.add(pecera);
        System.out.println("[DB MySQL] INSERT INTO peceras (tipo, precio) VALUES ('"
                + pecera.getTipo() + "', " + pecera.getPrecio() + ")");
    }

    @Override
    public List<Pecera> listar() {
        return new ArrayList<>(inventario);
    }
}

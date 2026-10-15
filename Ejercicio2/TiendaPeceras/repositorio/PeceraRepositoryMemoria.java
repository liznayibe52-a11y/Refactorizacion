package repositorio;

import java.util.ArrayList;
import java.util.List;
import modelo.Pecera;

/** Implementación en memoria: útil para pruebas, sin tocar ninguna base de datos. */
public class PeceraRepositoryMemoria implements PeceraRepository {
    private final List<Pecera> inventario = new ArrayList<>();

    @Override
    public void guardar(Pecera pecera) {
        inventario.add(pecera);
    }

    @Override
    public List<Pecera> listar() {
        return new ArrayList<>(inventario);
    }
}

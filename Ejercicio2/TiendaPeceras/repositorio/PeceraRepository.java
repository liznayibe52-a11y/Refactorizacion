package repositorio;

import java.util.List;
import modelo.Pecera;

/** Abstracción de persistencia (DIP): el negocio no conoce la base de datos. */
public interface PeceraRepository {
    void guardar(Pecera pecera);
    List<Pecera> listar();
}

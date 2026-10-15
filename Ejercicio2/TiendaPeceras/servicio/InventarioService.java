package servicio;

import java.util.List;
import modelo.Pecera;
import repositorio.PeceraRepository;

/** Única responsabilidad: gestionar el inventario de peceras. */
public class InventarioService {
    private final PeceraRepository repositorio;

    public InventarioService(PeceraRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void agregarPecera(String tipo, double precio) {
        repositorio.guardar(new Pecera(tipo, precio));
    }

    public List<Pecera> listarPeceras() {
        return repositorio.listar();
    }
}

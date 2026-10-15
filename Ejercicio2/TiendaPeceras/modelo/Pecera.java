package modelo;

/** Entidad de dominio: representa una pecera del inventario. */
public class Pecera {
    private final String tipo;
    private final double precio;

    public Pecera(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return tipo + " - $" + precio;
    }
}

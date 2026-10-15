package descuento;

/** Abstracción para descuentos (OCP): nuevos tipos de cliente = nuevas clases. */
public interface EstrategiaDescuento {
    double aplicar(double precio);
}

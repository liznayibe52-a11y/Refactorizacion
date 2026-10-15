package descuento;

/** Cliente mayorista: 25% de descuento. */
public class DescuentoMayorista implements EstrategiaDescuento {
    private static final double FACTOR = 0.75;

    @Override
    public double aplicar(double precio) {
        return precio * FACTOR;
    }
}

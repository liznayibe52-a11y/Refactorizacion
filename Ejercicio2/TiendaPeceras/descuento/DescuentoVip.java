package descuento;

/** Cliente VIP: 15% de descuento. */
public class DescuentoVip implements EstrategiaDescuento {
    private static final double FACTOR = 0.85;

    @Override
    public double aplicar(double precio) {
        return precio * FACTOR;
    }
}

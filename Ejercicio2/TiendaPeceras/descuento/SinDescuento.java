package descuento;

public class SinDescuento implements EstrategiaDescuento {
    @Override
    public double aplicar(double precio) {
        return precio;
    }
}

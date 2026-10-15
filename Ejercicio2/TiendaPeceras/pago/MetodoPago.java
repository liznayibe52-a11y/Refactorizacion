package pago;

/** Abstracción de pago (OCP + DIP): cada método de pago es una clase nueva. */
public interface MetodoPago {
    void procesar(double monto);
}

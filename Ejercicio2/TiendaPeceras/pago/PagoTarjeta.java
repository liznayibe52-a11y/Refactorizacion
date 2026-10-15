package pago;

public class PagoTarjeta implements MetodoPago {
    @Override
    public void procesar(double monto) {
        System.out.println("Conectando con pasarela de pago con tarjeta... Procesando $" + monto);
    }
}

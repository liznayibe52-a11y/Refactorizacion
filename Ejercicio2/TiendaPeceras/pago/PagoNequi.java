package pago;

public class PagoNequi implements MetodoPago {
    @Override
    public void procesar(double monto) {
        System.out.println("Conectando con API de Nequi... Procesando $" + monto);
    }
}

package servicio;

import notificacion.Notificador;
import pago.MetodoPago;

/** Única responsabilidad: cobrar y confirmar el pago, usando abstracciones. */
public class ProcesadorPago {
    private final Notificador notificador;

    public ProcesadorPago(Notificador notificador) {
        this.notificador = notificador;
    }

    public void procesar(MetodoPago metodoPago, double monto, String emailCliente) {
        metodoPago.procesar(monto);
        notificador.notificar(emailCliente, "Su pago de $" + monto + " fue exitoso.");
    }
}

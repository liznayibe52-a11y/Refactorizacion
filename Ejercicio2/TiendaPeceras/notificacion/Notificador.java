package notificacion;

/** Abstracción de notificaciones (DIP): hoy correo, mañana SMS o WhatsApp. */
public interface Notificador {
    void notificar(String destino, String mensaje);
}

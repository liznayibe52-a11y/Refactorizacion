package notificacion;

public class NotificadorEmailSmtp implements Notificador {
    @Override
    public void notificar(String destino, String mensaje) {
        System.out.println("Enviando correo SMTP a " + destino + ": " + mensaje);
    }
}

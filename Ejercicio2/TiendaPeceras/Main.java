import descuento.DescuentoMayorista;
import descuento.DescuentoVip;
import descuento.SinDescuento;
import modelo.Cliente;
import notificacion.NotificadorEmailSmtp;
import pago.PagoNequi;
import pago.PagoTarjeta;
import repositorio.PeceraRepositoryMySQL;
import servicio.CalculadoraPrecio;
import servicio.InventarioService;
import servicio.ProcesadorPago;

/** Composición de dependencias: aquí (y solo aquí) se eligen las implementaciones concretas. */
public class Main {
    public static void main(String[] args) {
        InventarioService inventario = new InventarioService(new PeceraRepositoryMySQL());
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        ProcesadorPago procesadorPago = new ProcesadorPago(new NotificadorEmailSmtp());

        System.out.println("=== Inventario ===");
        inventario.agregarPecera("Pecera 20L", 80000);
        inventario.agregarPecera("Pecera 60L", 250000);
        inventario.listarPeceras().forEach(System.out::println);

        System.out.println("\n=== Cálculo de totales (pecera de $100000) ===");
        Cliente normal = new Cliente("Ana", "ana@correo.com", new SinDescuento());
        Cliente vip = new Cliente("Luis", "luis@correo.com", new DescuentoVip());
        Cliente mayorista = new Cliente("Tienda Peces SAS", "ventas@peces.com", new DescuentoMayorista());

        System.out.println("Normal:    $" + calculadora.calcularTotal(100000, normal.getDescuento()));
        System.out.println("VIP:       $" + calculadora.calcularTotal(100000, vip.getDescuento()));
        System.out.println("Mayorista: $" + calculadora.calcularTotal(100000, mayorista.getDescuento()));

        System.out.println("\n=== Pagos ===");
        double totalVip = calculadora.calcularTotal(100000, vip.getDescuento());
        procesadorPago.procesar(new PagoTarjeta(), totalVip, vip.getEmail());
        procesadorPago.procesar(new PagoNequi(), calculadora.calcularTotal(100000, normal.getDescuento()), normal.getEmail());
    }
}

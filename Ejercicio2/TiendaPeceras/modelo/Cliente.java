package modelo;

import descuento.EstrategiaDescuento;

/** Cliente con su correo y la estrategia de descuento que le corresponde. */
public class Cliente {
    private final String nombre;
    private final String email;
    private final EstrategiaDescuento descuento;

    public Cliente(String nombre, String email, EstrategiaDescuento descuento) {
        this.nombre = nombre;
        this.email = email;
        this.descuento = descuento;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public EstrategiaDescuento getDescuento() { return descuento; }
}

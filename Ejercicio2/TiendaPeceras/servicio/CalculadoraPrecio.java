package servicio;

import descuento.EstrategiaDescuento;

/** Única responsabilidad: calcular el total con IVA y descuento. */
public class CalculadoraPrecio {
    private static final double IVA = 0.19;

    public double calcularTotal(double precioBase, EstrategiaDescuento descuento) {
        double conImpuesto = precioBase * (1 + IVA);
        return descuento.aplicar(conImpuesto);
    }
}

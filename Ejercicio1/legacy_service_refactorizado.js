/*
 * TALLER 3.4 - BUENAS PRÁCTICAS DE PROGRAMACIÓN Y REFACTORIZACIÓN
 */

// --- CONSTANTES DE NEGOCIO ---
const TIPO_USUARIO_VIP = 1;
const PORCENTAJE_DESCUENTO_VIP = 0.10;
const TASA_IMPUESTO_BASE = 0.19;
const TASA_IMPUESTO_ADICIONAL = 0.05;
const MONTO_LIMITE_IMPUESTO_ADICIONAL = 200000;

const db = {
  query(sql) {
    console.log("[BD]", sql);
  }
};

// --- FUNCIONES CON RESPONSABILIDAD ÚNICA  ---

/**
 * Aplica una tasa de impuesto a una cantidad dada 
 */
function calcularImpuesto(monto, tasa) {
  return monto * tasa;
}

/**
 * Realiza el cálculo financiero completo del pedido (Subtotal, Descuentos e Impuestos)
 */
function calcularTotalesPedido(usuario, items) {
  let subtotal = 0;

  for (let i = 0; i < items.length; i++) {
    subtotal += items[i].precio * items[i].cantidad;
  }

  if (usuario.tipo === TIPO_USUARIO_VIP) {
    subtotal -= subtotal * PORCENTAJE_DESCUENTO_VIP;
  }

  const impuestoBase = calcularImpuesto(subtotal, TASA_IMPUESTO_BASE);
  const totalParcial = subtotal + impuestoBase;

  let impuestoAdicional = 0;
  if (totalParcial > MONTO_LIMITE_IMPUESTO_ADICIONAL) {
    impuestoAdicional = calcularImpuesto(totalParcial, TASA_IMPUESTO_ADICIONAL);
  }

  const impuestoTotal = impuestoBase + impuestoAdicional;
  const totalFinal = totalParcial + impuestoAdicional;

  return {
    subtotal,
    impuestoTotal,
    totalFinal
  };
}

/**
 * Presenta el resumen del pedido en la consola
 */
function mostrarFactura(nombreUsuario, resumenTotales) {
  console.log("Factura para " + nombreUsuario);
  console.log("Subtotal: $" + resumenTotales.subtotal.toFixed(2));
  console.log("Impuestos: $" + resumenTotales.impuestoTotal.toFixed(2));
  console.log("TOTAL: $" + resumenTotales.totalFinal.toFixed(2));
}

/**
 * Envia la transacción a la base de datos
 */
function guardarVentaEnBD(idUsuario, totalFinal) {
  db.query(
    "INSERT INTO sales VALUES (" +
      idUsuario +
      "," +
      totalFinal.toFixed(2) +
      ")"
  );
}

/**
 * Función principal que orquesta el proceso del pedido
 */
function procesarPedido(usuario, items) {
  const totales = calcularTotalesPedido(usuario, items);

  mostrarFactura(usuario.nombre, totales);
  guardarVentaEnBD(usuario.id, totales.totalFinal);

  return totales.totalFinal;
}

// --- CASOS DE PRUEBA ---
const users = [
  { id: 1, nombre: "Carlos", tipo: 1 },
  { id: 2, nombre: "Laura", tipo: 0 }
];

const orders = [
  [
    { precio: 80000, cantidad: 2 },
    { precio: 25000, cantidad: 1 }
  ],
  [
    { precio: 50000, cantidad: 1 },
    { precio: 20000, cantidad: 2 },
    { precio: 10000, cantidad: 3 }
  ]
];

console.log("=== PEDIDO 1 ===");
procesarPedido(users[0], orders[0]);

console.log("\n=== PEDIDO 2 ===");
procesarPedido(users[1], orders[1]);
/*
 * legacy_service.js
 *
 * TALLER 3.4 - BUENAS PRÁCTICAS DE PROGRAMACIÓN Y REFACTORIZACIÓN
 *
 * INSTRUCCIONES PARA EL APRENDIZ
 *
 * Este programa funciona, pero está escrito deliberadamente con problemas
 * de mantenibilidad. NO cambies el resultado funcional del programa.
 *
 * Debes refactorizarlo aplicando:
 *
 * 1. Renombrado:
 *    - Cambia nombres como p, u, i, t, x, imp, tot.
 *    - Usa nombres que expresen claramente el negocio.
 *
 * 2. Descomposición:
 *    - Extrae la función p() en mínimo 3 funciones.
 *    - Cada función debe tener una responsabilidad clara.
 *
 * 3. Eliminar código duplicado:
 *    - Hay dos cálculos de impuesto.
 *    - Identifica la lógica repetida y conviértela en una función reutilizable.
 *
 * 4. Constantes:
 *    - Elimina los números mágicos 1, 0.19, 0.05 y 0.10.
 *
 * 5. SRP:
 *    - Separa cálculo, presentación y persistencia.
 *
 * 6. Comprobación:
 *    - El resultado final de cada pedido debe conservarse.
 *
 * RESTRICCIÓN:
 * No agregues frameworks ni paquetes externos.
 * El archivo debe ejecutarse con:
 *
 *     node legacy_service.js
 *
 * Al finalizar, compara tu código con la lista de chequeo de la guía.
 */

const db = {
  query(sql) {
    console.log("[BD]", sql);
  }
};

function p(u, i) {
  let t = 0;

  for (let x = 0; x < i.length; x++) {
    t += i[x].p * i[x].q;
  }

  if (u.t == 1) {
    t = t - (t * 0.10);
  }

  let imp = t * 0.19;
  let tot = t + imp;

  // Segundo cálculo de impuesto: duplicación intencional
  let imp2 = 0;
  if (tot > 200000) {
    imp2 = tot * 0.05;
  }

  tot = tot + imp2;

  console.log("Factura para " + u.n);
  console.log("Subtotal: $" + t.toFixed(2));
  console.log("Impuestos: $" + (imp + imp2).toFixed(2));
  console.log("TOTAL: $" + tot.toFixed(2));

  db.query(
    "INSERT INTO sales VALUES (" +
      u.id +
      "," +
      tot.toFixed(2) +
      ")"
  );

  return tot;
}

// Casos de prueba para el aprendiz
const users = [
  { id: 1, n: "Carlos", t: 1 },
  { id: 2, n: "Laura", t: 0 }
];

const orders = [
  [
    { p: 80000, q: 2 },
    { p: 25000, q: 1 }
  ],
  [
    { p: 50000, q: 1 },
    { p: 20000, q: 2 },
    { p: 10000, q: 3 }
  ]
];

console.log("=== PEDIDO 1 ===");
p(users[0], orders[0]);

console.log("\n=== PEDIDO 2 ===");
p(users[1], orders[1]);

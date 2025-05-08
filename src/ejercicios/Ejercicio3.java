package ejercicios;

import java.util.Scanner;
import java.util.logging.Logger;

public class Ejercicio3 {
  /*Ejercicio 3:   Simular un inventario de productos (usar un array para nombres y otro para cantidades). Funciones para:
agregarProducto() (nombre y cantidad).
buscarProducto() (por nombre).
actualizarStock() (incrementar/disminuir).
mostrarInventario().
Validar que no se repitan productos (usar condicionales).*/
  public static final Logger log = Logger.getLogger(Ejercicio3.class.getName());

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    log.info("Ingrese la cantidad máxima de productos a gestionar:");
    int capacidad = sc.nextInt();

    String[] nombreProductos = new String[capacidad];
    int[] cantidadProductos = new int[capacidad];

    int opcion;
    do {
      log.info("--- Menú ---");
      log.info("1. Agregar producto");
      log.info("2. Buscar producto");
      log.info("3. Actualizar stock");
      log.info("4. Mostrar inventario");
      log.info("0. Salir");
      log.info("Seleccione una opción:");
      opcion = sc.nextInt();

      switch (opcion) {
        case 1:
          agregarProducto(nombreProductos, cantidadProductos);
          break;
        case 2:
          buscarProducto(nombreProductos, cantidadProductos);
          break;
        case 3:
          actualizarStock(nombreProductos, cantidadProductos);
          break;
        case 4:
          mostrarInventario(nombreProductos, cantidadProductos);
          break;
        case 0:
          log.info("Saliendo del programa...");
          break;
        default:
          log.info("Opción inválida. Intente nuevamente.");
      }
    } while (opcion != 0);
  }

  public static void agregarProducto(String[] nombreProductos, int[] cantidadProductos) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < nombreProductos.length; i++) {
      log.info("Ingrese nombre del producto " + (i + 1) + ":");
      String nombre = sc.nextLine().trim();

      // Verificar si el producto ya existe
      boolean repetido = false;
      for (int j = 0; j < nombreProductos.length; j++) {
        if (nombreProductos[j] != null && nombre.equalsIgnoreCase(nombreProductos[j])) {
          log.warning("❗ Producto ya existente. No se agregará.");
          repetido = true;
          break;
        }
      }
      if (repetido) continue; // saltar al siguiente producto sin agregar nada
      nombreProductos[i] = nombre;
      log.info("Ingrese cantidad en stock:");
      cantidadProductos[i] = sc.nextInt();
      sc.nextLine();
    }
  }

  public static void buscarProducto(String[] nombreProductos, int[] cantidadProductos) {
    Scanner sc = new Scanner(System.in);
    log.info("Ingrese el producto que quiere buscar:");
    String productoBuscado = sc.nextLine().trim().toLowerCase();

    boolean productoEncontrado = false;

    for (int i = 0; i < nombreProductos.length; i++) {
      if (nombreProductos[i] != null &&
          nombreProductos[i].toLowerCase().equals(productoBuscado)) {
        log.info("Producto encontrado: " + nombreProductos[i] + " | Cantidad en stock: " + cantidadProductos[i]);
        productoEncontrado = true;
        break;
      }
    }
    if (!productoEncontrado) {
      log.info("Producto no encontrado.");
    }
  }
  public static void actualizarStock(String[] nombreProductos, int[] cantidadProductos){
    Scanner sc = new Scanner(System.in);
    log.info("Ingrese el producto que quiere buscar:");
    String productoBuscado = sc.nextLine().trim().toLowerCase();

    boolean productoEncontrado = false;

    for (int i = 0; i < nombreProductos.length; i++) {
      if (nombreProductos[i] != null &&
          nombreProductos[i].toLowerCase().equals(productoBuscado)) {
        log.info("Ingrese el stock");
        cantidadProductos[i] = sc.nextInt();
        productoEncontrado = true;
        break;
      }
    }
    if (!productoEncontrado) {
      log.info("Producto no encontrado.");
    }
  }
  public static void mostrarInventario(String[] nombreProductos, int[] cantidadProductos){
    for(int i=0; i<nombreProductos.length;i++){
      log.info("Producto: "+nombreProductos[i]+" Stock: "+cantidadProductos[i]);
    }
  }
}


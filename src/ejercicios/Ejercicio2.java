package ejercicios;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ejercicio2 {
  /*Ejercicio 2:   Generar un array con números aleatorios (entre 1 y 100) y permitir al usuario buscar un número en él.
Función para generar el array con números aleatorios (generarArray()).
Función para buscar un número y devolver su posición (buscarNumero()).
Función para ordenar el array (ordenarArray()).
Función para mostrar el array (mostrarArray()).*/
  public static final Logger log = Logger.getLogger(Ejercicio2.class.getName());

  public static void main(String[] args) {
    int cantidadNrosRandom = ingresarNro("la cantidad de numeros aleatorios que quiere crear ");
    int[] arrayNros = new int[cantidadNrosRandom];
    generarArray(arrayNros);
    log.info("Numero encontrado en la posicion " + buscarNumero(arrayNros));
    ordenarArray(arrayNros);
    mostrarArray(arrayNros);

  }

  public static int ingresarNro(String mensaje) {
    int nro;
    log.info("Por favor ingrese la cantidad de " + mensaje);
    Scanner sc = new Scanner(System.in);
    nro = sc.nextInt();
    return nro;
  }

  public static void generarArray(int[] arrayNros) {
    for (int i = 0; i < arrayNros.length; i++) {
      arrayNros[i] = (int) (Math.random() * 101);
    }
  }

  public static int buscarNumero(int[] arrayNros) {
    Scanner sc = new Scanner(System.in);
    int posicionNro = -1;
    boolean seguirBuscando;
    do {
      log.info("Introduzca el número que quiere buscar:");
      int numeroBuscado = sc.nextInt();
      posicionNro = -1;
      for (int i = 0; i < arrayNros.length; i++) {
        if (arrayNros[i] == numeroBuscado) {
          posicionNro = i + 1; // Para mostrar posición "humana"
          break;
        }
      }
      if (posicionNro == -1) {
        log.info("Número no encontrado. ¿Desea intentar nuevamente? (s/n)");
        String respuesta = sc.next();
        seguirBuscando = respuesta.equalsIgnoreCase("s");
      } else {
        seguirBuscando = false;
      }
    } while (seguirBuscando);
    return posicionNro;
  }

  public static void ordenarArray(int[] arrayNros) {
    Arrays.sort(arrayNros);
  }

  public static void mostrarArray(int[] arrayNros) {
    int posicion = 1;
    log.info("Array ordenado:");
    for (int arrayNro : arrayNros) {
      log.info("Posicion " + posicion + " Nro " + arrayNro);
      posicion++;
    }
  }
}


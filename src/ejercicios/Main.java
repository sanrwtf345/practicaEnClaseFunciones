package ejercicios;

import java.util.Scanner;
import java.util.logging.Logger;


public class Main {
  /*Ejercicio 1: Crear un programa que permita ingresar las notas de  estudiantes y calcule:
El promedio de notas.
La nota más alta.
La nota más baja.
Cantidad de aprobados (nota ≥ 6).
Usar un array para almacenar las notas.
Funciones para cada cálculo (calcularPromedio(), encontrarMaxima(), etc.).
Validar que las notas estén entre 0 y 10*/
  public static final Logger log = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    //int cantidadEstudiantes= ingresarNro("la cantidad de estudiantes");
    int cantidadNotas = ingresarNro("la cantidad de notas");

    int[] notas = new int[cantidadNotas];

    cargarNotasEnArray(notas);
    mostrarNotas(notas);
    log.info("La nota mas alta " + encontrarElMayor(notas));
    log.info("La nota mas baja " + encontrarElMenor(notas));
    log.info("El promedio es " + calcularPromedio(notas));
    log.info("Alumnos aprobados " + obtenerCantAprobados(notas));

  }

  public static int ingresarNro(String mensaje) {
    int nro;
    log.info("Por favor ingrese la cantidad de " + mensaje);
    Scanner sc = new Scanner(System.in);
    nro = sc.nextInt();
    return nro;
  }

  public static void cargarNotasEnArray(int[] notas) {
    for (int i = 0; i < notas.length; i++) {
      notas[i] = ingresarNro("la nota del estudiante " + (i + 1));
    }
  }

  public static void mostrarNotas(int[] notas) {
    for (int i = 0; i < notas.length; i++) {
      log.info("La nota " + (i + 1) + "es " + notas[i]);
    }
  }

  public static int obtenerCantAprobados(int[] notas) {
    int alumnosAprobados = 0;
    for (int i = 0; i < notas.length; i++) {
      if (notas[i] >= 6) {
        alumnosAprobados++;
      }
    }
    return alumnosAprobados;
  }

  public static int encontrarElMayor(int[] notas) {
    int mayor = 0;
    for (int i = 0; i < notas.length; i++) {
      mayor = (notas[i] > mayor) ? notas[i] : mayor;
    }
    return mayor;
  }

  public static int encontrarElMenor(int[] notas) {
    int menor = 10;
    for (int i = 0; i < notas.length; i++) {
      menor = (notas[i] < menor) ? notas[i] : menor;
    }
    return menor;
  }

  public static int calcularPromedio(int[] notas) {
    int suma = 0;
    for (int i = 0; i < notas.length; i++) {
      suma += notas[i];
    }

    int promedio = 0;
    if (notas.length > 0) {
      promedio = suma / notas.length; // División entera
    }

    return promedio;
  }
}
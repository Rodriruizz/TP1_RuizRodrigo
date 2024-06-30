package ar.edu.unju.fi.ejercicio4;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Ingrese un número entero entre 0 y 10:");
	     int numero = scanner.nextInt();
	     if (numero < 0 || numero > 10) {
	            System.out.println("El número debe estar entre 0 y 10.");
	        } else {
	            int factorial = 1;
	            int i = numero;
	            while (i > 0) {
	                factorial *= i;
	                i--;
	            }
	            System.out.println("El factorial de " + numero + " es: " + factorial);
	        }        
	     scanner.close();
	 }
}

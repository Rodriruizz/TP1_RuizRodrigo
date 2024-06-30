package ar.edu.unju.fi.ejercicio5;
import java.util.Scanner;
public class Main {
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Ingrese un número entero entre 1 y 9:");
	     int numero = scanner.nextInt();
	     if (numero < 1 || numero > 9) {
	            System.out.println("El número debe estar entre 1 y 9.");
	        } else {
	            System.out.println("Tabla de multiplicar del " + numero + ":");
	            for (int i = 1; i <= 10; i++) {
	                System.out.println(numero + " x " + i + " = " + (numero * i));
	            }
	        }
	     scanner.close();
	 }
}

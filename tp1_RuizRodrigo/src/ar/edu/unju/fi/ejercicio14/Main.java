package ar.edu.unju.fi.ejercicio14;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamañoArray;
        do {
            System.out.print("Ingrese un número entero en el rango [3, 10]: ");
            tamañoArray = scanner.nextInt();
        } while (tamañoArray < 3 || tamañoArray > 10);

        int[] numeros = new int[tamañoArray];

        for (int i = 0; i < tamañoArray; i++) {
            System.out.print("Ingrese un número entero para la posición " + i + ": ");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("\nValores en el array:");
        for (int i = 0; i < tamañoArray; i++) {
            System.out.println("Posición " + i + ": " + numeros[i]);
        }

        int suma = 0;
        for (int i = 0; i < tamañoArray; i++) {
            suma += numeros[i];
        }
        System.out.println("\nSuma de todos los valores en el array: " + suma);

        scanner.close();
    }
}

package ar.edu.unju.fi.ejercicio15;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamañoArray;
        do {
            System.out.print("Ingrese un número entero en el rango [5, 10]: ");
            tamañoArray = scanner.nextInt();
        } while (tamañoArray < 5 || tamañoArray > 10);

        String[] nombres = new String[tamañoArray];

        scanner.nextLine(); 
        for (int i = 0; i < tamañoArray; i++) {
            System.out.print("Ingrese el nombre para la posición " + i + ": ");
            nombres[i] = scanner.nextLine();
        }

        System.out.println("\nContenido del array (desde el primer índice):");
        for (int i = 0; i < tamañoArray; i++) {
            System.out.println("Posición " + i + ": " + nombres[i]);
        }

        System.out.println("\nContenido del array (desde el último índice):");
        for (int i = tamañoArray - 1; i >= 0; i--) {
            System.out.println("Posición " + i + ": " + nombres[i]);
        }

        scanner.close();
    }
}

package ar.edu.unju.fi.ejercicio16;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nombres = new String[5];

        System.out.println("Ingrese 5 nombres de personas:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Nombre " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }

        System.out.println("\nValores guardados en el array:");
        int index = 0;
        while (index < nombres.length) {
            System.out.println("Nombre " + (index + 1) + ": " + nombres[index]);
            index++;
        }

        System.out.println("\nTamaño del array: " + nombres.length);

        byte indiceAEliminar;
        do {
            System.out.print("Ingrese el índice (entre 0 y " + (nombres.length - 1) + ") del elemento a eliminar: ");
            indiceAEliminar = scanner.nextByte();
        } while (indiceAEliminar < 0 || indiceAEliminar >= nombres.length);

        nombres[indiceAEliminar] = "";

        System.out.println("\nValores del array después de eliminar el elemento:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Nombre " + (i + 1) + ": " + nombres[i]);
        }

        scanner.close();
    }
}

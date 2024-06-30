package ar.edu.unju.fi.ejercicio9.main;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto[] productos = new Producto[3];

        for (int i = 0; i < productos.length; i++) {
            productos[i] = new Producto();
            System.out.println("Ingrese el nombre del producto " + (i + 1) + ":");
            productos[i].setNombre(scanner.nextLine());
            System.out.println("Ingrese el código del producto " + (i + 1) + ":");
            productos[i].setCodigo(scanner.nextLine());
            System.out.println("Ingrese el precio del producto " + (i + 1) + ":");
            productos[i].setPrecio(scanner.nextDouble());
            System.out.println("Ingrese el descuento del producto " + (i + 1) + " (0-50):");
            productos[i].setDescuento(scanner.nextInt());
            scanner.nextLine();  
        }

        for (int i = 0; i < productos.length; i++) {
            System.out.println("\nDatos del producto " + (i + 1) + ":");
            System.out.println("Nombre: " + productos[i].getNombre());
            System.out.println("Código: " + productos[i].getCodigo());
            System.out.println("Precio: " + productos[i].getPrecio());
            System.out.println("Descuento: " + productos[i].getDescuento() + "%");
            System.out.println("Precio con descuento: " + productos[i].calcularDescuento());
        }

        scanner.close();
    }
}
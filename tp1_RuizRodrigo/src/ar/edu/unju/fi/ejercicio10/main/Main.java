package ar.edu.unju.fi.ejercicio10.main;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio10.model.Pizza;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizza[] pizzas = new Pizza[3];

        for (int i = 0; i < pizzas.length; i++) {
            pizzas[i] = new Pizza();
            System.out.println("Ingrese el diámetro de la pizza " + (i + 1) + " (20, 30, 40):");
            int diametro = scanner.nextInt();
            pizzas[i].setDiametro(diametro);

            System.out.println("¿La pizza " + (i + 1) + " tiene ingredientes especiales? (true/false):");
            boolean ingredientesEspeciales = scanner.nextBoolean();
            pizzas[i].setIngredientesEspeciales(ingredientesEspeciales);

            pizzas[i].calcularPrecio();
            pizzas[i].calcularArea();
        }

        for (int i = 0; i < pizzas.length; i++) {
            System.out.println("\nDatos de la pizza " + (i + 1) + ":");
            System.out.println("Diámetro: " + pizzas[i].getDiametro() + " cm");
            System.out.println("Ingredientes especiales: " + pizzas[i].isIngredientesEspeciales());
            System.out.println("Área: " + pizzas[i].getArea() + " cm²");
            System.out.println("Precio: $" + pizzas[i].getPrecio());
        }

        scanner.close();
    }
}
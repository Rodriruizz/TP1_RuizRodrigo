package ar.edu.unju.fi.ejercicio6.main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Persona persona1 = new Persona();
        System.out.println("Ingrese el DNI de la primera persona:");
        persona1.setDni(scanner.nextLine());
        System.out.println("Ingrese el nombre de la primera persona:");
        persona1.setNombre(scanner.nextLine());
        System.out.println("Ingrese la fecha de nacimiento de la primera persona (yyyy-MM-dd):");
        persona1.setFechaNacimiento(LocalDate.parse(scanner.nextLine(), formatter));
        System.out.println("Ingrese la provincia de la primera persona:");
        persona1.setProvincia(scanner.nextLine());
        persona1.mostrarDatos();

        System.out.println("Ingrese el DNI de la segunda persona:");
        String dni2 = scanner.nextLine();
        System.out.println("Ingrese el nombre de la segunda persona:");
        String nombre2 = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento de la segunda persona (yyyy-MM-dd):");
        LocalDate fechaNacimiento2 = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Ingrese la provincia de la segunda persona:");
        String provincia2 = scanner.nextLine();
        Persona persona2 = new Persona(dni2, nombre2, fechaNacimiento2, provincia2);
        persona2.mostrarDatos();

        System.out.println("Ingrese el DNI de la tercera persona:");
        String dni3 = scanner.nextLine();
        System.out.println("Ingrese el nombre de la tercera persona:");
        String nombre3 = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento de la tercera persona (yyyy-MM-dd):");
        LocalDate fechaNacimiento3 = LocalDate.parse(scanner.nextLine(), formatter);
        Persona persona3 = new Persona(dni3, nombre3, fechaNacimiento3);
        persona3.mostrarDatos();

        scanner.close();
    }
}

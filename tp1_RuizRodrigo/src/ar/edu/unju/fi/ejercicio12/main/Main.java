package ar.edu.unju.fi.ejercicio12.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la persona: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el año de nacimiento: ");
        int year = scanner.nextInt();

        System.out.print("Ingrese el mes de nacimiento (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Ingrese el día de nacimiento: ");
        int day = scanner.nextInt();

        Calendar fechaNacimiento = new GregorianCalendar(year, month - 1, day);

        Persona persona = new Persona(nombre, fechaNacimiento);

        System.out.println("\nDatos de la persona:");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Fecha de nacimiento: " + persona.getFechaNacimiento().getTime());
        System.out.println("Edad: " + persona.calcularEdad() + " años");
        System.out.println("Signo del zodiaco: " + persona.obtenerSignoZodiaco());
        System.out.println("Estación del año: " + persona.obtenerEstacion());

        scanner.close();
    }
}

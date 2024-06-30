package ar.edu.unju.fi.ejercicio17.main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 – Alta de jugador");
            System.out.println("2 – Mostrar los datos del jugador");
            System.out.println("3 – Mostrar todos los jugadores ordenados por apellido");
            System.out.println("4 – Modificar los datos de un jugador");
            System.out.println("5 – Eliminar un jugador");
            System.out.println("6 – Mostrar la cantidad total de jugadores");
            System.out.println("7 – Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
            System.out.println("8 – Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    altaJugador(jugadores, scanner);
                    break;
                case 2:
                    mostrarDatosJugador(jugadores, scanner);
                    break;
                case 3:
                    mostrarJugadoresOrdenados(jugadores);
                    break;
                case 4:
                    modificarDatosJugador(jugadores, scanner);
                    break;
                case 5:
                    eliminarJugador(jugadores, scanner);
                    break;
                case 6:
                    mostrarCantidadTotalJugadores(jugadores);
                    break;
                case 7:
                    mostrarCantidadJugadoresPorNacionalidad(jugadores, scanner);
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 8);

        scanner.close();
    }

    private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("\nIngrese los datos del nuevo jugador:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
        String fechaNacimientoStr = scanner.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ISO_DATE);

        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        System.out.print("Estatura: ");
        double estatura = scanner.nextDouble();

        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Consumir salto de línea

        System.out.print("Posición (delantero, medio, defensa, arquero): ");
        String posicion = scanner.nextLine();

        Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(nuevoJugador);
        System.out.println("Jugador agregado correctamente.");
    }

    private static void mostrarDatosJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.print("\nIngrese el nombre del jugador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.nextLine();

        boolean encontrado = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("\nDatos del jugador:");
                System.out.println(jugador);
                System.out.println("Edad: " + jugador.calcularEdad() + " años");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró al jugador.");
        }
    }

    private static void mostrarJugadoresOrdenados(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("\nNo hay jugadores para mostrar.");
            return;
        }

        Collections.sort(jugadores, (j1, j2) -> j1.getApellido().compareToIgnoreCase(j2.getApellido()));

        System.out.println("\nLista de jugadores ordenados por apellido:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getApellido() + ", " + jugador.getNombre());
        }
    }

    private static void modificarDatosJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.print("\nIngrese el nombre del jugador a modificar: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del jugador a modificar: ");
        String apellido = scanner.nextLine();

        boolean encontrado = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("\nIngrese los nuevos datos del jugador:");

                System.out.print("Nuevo nombre: ");
                jugador.setNombre(scanner.nextLine());

                System.out.print("Nuevo apellido: ");
                jugador.setApellido(scanner.nextLine());

                System.out.print("Nueva fecha de nacimiento (yyyy-MM-dd): ");
                String fechaNacimientoStr = scanner.nextLine();
                LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ISO_DATE);
                jugador.setFechaNacimiento(fechaNacimiento);

                System.out.print("Nueva nacionalidad: ");
                jugador.setNacionalidad(scanner.nextLine());

                System.out.print("Nueva estatura: ");
                jugador.setEstatura(scanner.nextDouble());

                System.out.print("Nuevo peso: ");
                jugador.setPeso(scanner.nextDouble());
                scanner.nextLine(); 

                System.out.print("Nueva posición (delantero, medio, defensa, arquero): ");
                jugador.setPosicion(scanner.nextLine());

                System.out.println("Datos del jugador modificados correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró al jugador.");
        }
    }

    private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.print("\nIngrese el nombre del jugador a eliminar: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del jugador a eliminar: ");
        String apellido = scanner.nextLine();

        Iterator<Jugador> iterator = jugadores.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                iterator.remove();
                System.out.println("Jugador eliminado correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró al jugador.");
        }
    }

    private static void mostrarCantidadTotalJugadores(ArrayList<Jugador> jugadores) {
        System.out.println("\nCantidad total de jugadores: " + jugadores.size());
    }

    private static void mostrarCantidadJugadoresPorNacionalidad(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.print("\nIngrese la nacionalidad para contar jugadores: ");
        String nacionalidad = scanner.nextLine();

        int contador = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
                contador++;
            }
        }

        System.out.println("Cantidad de jugadores de nacionalidad '" + nacionalidad + "': " + contador);
    }
}
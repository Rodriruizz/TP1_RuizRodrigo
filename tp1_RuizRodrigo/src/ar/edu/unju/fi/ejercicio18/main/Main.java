package ar.edu.unju.fi.ejercicio18.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pais> paises = precargarPaises();
        ArrayList<DestinoTuristico> destinos = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 – Alta de destino turístico");
            System.out.println("2 – Mostrar todos los destinos turísticos");
            System.out.println("3 – Modificar el país de un destino turístico");
            System.out.println("4 – Limpiar el ArrayList de destinos turísticos");
            System.out.println("5 – Eliminar un destino turístico");
            System.out.println("6 – Mostrar los destinos turísticos ordenados por nombre");
            System.out.println("7 – Mostrar todos los países");
            System.out.println("8 – Mostrar los destinos turísticos de un país");
            System.out.println("9 – Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (opcion) {
                    case 1:
                        altaDestinoTuristico(destinos, paises, scanner);
                        break;
                    case 2:
                        mostrarDestinosTuristicos(destinos);
                        break;
                    case 3:
                        modificarPaisDestino(destinos, paises, scanner);
                        break;
                    case 4:
                        limpiarArrayList(destinos);
                        break;
                    case 5:
                        eliminarDestinoTuristico(destinos, scanner);
                        break;
                    case 6:
                        mostrarDestinosOrdenados(destinos);
                        break;
                    case 7:
                        mostrarTodosPaises(paises);
                        break;
                    case 8:
                        mostrarDestinosPorPais(destinos, scanner);
                        break;
                    case 9:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 9);

        scanner.close();
    }

    private static ArrayList<Pais> precargarPaises() {
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(new Pais("ES", "España"));
        paises.add(new Pais("IT", "Italia"));
        paises.add(new Pais("FR", "Francia"));
        paises.add(new Pais("DE", "Alemania"));
        return paises;
    }

    private static void altaDestinoTuristico(ArrayList<DestinoTuristico> destinos, ArrayList<Pais> paises, Scanner scanner) {
        System.out.println("\nIngrese los datos del nuevo destino turístico:");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir salto de línea

        mostrarTodosPaises(paises);
        System.out.print("Código del país: ");
        String codigoPais = scanner.nextLine();

        Pais paisSeleccionado = buscarPaisPorCodigo(paises, codigoPais);
        if (paisSeleccionado == null) {
            throw new IllegalArgumentException("El código de país ingresado no es válido.");
        }

        System.out.print("Cantidad de días: ");
        int cantidadDias = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        DestinoTuristico nuevoDestino = new DestinoTuristico(codigo, nombre, precio, paisSeleccionado, cantidadDias);
        destinos.add(nuevoDestino);
        System.out.println("Destino turístico agregado correctamente.");
    }

    private static void mostrarDestinosTuristicos(ArrayList<DestinoTuristico> destinos) {
        System.out.println("\nLista de destinos turísticos:");
        for (DestinoTuristico destino : destinos) {
            System.out.println(destino);
        }
    }

    private static void modificarPaisDestino(ArrayList<DestinoTuristico> destinos, ArrayList<Pais> paises, Scanner scanner) {
        System.out.print("\nIngrese el código del destino turístico a modificar: ");
        String codigoDestino = scanner.nextLine();

        DestinoTuristico destino = buscarDestinoPorCodigo(destinos, codigoDestino);
        if (destino == null) {
            throw new IllegalArgumentException("El código de destino turístico ingresado no es válido.");
        }

        mostrarTodosPaises(paises);
        System.out.print("Nuevo código de país: ");
        String nuevoCodigoPais = scanner.nextLine();

        Pais nuevoPais = buscarPaisPorCodigo(paises, nuevoCodigoPais);
        if (nuevoPais == null) {
            throw new IllegalArgumentException("El código de país ingresado no es válido.");
        }

        destino.setPais(nuevoPais);
        System.out.println("País del destino turístico modificado correctamente.");
    }

    private static void limpiarArrayList(ArrayList<DestinoTuristico> destinos) {
        destinos.clear();
        System.out.println("ArrayList de destinos turísticos limpiado correctamente.");
    }

    private static void eliminarDestinoTuristico(ArrayList<DestinoTuristico> destinos, Scanner scanner) {
        System.out.print("\nIngrese el código del destino turístico a eliminar: ");
        String codigoDestino = scanner.nextLine();

        Iterator<DestinoTuristico> iterator = destinos.iterator();
        while (iterator.hasNext()) {
            DestinoTuristico destino = iterator.next();
            if (destino.getCodigo().equals(codigoDestino)) {
                iterator.remove();
                System.out.println("Destino turístico eliminado correctamente.");
                return;
            }
        }

        throw new IllegalArgumentException("El código de destino turístico ingresado no es válido.");
    }

    private static void mostrarDestinosOrdenados(ArrayList<DestinoTuristico> destinos) {
        if (destinos.isEmpty()) {
            System.out.println("\nNo hay destinos turísticos para mostrar.");
            return;
        }

        Collections.sort(destinos, (d1, d2) -> d1.getNombre().compareToIgnoreCase(d2.getNombre()));

        System.out.println("\nDestinos turísticos ordenados por nombre:");
        for (DestinoTuristico destino : destinos) {
            System.out.println(destino);
        }
    }

    private static void mostrarTodosPaises(ArrayList<Pais> paises) {
        System.out.println("\nLista de países disponibles:");
        for (Pais pais : paises) {
            System.out.println(pais);
        }
    }

    private static void mostrarDestinosPorPais(ArrayList<DestinoTuristico> destinos, Scanner scanner) {
        System.out.print("\nIngrese el código del país para mostrar sus destinos turísticos: ");
        String codigoPais = scanner.nextLine();

        System.out.println("\nDestinos turísticos del país con código '" + codigoPais + "':");
        for (DestinoTuristico destino : destinos) {
            if (destino.getPais().getCodigo().equals(codigoPais)) {
                System.out.println(destino);
            }
        }
    }

    private static Pais buscarPaisPorCodigo(ArrayList<Pais> paises, String codigoPais) {
        for (Pais pais : paises) {
            if (pais.getCodigo().equalsIgnoreCase(codigoPais)) {
                return pais;
            }
        }
        return null;
    }

    private static DestinoTuristico buscarDestinoPorCodigo(ArrayList<DestinoTuristico> destinos, String codigoDestino) {
        for (DestinoTuristico destino : destinos) {
            if (destino.getCodigo().equalsIgnoreCase(codigoDestino)) {
                return destino;
            }
        }
        return null;
    }
}

package Tema5;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ListaCompra {

    private Set<String> listaDeseos;
    private Set<String> carroCompra;
    private Scanner sc;

    public ListaCompra() {
        // Usamos TreeSet para orden alfabético y Case Insensitive
        this.listaDeseos = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        this.carroCompra = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ListaCompra app = new ListaCompra();
        app.iniciarApp();
    }

    public void iniciarApp() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
        
        System.out.println("Cerrando lista de la compra...");
        sc.close();
    }

    private void mostrarMenu() {
        System.out.println("\n=== GESTIÓN LISTA DE LA COMPRA ===");
        System.out.println("1. Añadir producto a la lista (Planificación)");
        System.out.println("2. Añadir producto al carro (Comprando)");
        System.out.println("3. Ver lista completa (Planificada)");
        System.out.println("4. Ver carro de la compra (Ya tienes)");
        System.out.println("5. Ver productos pendientes (Te faltan)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int leerOpcion() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1: anadirProductoLista(); break;
            case 2: anadirProductoCarro(); break;
            case 3: mostrarSet("LISTA PLANIFICADA", listaDeseos); break;
            case 4: mostrarSet("EN EL CARRO", carroCompra); break;
            case 5: mostrarPendientes(); break;
            case 0: break;
            default: System.out.println("Opción no válida.");
        }
    }

    // --- MÉTODOS DE GESTIÓN ---

    private void anadirProductoLista() {
        System.out.println("\n--- AÑADIR A LISTA ---");
        System.out.print("Nombre del producto: ");
        String producto = sc.nextLine().trim();
        
        if (producto.isEmpty()) {
            System.out.println("Error: Nombre vacío.");
            return;
        }

        if (listaDeseos.add(producto)) {
            System.out.println("✅ Añadido a la lista: " + producto);
        } else {
            System.out.println("⚠️ El producto ya estaba en la lista.");
        }
    }

    private void anadirProductoCarro() {
        System.out.println("\n--- AÑADIR AL CARRO ---");
        // Mostramos primero lo que hay en la lista para ayudar
        mostrarSet("TU LISTA", listaDeseos);
        
        System.out.print("¿Qué producto has cogido?: ");
        String producto = sc.nextLine().trim();

        if (producto.isEmpty()) return;

        // Verificamos si estaba en la lista original
        if (!listaDeseos.contains(producto)) {
            System.out.println("⚠️ Aviso: '" + producto + "' no estaba en tu lista planificada.");
            System.out.print("¿Añadirlo de todas formas? (s/n): ");
            if (!sc.nextLine().trim().equalsIgnoreCase("s")) {
                return;
            }
            // Si lo añade al carro sin estar en la lista, lo añadimos también a la lista global
            // para mantener la coherencia (o podríamos tratarlo como extra)
            listaDeseos.add(producto);
        }

        if (carroCompra.add(producto)) {
            System.out.println("🛒 Añadido al carro: " + producto);
        } else {
            System.out.println("⚠️ Ya tenías este producto en el carro.");
        }
    }

    private void mostrarSet(String titulo, Set<String> conjunto) {
        System.out.println("\n=== " + titulo + " ===");
        if (conjunto.isEmpty()) {
            System.out.println("(Vacío)");
        } else {
            for (String p : conjunto) {
                System.out.println("- " + p);
            }
            System.out.println("Total: " + conjunto.size());
        }
    }

    private void mostrarPendientes() {
        System.out.println("\n=== PRODUCTOS PENDIENTES (FALTAN) ===");
        
        // Creamos una copia de la lista de deseos para no modificar la original
        // TreeSet hereda el comparador del conjunto original (Case Insensitive)
        Set<String> pendientes = new TreeSet<>(listaDeseos);
        
        // Operación de diferencia de conjuntos: Lista - Carro
        pendientes.removeAll(carroCompra);

        if (pendientes.isEmpty()) {
            if (listaDeseos.isEmpty()) {
                System.out.println("No tienes nada planificado.");
            } else {
                System.out.println("¡Felicidades! Has comprado todo lo de la lista.");
            }
        } else {
            for (String p : pendientes) {
                System.out.println("❌ Faltan: " + p);
            }
            System.out.println("Te faltan " + pendientes.size() + " productos.");
        }
    }
}

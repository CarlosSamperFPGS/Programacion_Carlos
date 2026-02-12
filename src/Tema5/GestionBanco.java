package Tema5;

import Tema4.Actividad1.Utils;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;

public class GestionBanco {

    private Queue<UsuarioBanco> cola;
    private Scanner sc;

    public GestionBanco() {
        this.cola = new LinkedList<>();
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        GestionBanco app = new GestionBanco();
        app.iniciar();
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
        System.out.println(Utils.ansiCyan + "Cerrando sistema de colas..." + Utils.ansiReset);
        sc.close();
    }

    private void mostrarMenu() {
        System.out.println(Utils.ansiBold + "\n=== GESTIÓN COLAS BANCO ===" + Utils.ansiReset);
        System.out.println("1. Añadir persona a la cola");
        System.out.println("2. Atender al siguiente (Quitar primero)");
        System.out.println("3. Persona abandona la cola (Quitar por DNI)");
        System.out.println("4. Mostrar estado de la cola");
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
            case 1: anadirCola(); break;
            case 2: atenderSiguiente(); break;
            case 3: abandonarCola(); break;
            case 4: mostrarCola(); break;
            case 0: break;
            default: System.out.println(Utils.ansiRed + "Opción no válida." + Utils.ansiReset);
        }
    }

    // --- MÉTODOS DE GESTIÓN ---

    private void anadirCola() {
        System.out.println(Utils.ansiBold + "\n--- NUEVO CLIENTE ---" + Utils.ansiReset);
        
        // Validación Nombre
        String nombre = "";
        boolean nombreValido = false;
        while (!nombreValido) {
            System.out.print("Nombre: ");
            nombre = sc.nextLine().trim();
            if (Utils.validateName(nombre)) { // validateName devuelve true si es inválido
                System.out.println(Utils.ansiRed + "Error: Nombre inválido." + Utils.ansiReset);
            } else {
                nombreValido = true;
            }
        }

        // Validación Edad
        int edad = 0;
        boolean edadValida = false;
        while (!edadValida) {
            try {
                System.out.print("Edad: ");
                edad = Integer.parseInt(sc.nextLine());
                if (Utils.validateAge(edad)) {
                    edadValida = true;
                } else {
                    System.out.println(Utils.ansiRed + "Error: Edad fuera de rango." + Utils.ansiReset);
                }
            } catch (NumberFormatException e) {
                System.out.println(Utils.ansiRed + "Error: Introduce un número." + Utils.ansiReset);
            }
        }

        // Generación DNI
        int numDni = 0;
        boolean dniValido = false;
        while (!dniValido) {
            try {
                System.out.print("Número DNI (sin letra): ");
                numDni = Integer.parseInt(sc.nextLine());
                dniValido = true;
            } catch (NumberFormatException e) {
                System.out.println(Utils.ansiRed + "Error: Introduce solo números." + Utils.ansiReset);
            }
        }
        String dni = Utils.letraDni(numDni);

        // Comprobar si ya está en la cola
        for (UsuarioBanco u : cola) {
            if (u.getDni().equals(dni)) {
                System.out.println(Utils.ansiRed + "Error: Esta persona ya está en la cola." + Utils.ansiReset);
                return;
            }
        }

        cola.add(new UsuarioBanco(nombre, edad, dni));
        System.out.println(Utils.ansiGreen + "✅ " + nombre + " añadido a la cola. Posición: " + cola.size() + Utils.ansiReset);
    }

    private void atenderSiguiente() {
        if (cola.isEmpty()) {
            System.out.println(Utils.ansiYellow + "La cola está vacía. No hay nadie a quien atender." + Utils.ansiReset);
            return;
        }

        UsuarioBanco atendido = cola.poll(); // poll recupera y elimina la cabecera, devuelve null si vacía
        System.out.println(Utils.ansiGreen + "🔔 Atendiendo a: " + atendido + Utils.ansiReset);
        System.out.println("Personas restantes en cola: " + cola.size());
    }

    private void abandonarCola() {
        if (cola.isEmpty()) {
            System.out.println(Utils.ansiYellow + "La cola está vacía." + Utils.ansiReset);
            return;
        }

        System.out.println(Utils.ansiBold + "\n--- ABANDONAR COLA ---" + Utils.ansiReset);
        // Pedimos número para generar letra y buscar
        int numDni;
        try {
            System.out.print("Introduce el número de DNI de quien se va: ");
            numDni = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(Utils.ansiRed + "Error: DNI inválido." + Utils.ansiReset);
            return;
        }
        String dniBuscado = Utils.letraDni(numDni);

        boolean encontrado = false;
        Iterator<UsuarioBanco> it = cola.iterator();
        while (it.hasNext()) {
            UsuarioBanco u = it.next();
            if (u.getDni().equals(dniBuscado)) {
                it.remove();
                System.out.println(Utils.ansiYellow + "👋 " + u.getNombre() + " se ha cansado y ha abandonado la cola." + Utils.ansiReset);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(Utils.ansiRed + "No se ha encontrado a nadie con DNI " + dniBuscado + " en la cola." + Utils.ansiReset);
        }
    }

    private void mostrarCola() {
        System.out.println(Utils.ansiBold + "\n--- ESTADO DE LA COLA ---" + Utils.ansiReset);
        if (cola.isEmpty()) {
            System.out.println("(Cola vacía)");
        } else {
            int pos = 1;
            for (UsuarioBanco u : cola) {
                System.out.println(pos + ". " + u);
                pos++;
            }
            System.out.println("Total en espera: " + cola.size());
        }
    }
}

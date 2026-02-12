package Tema5;

import Tema4.Actividad1.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionGimnasio {

    private Map<String, Usuario> usuarios;
    private Scanner sc;

    public GestionGimnasio() {
        this.usuarios = new HashMap<>();
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        GestionGimnasio app = new GestionGimnasio();
        app.iniciar();
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
        System.out.println(Utils.ansiCyan + "Cerrando sistema de gestión..." + Utils.ansiReset);
        sc.close();
    }

    private void mostrarMenu() {
        System.out.println(Utils.ansiBold + "\n=== GESTIÓN GIMNASIO ===" + Utils.ansiReset);
        System.out.println("1. Alta de usuario");
        System.out.println("2. Baja de usuario");
        System.out.println("3. Mostrar datos de usuario");
        System.out.println("4. Modificar usuario");
        System.out.println("5. Listar todos");
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
            case 1: altaUsuario(); break;
            case 2: bajaUsuario(); break;
            case 3: mostrarUsuario(); break;
            case 4: modificarUsuario(); break;
            case 5: listarTodos(); break;
            case 0: break;
            default: System.out.println(Utils.ansiRed + "Opción no válida." + Utils.ansiReset);
        }
    }

    // --- MÉTODOS DE LÓGICA DE NEGOCIO ---

    private void altaUsuario() {
        System.out.println(Utils.ansiBold + "\n--- ALTA USUARIO ---" + Utils.ansiReset);
        
        // Usamos Utils.letraDni para generar el DNI completo a partir del número
        String dni = leerDniGenerado(); 
        
        if (usuarios.containsKey(dni)) {
            System.out.println(Utils.ansiRed + "Error: Ya existe un usuario con el DNI " + dni + Utils.ansiReset);
            return;
        }

        String nombre = leerNombreValidado();
        int edad = leerEdadValidada();

        usuarios.put(dni, new Usuario(nombre, edad));
        System.out.println(Utils.ansiGreen + "✅ Usuario dado de alta correctamente con DNI: " + dni + Utils.ansiReset);
    }

    private void bajaUsuario() {
        System.out.println(Utils.ansiBold + "\n--- BAJA USUARIO ---" + Utils.ansiReset);
        String dni = leerDniGenerado();

        if (!usuarios.containsKey(dni)) {
            System.out.println(Utils.ansiRed + "Error: No se encuentra ningún usuario con el DNI " + dni + Utils.ansiReset);
            return;
        }

        Usuario eliminado = usuarios.remove(dni);
        System.out.println(Utils.ansiYellow + "🗑️ Usuario eliminado: " + eliminado.getNombre() + Utils.ansiReset);
    }

    private void mostrarUsuario() {
        System.out.println(Utils.ansiBold + "\n--- CONSULTA USUARIO ---" + Utils.ansiReset);
        String dni = leerDniGenerado();
        Usuario u = usuarios.get(dni);

        if (u != null) {
            System.out.println("Datos del usuario:");
            System.out.println(u);
        } else {
            System.out.println(Utils.ansiRed + "Error: Usuario no encontrado." + Utils.ansiReset);
        }
    }

    private void modificarUsuario() {
        System.out.println(Utils.ansiBold + "\n--- MODIFICAR USUARIO ---" + Utils.ansiReset);
        String dni = leerDniGenerado();

        if (!usuarios.containsKey(dni)) {
            System.out.println(Utils.ansiRed + "Error: No existe el usuario con DNI " + dni + Utils.ansiReset);
            return;
        }

        Usuario u = usuarios.get(dni);
        System.out.println("Datos actuales: " + u);
        System.out.println("Introduzca los nuevos datos (o pulse Enter para mantener):");

        // Modificar Nombre
        System.out.print("Nuevo Nombre [" + u.getNombre() + "]: ");
        String nuevoNombre = sc.nextLine().trim();
        if (!nuevoNombre.isEmpty()) {
            // Validamos el nuevo nombre usando Utils
            if (Utils.validateName(nuevoNombre)) { // validateName devuelve true si es INVÁLIDO (según tu Utils)
                System.out.println(Utils.ansiRed + "Error: El nombre contiene caracteres no válidos. No se ha modificado." + Utils.ansiReset);
            } else {
                u.setNombre(nuevoNombre);
            }
        }

        // Modificar Edad
        System.out.print("Nueva Edad [" + u.getEdad() + "]: ");
        String edadStr = sc.nextLine().trim();
        if (!edadStr.isEmpty()) {
            try {
                int nuevaEdad = Integer.parseInt(edadStr);
                if (Utils.validateAge(nuevaEdad)) {
                    u.setEdad(nuevaEdad);
                } else {
                    System.out.println(Utils.ansiYellow + "Aviso: Edad no válida (0-120). No se ha modificado." + Utils.ansiReset);
                }
            } catch (NumberFormatException e) {
                System.out.println(Utils.ansiYellow + "Aviso: Formato de edad incorrecto. No se ha modificado." + Utils.ansiReset);
            }
        }

        System.out.println(Utils.ansiGreen + "✅ Usuario modificado correctamente." + Utils.ansiReset);
    }

    private void listarTodos() {
        System.out.println(Utils.ansiBold + "\n--- LISTADO COMPLETO ---" + Utils.ansiReset);
        if (usuarios.isEmpty()) {
            System.out.println("(No hay usuarios registrados)");
        } else {
            for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
                System.out.println("DNI: " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // --- MÉTODOS AUXILIARES DE ENTRADA Y VALIDACIÓN ---

    // Pide el número de DNI y calcula la letra automáticamente.

    private String leerDniGenerado() {
        int numero = leerEntero("Introduzca número DNI (sin letra): ");
        return Utils.letraDni(numero);
    }

    private String leerNombreValidado() {
        String nombre = "";
        boolean nombreValido = false;
        while (!nombreValido) {
            nombre = leerTexto("Nombre: ");
            // Utils.validateName devuelve true si NO coincide con letras (es decir, si es inválido)
            if (Utils.validateName(nombre)) {
                System.out.println(Utils.ansiRed + "Error: El nombre solo debe contener letras." + Utils.ansiReset);
            } else {
                nombreValido = true;
            }
        }
        return nombre;
    }

    private int leerEdadValidada() {
        int edad = 0;
        boolean edadValida = false;
        while (!edadValida) {
            edad = leerEntero("Edad: ");
            if (Utils.validateAge(edad)) {
                edadValida = true;
            } else {
                System.out.println(Utils.ansiRed + "Error: La edad debe estar entre 0 y 120." + Utils.ansiReset);
            }
        }
        return edad;
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private int leerEntero(String mensaje) {
        int numero = 0;
        boolean numeroValido = false;
        while (!numeroValido) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(sc.nextLine());
                numeroValido = true;
            } catch (NumberFormatException e) {
                System.out.println(Utils.ansiRed + "Error: Debe introducir un número entero." + Utils.ansiReset);
            }
        }
        return numero;
    }
}

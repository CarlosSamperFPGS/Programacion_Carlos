package Tema4.Actividad2;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaCuentas {

    private static ArrayList<Persona> listaPersonas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE CUENTAS BANCARIAS ---");
            System.out.println("1. Instanciar Persona");
            System.out.println("2. Instanciar Cuenta y asociarla a una Persona");
            System.out.println("3. Mostrar datos de una Persona");
            System.out.println("4. Recibir nómina (Abono)");
            System.out.println("5. Pagar recibo (Cargo)");
            System.out.println("6. Realizar transferencia");
            System.out.println("7. Imprimir personas morosas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    crearPersona();
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    mostrarPersona();
                    break;
                case 4:
                    recibirNomina();
                    break;
                case 5:
                    pagarRecibo();
                    break;
                case 6:
                    realizarTransferencia();
                    break;
                case 7:
                    imprimirMorosos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void crearPersona() {
        System.out.print("Introduce el DNI de la persona: ");
        String dni = sc.nextLine();
        
        if (buscarPersona(dni) != null) {
            System.out.println("Error: Ya existe una persona con ese DNI.");
        } else {
            listaPersonas.add(new Persona(dni));
            System.out.println("Persona creada correctamente.");
        }
    }

    private static void crearCuenta() {
        Persona p = solicitarPersona();
        if (p != null) {
            System.out.print("Introduce el número de cuenta: ");
            String numCuenta = sc.nextLine();
            
            // Verificar si la cuenta ya existe en esa persona (opcional, pero recomendable)
            if (p.getCuentaPorNumero(numCuenta) != null) {
                System.out.println("Error: Esa persona ya tiene esa cuenta.");
                //boolean
                return;
            }

            Cuenta c = new Cuenta(numCuenta);
            if (p.agregarCuenta(c)) {
                System.out.println("Cuenta añadida correctamente a la persona con DNI " + p.getDni());
            }
        }
    }

    private static void mostrarPersona() {
        Persona p = solicitarPersona();
        if (p != null) {
            System.out.println(p);
        }
    }

    private static void recibirNomina() {
        Persona p = solicitarPersona();
        if (p != null) {
            Cuenta c = solicitarCuenta(p);
            if (c != null) {
                System.out.print("Introduce la cantidad de la nómina: ");
                double cantidad = Double.parseDouble(sc.nextLine());
                c.recibirAbono(cantidad);
            }
        }
    }

    private static void pagarRecibo() {
        Persona p = solicitarPersona();
        if (p != null) {
            Cuenta c = solicitarCuenta(p);
            if (c != null) {
                System.out.print("Introduce la cantidad del recibo: ");
                double cantidad = Double.parseDouble(sc.nextLine());
                c.pagarRecibo(cantidad);
            }
        }
    }

    private static void realizarTransferencia() {
        System.out.println("--- CUENTA ORIGEN ---");
        Persona pOrigen = solicitarPersona();
        if (pOrigen == null) return;
        Cuenta cOrigen = solicitarCuenta(pOrigen);
        if (cOrigen == null) return;

        System.out.println("--- CUENTA DESTINO ---");
        Persona pDestino = solicitarPersona();
        if (pDestino == null) return;
        Cuenta cDestino = solicitarCuenta(pDestino);
        if (cDestino == null) return;

        System.out.print("Introduce la cantidad a transferir: ");
        double cantidad = Double.parseDouble(sc.nextLine());

        // Comprobar saldo suficiente en origen
        // Asumiremos que se permite descubierto ya que existen los morosos
        
        cOrigen.pagarRecibo(cantidad); // Retira dinero
        cDestino.recibirAbono(cantidad); // Ingresa dinero
        System.out.println("Transferencia realizada con éxito.");
    }

    private static void imprimirMorosos() {
        System.out.println("--- LISTADO DE PERSONAS MOROSAS ---");
        boolean hayMorosos = false;
        for (Persona p : listaPersonas) {
            if (p.esMorosa()) {
                System.out.println(p);
                hayMorosos = true;
            }
        }
        if (!hayMorosos) {
            System.out.println("No hay personas morosas registradas.");
        }
    }

    // Métodos auxiliares
    private static Persona buscarPersona(String dni) {
        for (Persona p : listaPersonas) {
            if (p.getDni().equalsIgnoreCase(dni)) {
                return p;
            }
        }
        return null;
    }

    private static Persona solicitarPersona() {
        System.out.print("Introduce el DNI de la persona: ");
        String dni = sc.nextLine();
        Persona p = buscarPersona(dni);
        if (p == null) {
            System.out.println("Error: No se encuentra ninguna persona con ese DNI.");
        }
        return p;
    }

    private static Cuenta solicitarCuenta(Persona p) {
        System.out.print("Introduce el número de cuenta: ");
        String numCuenta = sc.nextLine();
        Cuenta c = p.getCuentaPorNumero(numCuenta);
        if (c == null) {
            System.out.println("Error: Esa persona no tiene asociada esa cuenta.");
        }
        return c;
    }
}

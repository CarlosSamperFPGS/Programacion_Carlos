package Tema4.Actividad2;

public class Persona {

    // Atributos
    private String dni;
    private Cuenta[] cuentas;
    private int numCuentasActuales; // Contador para saber cuántas cuentas tiene


    // Constructor
    public Persona(String dni) {
        this.dni = dni;
        this.cuentas = new Cuenta[3]; // Máximo 3 cuentas
        this.numCuentasActuales = 0;
    }


    // Métodos
    public boolean agregarCuenta(Cuenta nuevaCuenta) {
        if (numCuentasActuales < 3) {
            cuentas[numCuentasActuales] = nuevaCuenta;
            numCuentasActuales++;
            return true;
        } else {
            System.out.println("Error: Esta persona ya tiene el máximo de 3 cuentas.");
            return false;
        }
    }

    public boolean esMorosa() {
        for (int i = 0; i < numCuentasActuales; i++) {
            if (cuentas[i].getSaldo() < 0) {
                return true;
            }
        }
        return false;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DNI: ").append(dni).append("\n");
        sb.append("Cuentas:\n");
        if (numCuentasActuales == 0) {
            sb.append("  - Sin cuentas asociadas.\n");
        } else {
            for (int i = 0; i < numCuentasActuales; i++) {
                sb.append("  - ").append(cuentas[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public Cuenta getCuentaPorNumero(String numeroCuenta) {
        for (int i = 0; i < numCuentasActuales; i++) {
            if (cuentas[i].getNumeroCuenta().equals(numeroCuenta)) {
                return cuentas[i];
            }
        }
        return null;
    }

    // Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    public int getNumCuentasActuales() {
        return numCuentasActuales;
    }

    public void setNumCuentasActuales(int numCuentasActuales) {
        this.numCuentasActuales = numCuentasActuales;
    }
}

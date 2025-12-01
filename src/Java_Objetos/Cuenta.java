package Java_Objetos;

//---------------------------------------------------------------------------------
// Objeto java Cuenta bancaria
//---------------------------------------------------------------------------------


public class Cuenta {

    // Atributos
    String titular;
    private double saldo;



    // Constructor
    public Cuenta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }



    // Métodos
    public void ingresarDinero(double cantidad) {
        if (cantidad >= 0) {
            this.saldo += cantidad;
        } else  {
            System.out.println("ERROR: No se puede ingresar una cantidad negativa");
        }
    }

    public void retirarDinero(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("ERROR: No se puede retirar una cantidad mayor al saldo");
        }

    }

    public void mostrarSaldo() {
        System.out.println("Bienvenido a tu cuenta " + titular + "!");
        System.out.println("Tu saldo actual es de " + saldo + " euros");
    }

    // Métodos Getter
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void mostrarInfo() {
        System.out.println("Bienvenido a tu cuenta " + titular + "!");
        System.out.println("Tu saldo actual es de " + saldo + " euros");
    }
}

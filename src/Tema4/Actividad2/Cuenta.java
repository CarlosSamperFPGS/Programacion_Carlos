package Tema4.Actividad2;

public class Cuenta {

    // Atributos
    private final String numeroCuenta;
    private double saldo;


    // Constructor
    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0; // Saldo inicial 0
    }

    //cons vacio


    // Métodos
    public void recibirAbono(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            System.out.println("Abono de " + cantidad + "€ realizado. Nuevo saldo: " + this.saldo + "€");
        } else {
            System.out.println("La cantidad a abonar debe ser positiva.");
        }
    }

    public void pagarRecibo(double cantidad) {
        if (cantidad > 0) {
            this.saldo -= cantidad;
            System.out.println("Recibo de " + cantidad + "€ pagado. Nuevo saldo: " + this.saldo + "€");
        } else {
            System.out.println("La cantidad a pagar debe ser positiva.");
        }
    }

    @Override
    public String toString() {
        return "Cuenta{" + "Num='" + numeroCuenta + '\'' + ", Saldo=" + saldo + "€}";
    }

    // Getters y Setters

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

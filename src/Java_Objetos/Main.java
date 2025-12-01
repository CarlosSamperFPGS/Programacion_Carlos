package Java_Objetos;

public class Main {
    public static void main(String[] args) {

        Cuenta[] banco = new Cuenta[3];

        banco[0] = new Cuenta("Carlos", 1000);
        banco[1] = new Cuenta("Ana", 2000);
        banco[2] = new Cuenta("Marga", 3000);

        System.out.println("--- SALDOS INICIALES ---");
        for (int i = 0; i < banco.length; i++) {
            banco[i].mostrarSaldo();
        }
    }
}

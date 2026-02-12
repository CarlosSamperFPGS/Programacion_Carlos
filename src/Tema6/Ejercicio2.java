package Tema6;

import Tema4.Actividad1.Utils;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print(Utils.ansiCyan + "Introduce el primer número (numerador): " + Utils.ansiReset);
            int num1 = sc.nextInt();

            System.out.print(Utils.ansiCyan + "Introduce el segundo número (denominador): " + Utils.ansiReset);
            int num2 = sc.nextInt();

            int resultado = num1 / num2;
            System.out.println(Utils.ansiGreen + "Resultado de la división: " + resultado + Utils.ansiReset);

        } catch (InputMismatchException e) {
            System.out.println(Utils.ansiRed + "Error: Debes introducir un número entero válido." + Utils.ansiReset);
        } catch (ArithmeticException e) {
            System.out.println(Utils.ansiRed + "Error: No se puede dividir por cero." + Utils.ansiReset);
        } finally {
            sc.close();
        }
    }
}

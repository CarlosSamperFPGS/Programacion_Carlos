package Tema6;

import Tema4.Actividad1.Utils;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print(Utils.ansiCyan + "Introduce un valor entero: " + Utils.ansiReset);
            int num = sc.nextInt();
            System.out.println(Utils.ansiGreen + "Valor introducido: " + num + Utils.ansiReset);
        } catch (InputMismatchException e) {
            System.out.println(Utils.ansiRed + "Valor introducido incorrecto" + Utils.ansiReset);
        }
    }
}

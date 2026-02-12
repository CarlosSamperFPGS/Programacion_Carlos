package Tema4.Actividad1;

public class Utils {

    public static final String ansiReset = "\u001B[0m";
    public static String ansiRed = "\u001B[31m";
    public static String ansiGreen = "\u001B[32m";
    public static String ansiYellow = "\u001B[33m";
    public static String ansiBlue = "\u001B[34m";
    public static String ansiPurple = "\u001B[35m";
    public static String ansiCyan = "\u001B[36m";
    public static String ansiBold = "\u001B[1m";

    public static boolean validateDNI(String dni) {
        return dni.matches("\\d{8}[A-Z]");
    }

    public static boolean validateName(String name) {
        return !name.matches("[a-zA-Z]+");
    }

    public static boolean validateAge(int age) {
        return age >= 0 && age <= 120;
    }


    public static String letraDni(int dni) {
    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    char letra = letras.charAt(dni % letras.length());
    return "" + dni + letra;
}

}

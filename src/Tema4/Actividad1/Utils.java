package Tema4.Actividad1;

public class Utils {
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

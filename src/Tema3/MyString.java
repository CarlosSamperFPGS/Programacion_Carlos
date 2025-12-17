package Tema3;


// Classe con funciones y procedimientos relacionados con Strings solo usando String (No usar StringBuilder)

public class MyString {

    // Función que recibe una cadena y devuelve esa cadena invertida y en mayúsculas
    public static String invertirYMayusculas(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }
        String invertido = "";
        int longitud = texto.length();
        for (int i = longitud - 1; i >= 0; i--) {
            char letra = texto.charAt(i);
            invertido += Character.toUpperCase(letra);
        }
        return invertido;
    }


    // Función que recibe una cadena y devuelve el número de vocales
    public static int contarVocales(String cadena) {
        int contador = 0;
        String vocales = "aeiouAEIOU";
        for (int i = 0; i < cadena.length(); i++) {
            if (vocales.indexOf(cadena.charAt(i)) != -1) {
                contador++;
            }
        }
        return contador;
    }


    // Función que recibe una cadena y devuelve la palabra con mayor longitud
    public static String palabraMasLarga(String cadena) {
        String[] palabras = cadena.split("\\s+");
        String palabraMasLarga = "";
        for (String palabra : palabras) {
            if (palabra.length() > palabraMasLarga.length()) {
                palabraMasLarga = palabra;
            }
        }
        return palabraMasLarga;
    }

    // Función que recibe 2 cadenas y devuelve el número de veces que la segunda cadena está incluida en la primera
    public static int vecesQueAparece(String cadena1, String cadena2) {
        int contador = 0;
        int indice = 0;
        while ((indice = cadena1.indexOf(cadena2, indice)) != -1) {
            contador++;
            indice += cadena2.length();
        }
        return contador;
    }

    // Función que recibe una cadena y devuelve el número de palabras que contiene
    public static int numeroPalabras(String cadena) {
        String[] palabras = cadena.split("\\s+");
        return palabras.length;
    }


    // Función que recibe un número de teléfono, por ejemplo "34555332211" y lo formatee así (+34)-555-332211.
    public static String formatearTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            return telefono;
        }

        String telefonoFormateado = "";
        if (telefono.length() == 10) {
            telefonoFormateado = "(+" + telefono.substring(0, 1) + ")-" + telefono.substring(2, 4) + "-" + telefono.substring(5);
        }
        return telefonoFormateado;
    }

    // Función que recibe número de teléfono, por ejemplo "34111223344" y lo formatee así (+34)-111-223344 con String.format
    public static String formatearTelefono2(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            return telefono;
        }
        return String.format("(+%s)-%s-%s", telefono.substring(0, 1), telefono.substring(2, 4), telefono.substring(5));
    }

    // Procedimiento que reciba una cadena y muestre por pantalla el histograma de frecuencias de las vocales (las veces que se repiten)
    public static void histogramaVocales(String cadena) {
        int contA = 0;
        int contE = 0;
        int contI = 0;
        int contO = 0;
        int contU = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            letra = Character.toLowerCase(letra);
            switch (letra) {
                case 'a':
                    contA++;
                    break;
                case 'e':
                    contE++;
                    break;
                case 'i':
                    contI++;
                    break;
                case 'o':
                    contO++;
                    break;
                case 'u':
                    contU++;
                    break;
            }
            System.out.println("A: " + contA + "\nE: " + contE + "\nI: " + contI + "\nO: " + contO + "\nU: " + contU);
        }

    }




















}

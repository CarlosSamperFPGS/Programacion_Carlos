package Tema3;

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

public class MyArray {

    // Procedimiento que imprime un array
    public static void imprimirArray(int[] array) {
        if (array == null) {
            System.out.println("El array es nulo.");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Función que devuelve el máximo de un array
    public static int maximo(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Función que devuelve el mínimo de un array
    public static int minimo(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Función que devuelve la media de un array
    public static double media(int[] array) {
        double suma = 0;
        for (int valor : array) {
            suma += valor;
        }
        return suma / array.length;
    }

    // Función que dice si un valor existe en el array
    public static boolean existe(int[] array, int elemento) {
        for (int valor : array) {
            if (valor == elemento) {
                return true;
            }
        }
        return false;
    }

    // Función que hace suma de 2 vectores
    public static int[] sumaVectores(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return null; // No se pueden sumar si no tienen la misma longitud
        }
        int[] resultado = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            resultado[i] = array1[i] + array2[i];
        }
        return resultado;
    }

    // Función que hace resta de 2 vectores
    public static int[] restaVectores(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return null;
        }
        int[] resultado = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            resultado[i] = array1[i] - array2[i];
        }
        return resultado;
    }

    // Función que hace producto escalar de 2 vectores
    public static int productoEscalar(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return 0; // O lanzar una excepción, según el diseño
        }
        int producto = 0;
        for (int i = 0; i < array1.length; i++) {
            producto += array1[i] * array2[i];
        }
        return producto;
    }

    // Función que invierte el orden de un array (devuelve un nuevo array)
    public static int[] invertirArrayFuncion(int[] array) {
        int[] invertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = array[array.length - 1 - i];
        }
        return invertido;
    }

    // Procedimiento que invierte el orden de un array (no devuelve nada)
    public static void invertirArrayProcedimiento(int[] array) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio < fin) {
            int temp = array[inicio];
            array[inicio] = array[fin];
            array[fin] = temp;
            inicio++;
            fin--;
        }
    }

    // Función que comprueba si un array es capicúa
    public static boolean esCapicua(int[] array) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio < fin) {
            if (array[inicio] != array[fin]) {
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
    }
}
package Tema3;

//-------------------------------------------------------------------------------
//

public class MyMath {

    // Función para calcular el perímetro de un círculo
    public static double circlePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    // Función para calcular el área de un círculo
    public static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    // Función para calcular el perímetro de un cuadrado
    public static double squarePerimeter(double side) {
        return 4 * side;
    }

    // Función para calcular el área de un cuadrado
    public static double squareArea(double side) {
        return Math.pow(side, 2);
    }

    // Función para calcular el perímetro de un rectángulo
    public static double rectanglePerimeter(double length, double width) {
        return 2 * (length + width);
    }

    // Función para calcular el área de un rectángulo
    public static double rectangleArea(double length, double width) {
        return length * width;
    }
}
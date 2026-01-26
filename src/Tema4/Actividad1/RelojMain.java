package Tema4.Actividad1;

public class RelojMain {
    public static void main(String[] args) {
        Reloj reloj1 = new Reloj();
        reloj1.mostrarHora();

        Reloj reloj2 = new Reloj(13, 30, 45, true);
        reloj2.mostrarHora();

        System.out.println("Reloj 2: " + reloj2); // toString se llama implícitamente

        reloj1.setHoras(28);
        reloj1.setMinutos(59);
        reloj1.setSegundos(59);
        System.out.println("Reloj 1 actualizado: " + reloj1);

        System.out.println("Horas del Reloj 2: " + reloj2.getHoras());
    }

}

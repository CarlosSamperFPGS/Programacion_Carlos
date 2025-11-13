package Tema3;

import java.util.Scanner;

public class Ejercicio4 {

    // 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

    // Procedimiento para mostrar el menú
    public static void showMenu(){
        System.out.println("Bienvenido al conversor de divisas de Hazard");
        System.out.println("1. Convertir euros a dólares");
        System.out.println("2. Convertir dólares a euros");
        System.out.println("3. Salir");
        System.out.println("Elige una opción");
    }
    // Funciones para convertir euros a dólares y dólares a euros
    public static double euro2dollar(double money){
        return  money * 1.16;
    }
    public static double dollar2euro(double money){
        return  money * 0.84;
    }
    public static void main(String[] args) {
        showMenu();
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        double money;

        switch (option) {
            case 1:
                System.out.println("Introduce la cantidad de euros a convertir");
                money = sc.nextInt();
                System.out.println(money + " euros son " + euro2dollar(money) + " dólares");
                break;
            case 2:
                System.out.println("Introduce la cantidad de dólares a convertir");
                money = sc.nextInt();
                System.out.println(money + " dólares son " + dollar2euro(money) + " euros");
                break;
            case 3:
                System.out.println("Gracias por usar el conversor de divisas de Hazard");
        }
    }
}

//                         __    _
//                    _wr""        "-q__
//                 _dP                 9m_
//               _#P                     9#_
//              d#@                       9#m
//             d##                         ###
//            J###                         ###L
//            {###K                       J###K
//            ]####K      ___aaa___      J####F
//        __gmM######_  w#P""   ""9#m  _d#####Mmw__
//     _g##############mZ_         __g##############m_
//   _d####M@PPPP@@M#######Mmp gm#########@@PPP9@M####m_
//  a###""          ,Z"#####@" '######"\g          ""M##m
// J#@"             0L  "*##     ##@"  J#              *#K
// #"               `#    "_gmwgm_~    dF               `#_
//7F                 "#_   ]#####F   _dK                 JE
//]                    *m__ ##### __g@"                   F
//                       "PJ#####LP"
// `                       0######_                      '
//                       _0########_
//     .               _d#####^#####m__              ,
//      "*w_________am#####P"   ~9#####mw_________w*"
//          ""9@#####@M""           ""P@#####@M""
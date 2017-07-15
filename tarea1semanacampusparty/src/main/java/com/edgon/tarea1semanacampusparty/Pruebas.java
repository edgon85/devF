package com.edgon.tarea1semanacampusparty;


import java.util.Random;

public class Pruebas {

    public static void main(String[] args) {

        //String password = generatePassword(9);
        //esFuerte(generatePassword(9));
        EncuestaEstudiantes();


    }


    static void esFuerte(String password) {

        boolean fuerte = false;
        int numero = 0;
        int mayus = 0;
        int minus = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                numero++;
            }

            if (Character.isUpperCase(password.charAt(i))) {
                mayus++;
            }

            if (Character.isLowerCase(password.charAt(i))) {
                minus++;
            }
        }

        if ((mayus>=2) && (minus>=1) && (numero>=5)){
            fuerte = true;
        }else{
            fuerte = false;
        }
        System.out.println("Mayusculas: " + mayus + " Minusculas: " + minus + " numeros: " + numero);
        System.out.println(""+fuerte);
    }


    static String generatePassword(int cantidad) {
        char[] caracteres;
        caracteres = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String pass = "";
        try {
            int repet = cantidad;

            for (int i = 0; i < repet; i++) {
                pass += caracteres[new Random().nextInt(62)];
            }
            System.out.println("La Contraseña es: " + pass);

        } catch (NumberFormatException ex) {
            ex.printStackTrace(System.out);
            System.out.println("La Contraseña de caracteres es invalida");
        }

        return pass;
    }


    static void EncuestaEstudiantes(){
        int[] respuestas = {1,2,5,4,3,5,2,1,3,3,1,4,3,3,3,2,3,3,2,14};
        int frecuencia[] = new int[6];

        for (int respuesta=0;respuesta<respuestas.length; respuesta++){
            try {
                ++frecuencia[respuestas[respuesta]];
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e);
                System.out.printf("respuestas[%d] = %d\n\n",respuesta,respuestas[respuesta]);
            }
        }

        System.out.printf(" %s %10s\n","Clificacion","Frecuencia");


        for (int calificacion = 1; calificacion < frecuencia.length; calificacion++) {
            System.out.printf("%6d %10d\n", calificacion, frecuencia[calificacion]);
        }
    }
}
package com.edgon.tarea1semanacampusparty;


import java.util.Random;

public class Password {
    private String password;
    private int longitude = 9;


    public Password() {
    }

    public Password(int longitude) {
        this.longitude = longitude;
        this.password = generatePassword(longitude);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }


    public boolean esFuerte(String password){
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

        return fuerte;
    }

    public String generatePassword(int longitude) {

        char[] caracteres;
        caracteres = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String pass = "";
        try {
            int repet = longitude;

            for (int i = 0; i < repet; i++) {
                pass += caracteres[new Random().nextInt(62)];
            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace(System.out);
        }
        return pass;
    }

}

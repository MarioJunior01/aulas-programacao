package exerciciosStrings;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner lerTeclado = new Scanner(System.in);

        System.out.println("digite uma palavra ");

        String palavra = new  String (lerTeclado.nextLine());
        String resultado = "";

        char[] caracteresPalavras = palavra.toCharArray();

        for (int i = 0; i < caracteresPalavras.length; i++) {

            resultado += palavra.charAt(i) + "" + palavra.charAt(i);
        }
        
        System.out.println(resultado);


        lerTeclado.close();
    }
}
package exerciciosStrings;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner lerTeclado = new Scanner(System.in);
        
        System.out.println("digite uma palavra ou uma frase ");

        String palavraFrase = new String(lerTeclado.nextLine());

        char[] caracteres = palavraFrase.toCharArray();

        for (int i = 0; i < caracteres.length;i++) {
            
            palavraFrase.indexOf('l');
            palavraFrase.indexOf('a');
            palavraFrase.lastIndexOf('l');
            palavraFrase.lastIndexOf('a');

            System.out.println("a silaba la aparece :" + i);
        
        }

        




           

    }

}

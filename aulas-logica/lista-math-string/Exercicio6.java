import console.Console;

public class Exercicio6 {
    public static void main(String[] args) {

        Console lerTeclado = new Console();
        String palvraFrase = lerTeclado.readLine("Digite uma palavra ou uma frase");
        int caracter = palvraFrase.indexOf('.');

        if (caracter!=0) {
            System.out.println(" o . aparece na palavra");
            
        }
        else{
            System.out.println("o . não aparece ");
        }

       
        

       

      
    }
}
import console.Console;

public class Exercicio2 {
    public static void main(String[] args) {
        Console lerTeclado = new Console();

        String palavraFrase = lerTeclado.readLine("Digite uma palavra ou uma frase");

        int tamanho = palavraFrase.length();
        String la = palavraFrase.replace("la", " ");
        
        int quantiadeLa = la.length();
        System.out.println(quantiadeLa);
        int totalLa = tamanho-quantiadeLa;

        System.out.println("A quantidade de la é de "+totalLa);

        


        
      
       
            

        }

    }

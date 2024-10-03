import console.Console;

public class Exercicio4 {
    public static void main(String[] args) {

        Console lerTeclado = new Console();

        String palavraFrase = lerTeclado.readLine("Digite uma palavra ou uma frase");

        int tamanho = palavraFrase.length();
        String a = palavraFrase.replace("a", "");
        
        int quantiadeA = a.length();
        System.out.println(quantiadeA);
        int totalLa = tamanho-quantiadeA;

        System.out.println("A quantidade de la é de "+totalLa);

        

        
    }
    
}

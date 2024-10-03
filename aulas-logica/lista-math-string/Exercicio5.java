import console.Console;

public class Exercicio5 {
    public static void main(String[] args) {

        Console lerTeclado = new Console();
        
        String palavraFrase = lerTeclado.readLine("Digite uma palavra ou uma frase");

        System.out.println(palavraFrase.toUpperCase().trim());

    }

}

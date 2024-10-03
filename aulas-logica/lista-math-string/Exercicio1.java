import console.Console;


public class Exercicio1 {
    public static void main(String[] args) {
        Console lerTeclado = new Console();

        String palavra = lerTeclado.readLine("Digite uma palavra");

        String resultado = "";

        char[] caracteresPalavras = palavra.toCharArray();

        for (int i = 0; i < caracteresPalavras.length; i++) {

            resultado += palavra.charAt(i) + "" + palavra.charAt(i);
        }
        
        System.out.println(resultado);


       
    }
}



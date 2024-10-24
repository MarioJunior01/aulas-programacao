
import console.Console;

public class Exercicio1 {

    public static void main(String[] args) {

        Console lerTeclado = new Console();

        int[] numeros = new int[12];
        int x = lerTeclado.readInt("Digite o  numero para x");
        int y = lerTeclado.readInt("Digite o numero para y");
        int numero = 0;
        int total;
        for (int i = 0; i < numeros.length; i++) {
            numero = i;
        }
        if (x == numero) {
            x = numero;
        } else if (y == numero) {
            y = numero;

        }
        total = x - y;
        System.out.println(total);

    }
}
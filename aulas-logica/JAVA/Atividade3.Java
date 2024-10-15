import javax.swing.*;

public class Numeros {
    static int Numero;

    public static  void setNumero ( ){
    Numero=Integer.parseInt(JOptionPane.showInputDialog(null,"digite um numero para ver se ele é impar ou par"));
    }
    public static boolean isPar(int n) {
        return n % 2 == 0;


    }
    static void mensagem(){
        if (isPar(Numero)){
        JOptionPane.showMessageDialog(null,"Seu numero é par");

        }
        else {
            JOptionPane.showMessageDialog(null,"seu numero é impar");
        }
    }




}

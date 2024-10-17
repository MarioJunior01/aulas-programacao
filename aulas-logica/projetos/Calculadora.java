import javax.swing.*;
public class Calculadora {
    public static double Valor1;
    public  static  double Valor2;
    public static String escolhas;
 static void entradas(String escolha){
     escolha=JOptionPane.showInputDialog(null,"BEM-VINDO A CALCULAODRA \n"+"digite 1 para somar \n"+ "digite 2 para subtração\n"+ " digite 3 para multiplicação\n"+ "digite 4 divisão\n"+ "digite 5 para sair");
 }



    static void setValor1(double valor1) {
        Valor1 = valor1;
        JOptionPane.showInputDialog(null,"digite o primeiro numero para realizar a operação");
    }
    static void setValor2(double valor2) {
        Valor2= valor2;
        JOptionPane.showInputDialog(null,"digite o segundo  numero para realizar a operação");
    }

    public double getValor2() {
        return Valor2;
    }
    public double getValor1() {
        return Valor1;
    }
    public static void Soma(Double valor1,Double valor2 , Double resulado){
     valor1=Valor1;
     valor2=Valor2;
      resulado =valor1+valor2;
      JOptionPane.showInputDialog(null,"o resultado da  soma é:"+resulado);

    }
    public static void Subtracao(Double valor1,Double valor2 , Double resulado){
        valor1=Valor1;
        valor2=Valor2;
        resulado = valor1-valor2;
        JOptionPane.showInputDialog(null,"o resultado da  subtração é:"+resulado);



    }public static void multiplicacao(Double valor1,Double valor2 , Double resulado) {
        valor1 = Valor1;
        valor2 = Valor2;
        resulado = valor1 * valor2;
        JOptionPane.showInputDialog(null, "o resultado da  multiplicação  é:" + resulado);


    }
    public static void divisao(Double valor1,Double valor2 , Double resulado){
        valor1=Valor1;
        valor2=Valor2;
        resulado = valor1/valor2;
        JOptionPane.showInputDialog(null,"o resultado da  divisão  é:"+resulado);
}}

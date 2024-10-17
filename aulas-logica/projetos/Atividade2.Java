import javax.swing.JOptionPane;

public class Clasifcar {
    static double nota;


    static void setNota() {
        nota = Double.parseDouble(JOptionPane.showInputDialog(null, "digite a nota do aluno"));


    }

    static Double getNota() {
        return nota;
    }

    public static void classificarNota() {
        if (getNota() >= 9) {
            JOptionPane.showMessageDialog(null, "o aluno tirou A");
        } else if (getNota()<9 &&getNota()>=8) {
            JOptionPane.showMessageDialog(null,"O aluno tirou B");




        } else if (getNota()>=6 && getNota()<=7) {
            JOptionPane.showMessageDialog(null,"O aluno tirou C");


        }
else{
            JOptionPane.showMessageDialog(null,"O aluno tirou D");

        }
    }
}

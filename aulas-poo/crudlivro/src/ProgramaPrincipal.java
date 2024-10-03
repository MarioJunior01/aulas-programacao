
import livro.GerenciarLivro;
import livro.Livro;

import java.util.List;
import java.util.Scanner;

public class ProgramaPrincipal {


    private final int CADASTRAR_LIVRO = 1;
    private final int REMOVER_LIVRO = 2;
    private final int LISTAR_LIVRO = 3;
    private final int EDITAR_LIVRO = 4;
    private final int SAIR = 9;
    private Scanner lerTeclado;
    private GerenciarLivro gerLivro;


    public ProgramaPrincipal() {
        lerTeclado = new Scanner(System.in);
        gerLivro = new GerenciarLivro();

    }

    public static void main(String[] args) {
        new ProgramaPrincipal().escolha();

    }

    public void mostrarMenu() {
        System.out.println("--CRUD---");
        System.out.println("1- CADASTRAR LIVRO");
        System.out.println("2- REMOVER LIVRO");
        System.out.println("3- LISTAR LIVRO");
        System.out.println("4- EDITAR LIVRO");
        System.out.println("9- SAIR");
    }

    public void escolha() {

        int escolha = 0;

        do {
            mostrarMenu();
            escolha = lerTeclado.nextInt();

            if (escolha == CADASTRAR_LIVRO) {
                cadastrarLivro();

            } else if (escolha == REMOVER_LIVRO) {
                removerLivro();

            } else if (escolha == LISTAR_LIVRO) {
                listarLivro();
            } else if (escolha == EDITAR_LIVRO) {
                editarLivro();
            }

        } while (escolha != SAIR);


    }

    public void cadastrarLivro() {

        System.out.println("Digite o nome do livro");
        String nomeLivro = lerTeclado.nextLine();
        System.out.println("Digite o nome do autor");
        String nomeAutor = lerTeclado.nextLine();
        System.out.println("Digite o encervo do livro ");
        int encervoLivro = lerTeclado.nextInt();
        System.out.println("Digite a categoria do livro");
        String categoriaLivro = lerTeclado.nextLine();

        Livro livro = new Livro();

        livro.setNomeLivro(nomeLivro);
        livro.setNomeAutor(nomeAutor);
        livro.setCategoriaLivro(categoriaLivro);
        livro.setEncervoLivro(encervoLivro);

        gerLivro.cadastrarLivro(livro);

        System.out.println("Livro cadastrado");


    }

    public void removerLivro() {
        System.out.println("Digite o id do livro ");
        int id = lerTeclado.nextInt();
        gerLivro.remover(id);
        System.out.println("Livro removido ");

    }

    public void listarLivro() {
        List<Livro> lista = gerLivro.listarLivros();

        for (Livro livro : lista) {

            System.out.println("\nID: " + livro.getIdLivro());

            System.out.println("Nome: " + livro.getNomeLivro());
        }

    }

    public void editarLivro() {
        System.out.println("Digite o id do livro");
        int id = lerTeclado.nextInt();
        Livro livro = gerLivro.findById(id);
        System.out.println("Digite um novo nome");
        String novoNome = lerTeclado.nextLine();

        livro.setNomeLivro(novoNome);

        gerLivro.editar(livro);
        System.out.println("Livro editado ");


    }

}

package livro;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GerenciarLivro {

    private AtomicInteger geradorId;
    private Hashtable<Integer, Livro> livros;


    public GerenciarLivro() {
        geradorId = new AtomicInteger();
        livros = new Hashtable<Integer, Livro>();

    }

    public void cadastrarLivro(Livro livro) {
        int id = geradorId.incrementAndGet();
        livro.setIdLivro(id);
        livros.put(livro.getIdLivro(), livro);


    }

    public List listarLivros() {
        List<Livro> listaLivros = new ArrayList<>(livros.values());
        return listaLivros;


    }

    public void remover(int id) {
        livros.remove(id);

    }

    public Livro findById(int id) {
        return livros.get(id);

    }
    public  void editar(Livro livro){
        livros.replace(livro.getIdLivro(),livro);

    }


}

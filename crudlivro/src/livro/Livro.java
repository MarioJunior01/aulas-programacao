package livro;

public class Livro {
    private String nomeLivro;
    private String nomeAutor;
    private int idLivro;
    private int encervoLivro;
    private String categoriaLivro;

    public String getNomeLivro() {
        return nomeLivro;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public String getCategoriaLivro() {
        return categoriaLivro;
    }

    public void setCategoriaLivro(String categoriaLivro) {
        this.categoriaLivro = categoriaLivro;
    }

    public int getEncervoLivro() {
        return encervoLivro;
    }

    public void setEncervoLivro(int encervoLivro) {
        this.encervoLivro = encervoLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }



}

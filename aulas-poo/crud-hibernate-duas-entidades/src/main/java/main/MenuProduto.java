package main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import console.Console;
import produto.GerenciarProduto;
import produto.Produto;

public class MenuProduto {

	private Console console;
	private final static int CADASTRAR = 1;
	private final static int EDITAR = 2;
	private final static int LISTAR = 3;
	private final static int REMOVER = 4;
	private final static int SAIR = 9;
	private GerenciarProduto gerProduto;
	
	
	public MenuProduto() {
		console = new Console();
		gerProduto = new GerenciarProduto();
	}
	
	public void show() {
		int opcao = 0;

		do {
			mostrarMenu();

			opcao = console.readInt();

			if (opcao == CADASTRAR) {
				System.out.println("Cadastrar produto");
				cadastrar();
			} else if (opcao == EDITAR) {
				System.out.println("Editar produto");
				editar();
			} else if (opcao == LISTAR) {
				System.out.println("Listar produtos");
				listar();
			} else if (opcao == REMOVER) {
				System.out.println("Remover produto");
				remover();
			}

		} while (opcao != SAIR);
	}
	
	private void editar() {

		int id = console.readInt("Digite o ID para editar: ");
		Produto produto = gerProduto.findById(id);
		
		lerDadosProduto(produto);
		
		gerProduto.update(produto);
		
		System.out.println("Produto atualizado com sucesso");
	}

	private void lerDadosProduto(Produto produto) {
		String nome = console.readLine("Digite o nome: ");
		String marca = console.readLine("Digite a marca: ");
		BigDecimal preco = console.readBigDecimal("Digite o preço: ");
		LocalDate dataFabricacao = console.readLocalDate("Data de fabricação: ");
		
		produto.setNome(nome);
		produto.setMarca(marca);
		produto.setDataFabricacao(dataFabricacao);
		produto.setPreco(preco);
	}
	
	private void remover() {
		int idRemover = console.readInt("Digite o ID para remover: ");
		
		Produto produto = gerProduto.findById(idRemover);
		if ( produto == null ) {
			System.out.println("ID informado não existe");
		}
		else {
			System.out.println("ID: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			
			System.out.println("Confirma a exclusão: 0 - sim, 1 - não");
			int opcao = console.readInt();
			
			if ( opcao == 0 ) {
				gerProduto.remove(idRemover);
				System.out.println("OK, removido com sucesso");
			}
			else {
				System.out.println("Cancelar");
			}
		}
	}
	
	private void listar() {
		List<Produto> lista = gerProduto.list();
		for (Produto produto : lista) {
			System.out.println("\nID: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Marca: " + produto.getMarca());
			System.out.println("Preço: " + produto.getPreco());
		}
		
	}

	private void cadastrar() {
		Produto produto = new Produto();
		
		lerDadosProduto(produto);
		
		gerProduto.create(produto);
		System.out.println("Produto cadastro com sucesso");
	}
	
	private void mostrarMenu() {
		System.out.println("\n------ GERENCIAMENTO DE PRODUTOS ------\n");
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Editar produto");
		System.out.println("3 - Listar produtos");
		System.out.println("4 - Remover produto");
		System.out.println("9 - Voltar");
	}
	
}

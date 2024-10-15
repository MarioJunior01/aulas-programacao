package main;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import usuario.GerenciarUsuario;
import usuario.Usuario;

public class ProgramaPrincipal {

	private Scanner lerTeclado;
	private final static int CADASTRAR = 1;
	private final static int EDITAR = 2;
	private final static int LISTAR = 3;
	private final static int REMOVER = 4;
	private final static int SAIR = 9;
	private GerenciarUsuario gerUsuario;
	
	
	public ProgramaPrincipal() {
		lerTeclado = new Scanner(System.in);
		gerUsuario = new GerenciarUsuario();
	}
	
	public static void main(String[] args) {
		new ProgramaPrincipal().executar();
	}

	private void executar() {
		int opcao = 0;

		do {
			mostrarMenu();

			opcao = lerTeclado.nextInt();

			if (opcao == CADASTRAR) {
				System.out.println("Cadastrar usuário");
				cadastrar();
			} else if (opcao == EDITAR) {
				System.out.println("Editar usuário");
				editar();
			} else if (opcao == LISTAR) {
				System.out.println("Listar usuários");
				listar();
			} else if (opcao == REMOVER) {
				System.out.println("Remover usuário");
				remover();
			}

		} while (opcao != SAIR);
		gerUsuario.fecharConexao();
	}
	
	private void editar() {
		// pedir o id para editar
		System.out.println("Digite o ID para editar: ");
		
		// ler o id
		int id = lerTeclado.nextInt();
		
		// buscar o usuário no BD
		Usuario usuario = gerUsuario.findById(id);
		
		// solicitar novo nome, email
		System.out.println("Digite o novo nome: ");
		String novoNome = lerTeclado.next();
		System.out.println("Digite o novo e-mail: ");
		String novoEmail = lerTeclado.next();
		
		// setar os valores no obj
		usuario.setNome(novoNome);
		usuario.setEmail(novoEmail);
		
		// chamar o ger para atualizar o obj no BD
		gerUsuario.update(usuario);
		
		// mostrar msg de sucesso
		System.out.println("Usuário atualizado com sucesso");
	}
	
	private void remover() {
		// pedir o ID para remover
		System.out.println("Digite o id para remover: ");
		
		// ler o ID
		int idRemover = lerTeclado.nextInt();
		
		// buscar o usuário e mostra na tela
		Usuario usuario = gerUsuario.findById(idRemover);
		if ( usuario == null ) {
			System.out.println("ID informado não existe");
		}
		else {
			System.out.println("ID: " + usuario.getId());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("E-mail: " + usuario.getEmail());
			
			System.out.println("Confirma a exclusão: 0 - sim, 1 - não");
			int opcao = lerTeclado.nextInt();
			
			if ( opcao == 0 ) {
				gerUsuario.remove(idRemover);
				System.out.println("OK, removido com sucesso");
			}
			else {
				System.out.println("Cancelar");
			}
				
		}
		
		// confirmar a exclusão
		// se sim - remover e mostra msg de sucesso
		// se nao - voltar para o menu
	}
	
	private void listar() {
		List<Usuario> lista = gerUsuario.list();
		for (Usuario usuario : lista) {
			System.out.println("\nID: "
					+ usuario.getId());
			System.out.println("Nome: "
					+ usuario.getNome());
		}
		
	}

	private void cadastrar() {
		// ler os dados do usuario
		// nome
		// email
		// data de nascimento
		System.out.println("Digite o nome: ");
		String nome = lerTeclado.next();
		
		System.out.println("Digite o e-mail: ");
		String email = lerTeclado.next();
		
		System.out.println("Digite a dt nasc(dd/mm/aaaa): ");
		String dtNascimento = lerTeclado.next();
		
		// converter a data de string para localdate
		DateTimeFormatter dtf
			= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataNasc
			= LocalDate.parse(dtNascimento, dtf);
		
		// criar novo objeto da classe usuario
		Usuario user = new Usuario();
		
		// setar os valores no novo usuario
		user.setNome(nome);
		user.setEmail(email);
		user.setDataNascimento(dataNasc);
		
		// salvar o usuario no bd
		gerUsuario.create(user);
		System.out.println("Usuário cadastro com sucesso");
	}
	
	private void mostrarMenu() {
		System.out.println("\n------ SUPER CRUD ------\n");
		System.out.println("1 - Cadastrar usuário");
		System.out.println("2 - Editar usuário");
		System.out.println("3 - Listar usuários");
		System.out.println("4 - Remover usuário");
		System.out.println("9 - Sair");
	}

}

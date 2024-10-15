package main;

import java.time.LocalDate;
import java.util.List;

import console.Console;
import usuario.GerenciarUsuario;
import usuario.Usuario;

public class MenuUsuario {

	private Console console;
	private final static int CADASTRAR = 1;
	private final static int EDITAR = 2;
	private final static int LISTAR = 3;
	private final static int REMOVER = 4;
	private final static int SAIR = 9;
	private GerenciarUsuario gerUsuario;
	
	
	public MenuUsuario() {
		console = new Console();
		gerUsuario = new GerenciarUsuario();
	}
	
	public void show() {
		int opcao = 0;

		do {
			mostrarMenu();

			opcao = console.readInt();

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
	}
	
	private void editar() {

		int id = console.readInt("Digite o ID para editar: ");
		Usuario usuario = gerUsuario.findById(id);
		
		lerDadosUsuario(usuario);
		
		gerUsuario.update(usuario);
		
		System.out.println("Usuário atualizado com sucesso");
	}

	private void lerDadosUsuario(Usuario usuario) {
		String nome = console.readLine("Digite o nome: ");
		String email = console.readLine("Digite o e-mail: ");
		LocalDate dataNascimento = console.readLocalDate("Data de nascimento: ");
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setDataNascimento(dataNascimento);
	}
	
	private void remover() {
		int idRemover = console.readInt("Digite o ID para remover: ");
		
		Usuario usuario = gerUsuario.findById(idRemover);
		if ( usuario == null ) {
			System.out.println("ID informado não existe");
		}
		else {
			System.out.println("ID: " + usuario.getId());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("E-mail: " + usuario.getEmail());
			
			System.out.println("Confirma a exclusão: 0 - sim, 1 - não");
			int opcao = console.readInt();
			
			if ( opcao == 0 ) {
				gerUsuario.remove(idRemover);
				System.out.println("OK, removido com sucesso");
			}
			else {
				System.out.println("Cancelar");
			}
		}
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
		Usuario user = new Usuario();
		
		lerDadosUsuario(user);
		
		gerUsuario.create(user);
		System.out.println("Usuário cadastro com sucesso");
	}
	
	private void mostrarMenu() {
		System.out.println("\n------ GERENCIAMENTO DE USUÁRIOS ------\n");
		System.out.println("1 - Cadastrar usuário");
		System.out.println("2 - Editar usuário");
		System.out.println("3 - Listar usuários");
		System.out.println("4 - Remover usuário");
		System.out.println("9 - Voltar");
	}
	
}

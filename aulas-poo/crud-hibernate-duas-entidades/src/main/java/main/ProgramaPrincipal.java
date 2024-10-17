package main;

import org.apache.log4j.BasicConfigurator;

import console.Console;

public class ProgramaPrincipal {

	private Console console;
	private final static int MENU_USUARIO = 1;
	private final static int MENU_PRODUTO = 2;
	private final static int SAIR = 9;
	
	private MenuUsuario menuUsuario;
	private MenuProduto menuProduto;
	
	public ProgramaPrincipal() {
		console = new Console();
		menuUsuario = new MenuUsuario();
		menuProduto = new MenuProduto();
	}
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		new ProgramaPrincipal().executar();
	}

	private void executar() {
		int opcao = 0;

		do {
			mostrarMenu();

			opcao = console.readInt();

			if (opcao == MENU_USUARIO)
			{
				menuUsuario.show();
			}
			else if (opcao == MENU_PRODUTO)
			{
				menuProduto.show();
			}

		} while (opcao != SAIR);
	}
	
	private void mostrarMenu() {
		System.out.println("\n------ SUPER CRUD ------\n");
		System.out.println("1 - Gerenciamento de usuários");
		System.out.println("2 - Gerenciamento de produtos");
		System.out.println("9 - Sair");
	}

}

package main;

import java.time.LocalDate;
import java.util.Scanner;

import aluno.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Create {

	public static void main(String[] args) {

		// 1- criar conexao com o BD
		// 1.2- ler o arquivo persistense
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("xuxu");

		// 2- criar um gerenciador de entidades
		EntityManager em = emf.createEntityManager();

		// 4- abrir uma transacao
		em.getTransaction().begin();

		// 5- executar um comando
		// pra salvar um objeto no banco

		Aluno mario = new Aluno();
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println("Digite seu nome");

		String nome = lerTeclado.next();

		mario.setNome(nome);

		System.out.println("Digite seu email ");

		String email = lerTeclado.next();

		mario.setEmail(email);
		mario.setDataNascimento(LocalDate.of(2007, 9, 3));

		em.persist(mario);

		// 6- fechar a transacao
		em.getTransaction().commit();

		// 7- fechar o gerenciador de entidades
		em.close();

		// 8- fechar a conexao com o BD
		emf.close();

	}

}

package main;

import aluno.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Remove {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("xuxu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Aluno mario = em.find(Aluno.class, 1);

		em.remove(mario);

		System.out.println(mario.getNome());

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
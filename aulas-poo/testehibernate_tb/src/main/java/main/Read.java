package main;

import java.util.List;

import aluno.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Read {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("xuxu");
		EntityManager em = emf.createEntityManager();
		// slq nativo
		String slqNativo = "select * from tb_aluno; ";
		Query sql = em.createNativeQuery(slqNativo,Aluno.class);

		List<Aluno> alunos =  sql.getResultList();
		for(Aluno aluno : alunos) {
			
			System.out.println("ID: "+aluno.getId());
			System.out.println("Nome: "+aluno.getNome());
			System.out.println("Email: "+aluno.getEmail());
			System.out.println(" ");
		}
		
		//em hql
		String consultaHibernate ="from Aluno";
		Query hql = em.createQuery(consultaHibernate);
		
		List<Aluno> alunos2 =  hql.getResultList();
		for(Aluno aluno : alunos) {
			
			System.out.println("ID: "+aluno.getId());
			System.out.println("Nome: "+aluno.getNome());
			System.out.println("Email: "+aluno.getEmail());
			System.out.println(" ");
		}
		

		em.close();
		emf.close();

	}

}

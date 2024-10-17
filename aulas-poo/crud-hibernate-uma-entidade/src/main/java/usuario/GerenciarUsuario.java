package usuario;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class GerenciarUsuario {

	private EntityManagerFactory emf;
	private EntityManager em;

	public GerenciarUsuario() {
		emf = Persistence.createEntityManagerFactory("xuxu");
		em = emf.createEntityManager();

	}

	public void create(Usuario usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();

	}

	public void update(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		String sql = "from Usuario";
		Query query = em.createQuery(sql);
		return query.getResultList();

	}

	public void remove(int id) {
		Usuario usuario = findById(id);
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();

	}

	public Usuario findById(int id) {

		return em.find(Usuario.class, id);

	}

	public void fecharConexao() {
		em.close();
		emf.close();
	}

}

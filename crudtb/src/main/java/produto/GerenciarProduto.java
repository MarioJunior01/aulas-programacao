package produto;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class GerenciarProduto {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public GerenciarProduto() {
		emf = Persistence.createEntityManagerFactory("xuxu");
		em = emf.createEntityManager();
	}
	
	public void create(Produto produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}
	
	public void update(Produto produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> list() {
		String sql = "from Produto";
		Query query = em.createQuery(sql);
		return query.getResultList();
	}
	
	public void remove(int id) {
		Produto produto = findById(id);
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}
	
	public Produto findById(int id) {
		return em.find(Produto.class, id);
	}
	
	public void fecharConexao()
	{
		em.close();
		emf.close();
	}
	
}

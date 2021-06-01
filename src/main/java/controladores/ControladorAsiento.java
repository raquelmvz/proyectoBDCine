package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Asiento;

public class ControladorAsiento {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyectoFinalBDCine");
	private EntityManager em;
	private Query consulta;
	
	public void borrarAsiento(Asiento a) {
		this.em = entityManagerFactory.createEntityManager();
		Asiento aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(a)) {
			aux = this.em.merge(a);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void modificarAsiento(Asiento a) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(a);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void crearAsiento(Asiento a) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(a);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Asiento findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Asiento aux = null;
		this.consulta = em.createNativeQuery("Select * from asientos where idasientos = ?", Asiento.class);
		this.consulta.setParameter(1, pk);
		try {
			aux = (Asiento) consulta.getSingleResult();
			
		} catch (NoResultException nre) {
			aux = null;
		}
		
		this.em.close();
		return aux;
	}
	
	public List<Asiento> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Asiento.findAll");
		List<Asiento> lista = (List<Asiento>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}

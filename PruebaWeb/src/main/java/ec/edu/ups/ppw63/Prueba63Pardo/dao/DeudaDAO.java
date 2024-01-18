package ec.edu.ups.ppw63.Prueba63Pardo.dao;
import java.util.List;

import ec.edu.ups.ppw63.Prueba63Pardo.model.Cliente;
import ec.edu.ups.ppw63.Prueba63Pardo.model.Deuda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DeudaDAO 
{
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Deuda deuda) 
	{
		em.persist(deuda);
	}
	
	public void update(Deuda deuda) 
	{
		em.merge(deuda);
	}
	
	public void remove(int codigo) 
	{
		Deuda deuda = em.find(Deuda.class, codigo);
	}
	
	public Deuda read(int codigo) 
	{
		Deuda deuda = em.find(Deuda.class, codigo);
		return deuda;
	}
	
	public List<Deuda> getAll()
	{
		String jpql = "SELECT d FROM Deuda d"; //Sentencias a las entidades
		Query q = em.createQuery(jpql, Deuda.class);
		return q.getResultList();
	}
	
	public Deuda getDeudaPorCliente(String cedula) 
	{
		String jpql = "SELECT d FROM Deudas d, Clientes c WHERE d.cliente = :cedula AND c.cliente = :cedula"; //Sentencias a las entidades
		Query q = em.createQuery(jpql, Deuda.class);
		q.setParameter("cedula", cedula);
		List<Deuda> deudas = q.getResultList();
		if(deudas.size() > 0) 
		{
			return deudas.get(0);
		}
		return null;
	}
	
}

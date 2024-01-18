package ec.edu.ups.ppw63.Prueba63Pardo.business;

import java.util.List;

import ec.edu.ups.ppw63.Prueba63Pardo.dao.ClienteDAO;
import ec.edu.ups.ppw63.Prueba63Pardo.dao.DeudaDAO;
import ec.edu.ups.ppw63.Prueba63Pardo.model.Cliente;
import ec.edu.ups.ppw63.Prueba63Pardo.model.Deuda;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionDeudas 
{
	@Inject
	private DeudaDAO daoDeuda;
	
	public void guardarDeuda(Deuda deuda) 
	{
		Deuda deu = daoDeuda.read(deuda.getCodigo());
		if (deu != null) 
		{
			daoDeuda.update(deuda);
		}
		else 
		{
			daoDeuda.insert(deuda);
		}
	}
	
	public void actualizarDeuda(Deuda deuda) throws Exception 
	{
		Deuda deu = daoDeuda.read(deuda.getCodigo());
		if (deu != null) 
		{
			daoDeuda.update(deuda);
		}
		else 
		{
			throw new Exception("Deuda no existe");
		}
	}
	
	public Deuda getDeudaPorCliente(String cedula) throws Exception 
	{
		if(cedula.length() != 10) 
		{
			throw new Exception("Cedula incorrecta");
		}
		return daoDeuda.getDeudaPorCliente(cedula);
	}
	
	public void borrarDeuda(int codigo) 
	{
		daoDeuda.remove(codigo);
	}
	
	public List<Deuda> getDeudas()
	{
		return daoDeuda.getAll();
	}
}

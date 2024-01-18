package ec.edu.ups.ppw63.Prueba63Pardo.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.Prueba63Pardo.dao.ClienteDAO;
import ec.edu.ups.ppw63.Prueba63Pardo.dao.DeudaDAO;
import ec.edu.ups.ppw63.Prueba63Pardo.model.Cliente;
import ec.edu.ups.ppw63.Prueba63Pardo.model.Deuda;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup //Al momento de levantar la aplicacion se crea
public class GestionDatos 
{
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private DeudaDAO daoDeuda;
	
	@PostConstruct //Posterior a la creacion se llama a este metodo
	public void init() 
	{
		System.out.println("Iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("1105919169");
		cliente.setNombre("Samuel Pardo");
		cliente.setDireccion("Loja");
		
		daoCliente.insert(cliente);
		
		Deuda deuda = new Deuda();
		deuda.setCodigo(1);
		deuda.setCliente(cliente);
		deuda.setFechaEmision(new Date());
		deuda.setMonto(50.75);
		
		daoDeuda.insert(deuda);
		
		cliente = new Cliente();
		cliente.setCodigo(2);
		cliente.setDni("1105919388");
		cliente.setNombre("Cristian Timbi");
		cliente.setDireccion("Cuenca");
		
		daoCliente.insert(cliente);
		
		deuda = new Deuda();
		deuda.setCodigo(2);
		deuda.setCliente(cliente);
		deuda.setFechaEmision(new Date());
		deuda.setMonto(120.30);
		
		daoDeuda.insert(deuda);
		
		/*System.out.println("\n------------- Clientes");
		List<Cliente> list = daoCliente.getAll();
		for (Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/
		System.out.println("\n------------- Deudas");
		List<Deuda> list2 = daoDeuda.getAll();
		for (Deuda deu: list2) {
			System.out.println(deu);
		}
	
	}
}

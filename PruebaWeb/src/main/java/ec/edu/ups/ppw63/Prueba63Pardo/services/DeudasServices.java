package ec.edu.ups.ppw63.Prueba63Pardo.services;

import java.util.List;

import ec.edu.ups.ppw63.Prueba63Pardo.business.GestionClientes;
import ec.edu.ups.ppw63.Prueba63Pardo.business.GestionDeudas;
import ec.edu.ups.ppw63.Prueba63Pardo.model.Cliente;
import ec.edu.ups.ppw63.Prueba63Pardo.model.Deuda;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("deudas")
public class DeudasServices 
{
	@Inject
	private GestionDeudas gDeudas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Deuda deuda) 
	{
		try 
		{
			gDeudas.guardarDeuda(deuda);
			ErrorMessage error = new ErrorMessage(1, "OK");
			return Response.status(Response.Status.CREATED)
					.entity(error)
					.build();
		}
		catch (Exception e) 
		{
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Deuda deuda) 
	{
		try 
		{
			gDeudas.actualizarDeuda(deuda);
			return Response.ok(deuda).build();
		}
		catch (Exception e) 
		{
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("id") int codigo) 
	{
		try 
		{
			gDeudas.borrarDeuda(codigo);
			return "OK";
		}
		catch (Exception e) 
		{
			return "ERROR";
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getDeudas(){
		List<Deuda> deudas = gDeudas.getDeudas();
		if(deudas.size()>0)
			return Response.ok(deudas).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
}
package ec.edu.ups.ppw63.Prueba63Pardo.model;

import java.util.Date;

import ec.edu.ups.ppw63.Prueba63Pardo.model.Cliente;
import jakarta.persistence.*;

@Entity
@Table(name = "deudas")
public class Deuda 
{
	@Id
	private int codigo;
	double monto;
    private Date fechaEmision;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo")
    private Cliente cliente;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Deuda [codigo=" + codigo + ", monto=" + monto + ", fechaEmision=" + fechaEmision + ", cliente="
				+ cliente + "]";
	}
}

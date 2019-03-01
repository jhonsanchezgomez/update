package com.microservicio.service.pojoJSON;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_informacion_tarjetas database table.
 * 
 */
public class InformacionTarjetaPOJO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private byte activo;
	private double saldo;
	private Date ultimoUso;
	private List<Transaccion> transacciones;

	public InformacionTarjetaPOJO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getUltimoUso() {
		return this.ultimoUso;
	}

	public void setUltimoUso(Date ultimoUso) {
		this.ultimoUso = ultimoUso;
	}

	public List<Transaccion> getTblTransacciones() {
		return this.transacciones;
	}

	public void setTblTransacciones(List<Transaccion> tblTransacciones) {
		this.transacciones = tblTransacciones;
	}

	public Transaccion addTblTransaccione(Transaccion tblTransaccione) {
		getTblTransacciones().add(tblTransaccione);
		tblTransaccione.setTblInformacionTarjeta(this);

		return tblTransaccione;
	}

	public Transaccion removeTblTransaccione(Transaccion tblTransaccione) {
		getTblTransacciones().remove(tblTransaccione);
		tblTransaccione.setTblInformacionTarjeta(null);

		return tblTransaccione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InformacionTarjetaPOJO other = (InformacionTarjetaPOJO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InformacionTarjeta [id=" + id + ", activo=" + activo + ", saldo=" + saldo + ", ultimoUso=" + ultimoUso
				+ ", transacciones=" + transacciones + "]";
	}
	
	
	
	
	

}
package com.microservicio.service.pojoJSON;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the tbl_transacciones database table.
 * 
 */
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date fechaTransaccion;
	private String tipoTransaccion;
	private double valor;

	private InformacionTarjetaPOJO informacionTarjeta;

	public Transaccion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaTransaccion() {
		return this.fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public String getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@JsonIgnore
	public InformacionTarjetaPOJO getTblInformacionTarjeta() {
		return this.informacionTarjeta;
	}

	public void setTblInformacionTarjeta(InformacionTarjetaPOJO tblInformacionTarjeta) {
		this.informacionTarjeta = tblInformacionTarjeta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Transaccion other = (Transaccion) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", fechaTransaccion=" + fechaTransaccion + ", tipoTransaccion="
				+ tipoTransaccion + ", valor=" + valor + ", informacionTarjeta=" + informacionTarjeta + "]";
	}

	
}
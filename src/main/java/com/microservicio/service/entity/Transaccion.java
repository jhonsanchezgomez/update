package com.microservicio.service.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the tbl_transacciones database table.
 * 
 */
@Service
@Entity
@Table(name="tbl_transacciones")
@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_transaccion")
	private Date fechaTransaccion;

	@Column(name="tipo_transaccion")
	private String tipoTransaccion;

	private double valor;

	//bi-directional many-to-one association to Tarjeta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="informacion_tarjetas_id")
	@JsonIgnore
	private Tarjeta tblInformacionTarjeta;

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
	public Tarjeta getTblInformacionTarjeta() {
		return this.tblInformacionTarjeta;
	}

	public void setTblInformacionTarjeta(Tarjeta tblInformacionTarjeta) {
		this.tblInformacionTarjeta = tblInformacionTarjeta;
	}

	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", fechaTransaccion=" + fechaTransaccion + ", tipoTransaccion="
				+ tipoTransaccion + ", valor=" + valor + ", tblInformacionTarjeta=" + tblInformacionTarjeta + "]";
	}
	
	

}
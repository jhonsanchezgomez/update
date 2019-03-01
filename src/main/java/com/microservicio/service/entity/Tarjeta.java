package com.microservicio.service.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_informacion_tarjetas database table.
 * 
 */
@Service
@Entity
@Table(name="tbl_informacion_tarjetas")
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private byte activo;

	private double saldo;

	@Temporal(TemporalType.DATE)
	@Column(name="ultimo_uso")
	private Date ultimoUso;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="tblInformacionTarjeta")
	private List<Transaccion> tblTransacciones;

	public Tarjeta() {
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
		return this.tblTransacciones;
	}

	public void setTblTransacciones(List<Transaccion> tblTransacciones) {
		this.tblTransacciones = tblTransacciones;
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
	public String toString() {
		return "Tarjeta [id=" + id + ", activo=" + activo + ", saldo=" + saldo + ", ultimoUso=" + ultimoUso
				+ ", tblTransacciones=" + tblTransacciones + "]";
	}
	
	

}
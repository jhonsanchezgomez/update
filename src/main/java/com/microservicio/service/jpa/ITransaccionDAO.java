package com.microservicio.service.jpa;

import java.util.List;

import com.microservicio.service.entity.Transaccion;


public interface ITransaccionDAO {
	public Transaccion get(Long id);
	 public List<Transaccion> getAll();
	 public void post(Transaccion entity);
	 public void put(Transaccion entity, long id);
	 public void delete(Long id);
}

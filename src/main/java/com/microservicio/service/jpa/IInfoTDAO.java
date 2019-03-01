package com.microservicio.service.jpa;

import java.util.List;
import com.microservicio.service.entity.Tarjeta;


public interface IInfoTDAO {
	public Tarjeta get(Long id);
	 public List<Tarjeta> getAll();
	 public void post(Tarjeta entity);
	 public void put(Tarjeta entity, long id);
	 public void delete(Long id);

}

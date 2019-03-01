package com.microservicio.service.jpa;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.service.DAO.ITransaccion;
import com.microservicio.service.entity.Transaccion;

@Service
public class TransaccionDAO implements ITransaccionDAO{
	
	@Autowired
	private ITransaccion tDAO;
	
	@Override
	public Transaccion get(Long id) {
		// TODO Auto-generated method stub
		return tDAO.findById(id).get();
	}

	@Override
	public List<Transaccion> getAll() {
		// TODO Auto-generated method stub
		return (List<Transaccion>) tDAO.findAll();
	}

	@Override
	public void post(Transaccion entity) {
		// TODO Auto-generated method stub
		tDAO.save(entity);
	}
	
	//Error en el cast, por si algo.
	@Override
	public void put(Transaccion entity, long id) {
		tDAO.findById(id).ifPresent((x)->{
			entity.setId((int) id);
			tDAO.save(entity);
		});
		
	}

	@Override
	public void delete(Long id) {
		tDAO.deleteById(id);
		
	}
	


}

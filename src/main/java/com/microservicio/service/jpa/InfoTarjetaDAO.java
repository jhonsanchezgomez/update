package com.microservicio.service.jpa;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.service.DAO.IInfoTarjeta;
import com.microservicio.service.entity.Tarjeta;

@Service
public class InfoTarjetaDAO implements IInfoTDAO{

	@Autowired
	private IInfoTarjeta tDAO;
	
	@Override
	public Tarjeta get(Long id) {
		// TODO Auto-generated method stub
		Tarjeta ift = tDAO.findById(id).get();
		return ift;
	}

	@Override
	public List<Tarjeta> getAll() {
		// TODO Auto-generated method stub
		return (List<Tarjeta>) tDAO.findAll();
	}

	@Override
	public void post(Tarjeta entity) {
		// TODO Auto-generated method stub
		tDAO.save(entity);
	}
	
	//Error en el cast, por si algo.
	@Override
	public void put(Tarjeta entity, long id) {
		tDAO.findById(id).ifPresent((x)->{
			entity.setId(id);
			tDAO.save(entity);
		});
		
	}

	@Override
	public void delete(Long id) {
		tDAO.deleteById(id);
		
	}
	
}

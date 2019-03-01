package com.microservicio.service.DAO;

import org.springframework.data.repository.CrudRepository;

import com.microservicio.service.entity.Transaccion;

public interface ITransaccion extends CrudRepository<Transaccion, Long>{

}

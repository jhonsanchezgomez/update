package com.microservicio.service.DAO;

import org.springframework.data.repository.CrudRepository;
import com.microservicio.service.entity.Tarjeta;

public interface IInfoTarjeta extends CrudRepository<Tarjeta, Long>{

}

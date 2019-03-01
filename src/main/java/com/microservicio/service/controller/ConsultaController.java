package com.microservicio.service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.service.entity.Tarjeta;
import com.microservicio.service.jpa.IInfoTDAO;


@RestController
public class ConsultaController {
	

	@Autowired
	IInfoTDAO tDAO;
	
	@GetMapping("/example/{id}")
	public Tarjeta findTarjeta(@PathVariable(value = "id") Long id) {
		
		try {
			Tarjeta it = tDAO.get(id);
			if (it != null) {
				return it;
			}else {
				
			return null;
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
}

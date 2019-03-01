package com.microservicio.service.controllerAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservicio.service.entity.Tarjeta;

@RestController
@RequestMapping("/consulta")
public class APIController {
	
	@Autowired
	private RestTemplate rT;
	
	@RequestMapping("/{id}")
	public Tarjeta getInformation(@PathVariable("id")Long id) {
		rT = new RestTemplate();
		Tarjeta tj = rT.getForObject("http://192.165.30.79:8080/tarjeta/"+id, Tarjeta.class);
		return  tj;
	}
}

package com.microservicio.service.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.microservicio.service.entity.Tarjeta;
import com.microservicio.service.entity.Transaccion;
import com.microservicio.service.jpa.IInfoTDAO;
import com.microservicio.service.jpa.ITransaccionDAO;

@RestController
public class ActualizarController {

	@Autowired
	ITransaccionDAO trDAO;
	@Autowired
	IInfoTDAO tDAO;
	@Autowired
	private RestTemplate rT;

	ConsultaController cC;
	Transaccion t;

	@GetMapping("/actualizar_tarjeta/{monto}/{tipo}/{idT}")
	public String dataActu(@PathVariable(value = "monto") double monto, @PathVariable(value = "tipo") String tipo,
			@PathVariable(value = "idT") long idT) {
		t = new Transaccion();
		// Consumo del Microservicio de Consulta
		rT = new RestTemplate();
		Tarjeta ift = new Tarjeta();
		ift = rT.getForObject("http://192.165.30.79:8080/tarjeta/" + idT, Tarjeta.class);
		// fin

		if (ift.getActivo() == 1) {

			switch (tipo) {
			case "Descuento":
				// PERMITE VERIFICAR SI TIENE SALDO DISPONIBLE EN LA TARJETA
				if (ift.getSaldo() > 2399) {
					ift.setSaldo(ift.getSaldo() - 2400);
					t.setFechaTransaccion(new Date());
					t.setValor(2400);
					t.setTipoTransaccion(tipo);
					t.setTblInformacionTarjeta(ift);
					ift.setUltimoUso(new Date());
					//trDAO.post(t);
					trDAO.post(t);
					tDAO.put(ift, ift.getId());

					return "Transacción de tipo Descuento Exitosa";
				} else {
					return "Saldo Insuficiente";

				}

			case "Recarga":

				// VERIFICA SI EL MONTO ES MAYOR A CERO
				if (monto > 0) {

					// VERIFICA SI EL VALOR ES MULTIPLO DE 100
					if (monto % 100 == 0) {
						// VERIFICA SI EL MONTO ES MENOR AL LIMITE DE RECARGAA 150000
						if (monto <= 150000) {

							// VERIFICA SI EL MONTO MAS EL SALDO QUE POSEE ES MENOR AL LIMITE
							if ((ift.getSaldo() + monto) <= 150000) {

								t = new Transaccion();
								ift.setSaldo(ift.getSaldo() + monto);
								tDAO.put(ift, ift.getId());
								t.setFechaTransaccion(new Date());
								t.setValor(monto);
								t.setTipoTransaccion(tipo);
								t.setTblInformacionTarjeta(ift);
								trDAO.post(t);

								return "Transacción de tipo Recarga Exitosa";

							} else {
								return "Excede el limite de recarga";
							} // FIN DEL PRIMER IF

						} else {
							return "Excede el limite de recarga";
						} // FIN DEL SUGUNDO IF
					} else {

						return "Solo se permite valores de 100 en 100";

					} // FIN DEL TERCER IF

				} else {

					return "El valor de recarga no puede ser 0";
				} // FIN DEL CUARTO IF

			default:
				break;
			}

			return null;
		} else {
			return "Tarjeta Bloqueada";

		}

	}

}

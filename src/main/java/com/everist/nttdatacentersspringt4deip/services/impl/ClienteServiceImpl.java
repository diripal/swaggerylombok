package com.everist.nttdatacentersspringt4deip.services.impl;

import java.time.LocalDate;
import java.util.List;

import com.everist.nttdatacentersspringt4deip.model.Cliente;
import com.everist.nttdatacentersspringt4deip.repository.ClienteRepository;
import com.everist.nttdatacentersspringt4deip.services.ClienteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	Logger logger = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void guardar(Cliente cliente) {
		this.clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> buscarTodos() {
		return this.clienteRepository.findAll();
	}

	@Override
	public List<Cliente> buscarNombreApellido(String nombre, String apellido) {
		return this.clienteRepository.findByNombreAndApellidos(nombre, apellido);
	}

	@Override
	public void borrar(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	@Override
	@Bean
	public void crearDatosDummy() {
/* 		Cliente cliente1 = new Cliente("Antonio", "Garcia Rosales", LocalDate.of(1996, 2, 4), "64512314G");
		Cliente cliente2 = new Cliente("Jesus", "Garcia Rosales", LocalDate.of(1996, 2, 4), "5432135132A");
		Cliente cliente3 = new Cliente("Pepe", "Sanchez Garcia", LocalDate.of(1996, 2, 4), "765423132E");
		Cliente cliente4 = new Cliente("Laura", "Perez Rodriguez", LocalDate.of(1996, 2, 4), "75431231T");
		Cliente cliente5 = new Cliente("Sara", "Diaz Perez", LocalDate.of(1996, 2, 4), "897654321T");
		Cliente cliente6 = new Cliente("Antonio", "Olmo Rosales", LocalDate.of(1996, 2, 4), "987532132A");
		
		guardar(cliente1);
		guardar(cliente2);
		guardar(cliente3);
		guardar(cliente4);
		guardar(cliente5);
		guardar(cliente6); */
	}

	@Override
	public void mostrarTodos() {
		List<Cliente> buscarTodos = buscarTodos();
		
		//Con foreach
		for(Cliente cliente : buscarTodos) {
			logger.debug(cliente.toString());
		}
		
		//Con streams mucho mas potente
		buscarTodos.stream().forEach(cliente -> logger.debug(cliente.toString()));
	}
	
}
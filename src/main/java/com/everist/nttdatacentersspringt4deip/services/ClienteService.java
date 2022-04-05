package com.everist.nttdatacentersspringt4deip.services;

import java.util.List;

import com.everist.nttdatacentersspringt4deip.model.Cliente;

public interface ClienteService {
	
	void guardar(Cliente cliente);
	List<Cliente> buscarTodos();
	List<Cliente> buscarNombreApellido(String nombre, String apellido);
	void borrar(Cliente cliente);
	void crearDatosDummy();
	void mostrarTodos();
}

package com.everist.nttdatacentersspringt4deip.repository;

import java.util.List;
import java.util.Optional;

import com.everist.nttdatacentersspringt4deip.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNombreAndApellidos(String nombre, String apellidos);
	Optional<Cliente> findFirstByDni(String dni);
	
}

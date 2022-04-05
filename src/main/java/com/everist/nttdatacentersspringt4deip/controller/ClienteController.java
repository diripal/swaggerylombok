package com.everist.nttdatacentersspringt4deip.controller;

import java.util.List;

import com.everist.nttdatacentersspringt4deip.model.Cliente;
import com.everist.nttdatacentersspringt4deip.repository.ClienteRepository;
import com.everist.nttdatacentersspringt4deip.services.impl.ClienteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/")
public class ClienteController {
    @Autowired
    ClienteServiceImpl cls;

    @Autowired
    ClienteRepository cr;

    //GET
    @GetMapping("/cliente")
    public List<Cliente> listaClientes(){

        return (List<Cliente>)cls.buscarTodos();
    }
    //POST
    @PostMapping("/cliente")
    public Cliente nuevoCliente(@RequestBody Cliente cliente){

        cls.guardar(cliente);
        return cliente;
    }
    //PATCH
    @PatchMapping("/cliente/{id}")
    public String actualizarCliente(@PathVariable int id, @RequestBody Cliente cliente){

        try {
            Cliente cl = cr.getById((long)id);

            if (cliente.getNombre() != null) {
                cl.setNombre(cliente.getNombre());
            }

            if (cliente.getApellidos() != null) {
                cl.setApellidos(cliente.getApellidos());
            }

            if (cliente.getFecha() != null) {
                cl.setFecha(cliente.getFecha());
            }

            if (cliente.getDni() != null) {
                cl.setDni(cliente.getDni());
            }

            cls.guardar(cliente);

            return "Actualizado";

        } catch (Exception e) {
            //TODO: handle exception
        }

        return "No actualizado";
    }

    //DELETE
    @DeleteMapping("/cliente/{id}")
    public String borrarCliente(@PathVariable("id") int id){

        cr.delete(cr.getById((long)id));

        return "Cliente eliminado";
    }


    
}
